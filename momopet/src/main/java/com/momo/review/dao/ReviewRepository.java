package com.momo.review.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.review.dto.Review;

public class ReviewRepository {
	// MyBatis 연결 준비
	private SqlSessionFactory sessionFactory;

	public ReviewRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 리뷰 등록하기
	public void insert(Review r) throws AddException {
		SqlSession session = null;

		try {
			session = sessionFactory.openSession();

			Map<String, Object> map = new HashMap<>();
			// map.put("reviewNo", reviewNo); //시퀀스 처리
			map.put("reviewRating", r.getReviewRating());
			map.put("reviewContent", r.getReviewContent());
			map.put("reviewWriter", r.getReviewWriter());
			map.put("userId", r.getUserId()); // 결제완료 창에서 사용자 Id값을 아직 받지 못해서 임의로 값 넣음
//			map.put("writingDate", r.getWritingDate()); //SQL SYSDATE로 대신함

			session.insert("com.momo.review.mapper.ReviewMapper.insert", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	// 아직 테스트 아이디들이라 유저타입 정확하게 안나눠져서 조건문 안쓰고 메서드 2개 대처
//	// 시터가 받은 리뷰 목록 조회
//	public List<Review> checkReviews(Review r) throws FindException, AddException {
//		SqlSession session = null;
//		List<Review> reviewList = new ArrayList<>();
//
//		try {
//			session = sessionFactory.openSession();
//
//			Map<String, Object> map = new HashMap<>();
//			map.put("reviewWriter", r.getReviewWriter());
//
//			// selectList 메서드로 조회한 결과를 reviewList에 저장
//			reviewList = session.selectList("com.momo.review.mapper.ReviewMapper.checkReviews", map);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//		return reviewList;
//	}
//
//	// 이용자가 작성한 리뷰 목록 조회
//	public List<Review> checkReviews2(Review r) throws FindException, AddException {
//		SqlSession session = null;
//		List<Review> reviewList = new ArrayList<>();
//
//		try {
//			session = sessionFactory.openSession();
//
//			Map<String, Object> map = new HashMap<>();
//			map.put("reviewWriter", r.getReviewWriter());
//
//			// selectList 메서드로 조회한 결과를 reviewList에 저장
//			reviewList = session.selectList("com.momo.review.mapper.ReviewMapper.checkReviews2", map);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//
//		return reviewList;
//	}

	/**
	 * 게시물을 검색한다
	 * 
	 * @param startRow 시작행
	 * @param endRow   끝행
	 * @return 게시판목록
	 * @throws FindException 상품조회 시 DB와의 연결 실패 또는 SQL구문오류 시 예외발생한다
	 */
//	public List<Review> selectAll(int startRow, int endRow) throws FindException {
	public List<Review> sitterSelectAll(int startRow, int endRow, String loginedId) throws FindException {
		List<Review> list = new ArrayList<>();

		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
//			Map<String, Integer> map = new HashMap<>();
			Map<String, Object> map = new HashMap<>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			map.put("loginedId", loginedId);
//			map.put("reviewWriter", r.getReviewWriter());
			list = session.selectList("com.momo.review.mapper.ReviewMapper.sitterSelectAll", map);
			// System.out.println("1번 게시물 인덱스 불러오기 : " + list.get(0).getRn());
			return list;
		} catch (Exception e) {
			throw new FindException("리뷰 페이징 실패 : " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public List<Review> customerSelectAll(int startRow, int endRow, String loginedId) throws FindException {
		List<Review> list = new ArrayList<>();

		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
//			Map<String, Integer> map = new HashMap<>();
			Map<String, Object> map = new HashMap<>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			map.put("loginedId", loginedId);
//			map.put("reviewWriter", r.getReviewWriter());
			list = session.selectList("com.momo.review.mapper.ReviewMapper.customerSelectAll", map);
			// System.out.println("1번 게시물 인덱스 불러오기 : " + list.get(0).getRn());
			return list;
		} catch (Exception e) {
			throw new FindException("리뷰 페이징 실패 : " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * review 테이블의 튜플(행)의 개수 가져온다.
	 * 
	 * @return
	 * @throws FindException
	 */
	public int count() throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectOne("com.momo.review.mapper.ReviewMapper.count");
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
