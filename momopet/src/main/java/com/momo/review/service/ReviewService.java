package com.momo.review.service;

import java.util.List;

import com.momo.review.dto.Review;
import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.review.dao.ReviewRepository;
import com.momo.util.PageBean;

public class ReviewService {

	private static ReviewService service = new ReviewService();
	private ReviewRepository repository;

	private ReviewService() {
		repository = new ReviewRepository(); // ★ Initialize the repository
	}

	public static ReviewService getInstance() {
		return service;
	}

	// 리뷰 등록
	public void add(Review review) throws AddException {
		try {
			repository.insert(review);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}

//	// 내가 받은 리뷰 확인(시터 입장)
//	public List<Review> checkReviews(Review r) throws AddException, FindException {
//		List<Review> reviewList = new ArrayList<>();
//
//		try {
//			reviewList = repository.checkReviews(r);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AddException(e.getMessage());
//		}
//		return reviewList;
//	}
//
//	// 내가 쓴 리뷰 확인(이용자 입장)
//	public List<Review> checkReviews2(Review r) throws AddException, FindException {
//		List<Review> reviewList = new ArrayList<>();
//
//		try {
//			reviewList = repository.checkReviews2(r);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AddException(e.getMessage());
//		}
//		return reviewList;
//	}
	
	// 페이징
	// 회원들 유저타입이 제대로 입력되지 않아서 우선 조건문 쓰지 않고 sitterFindAll, customerFindAll로 나눠서 메서드 2개 선언
//	public com.momo.util.PageBean<Review> findAll(int currentPage) throws FindException {
	public com.momo.util.PageBean<Review> sitterFindAll(int currentPage, String loginedId) throws FindException {
		int cntPerPage = 10; //페이지당 보여줄 리뷰수 조정
		// ex) cp: 1, 2, 3
		int endRow = currentPage * cntPerPage;
		int startRow = endRow - cntPerPage + 1;

//		List<Review> list = repository.selectAll(startRow, endRow);
		List<Review> list = repository.sitterSelectAll(startRow, endRow, loginedId);
		int totalCnt = repository.sitterPageCount(loginedId); // 총 상품수

		int cntPerPageGroup = 5;


		PageBean<Review> pb = new PageBean<>(cntPerPage, totalCnt, list, cntPerPageGroup, currentPage);
//		return repository.selectAll(startRow, endRow);
		return pb;
	}
	
	public com.momo.util.PageBean<Review> customerFindAll(int currentPage, String loginedId) throws FindException {
		int cntPerPage = 10; //페이지당 보여줄 리뷰수 조정
		// ex) cp: 1, 2, 3
		int endRow = currentPage * cntPerPage;
		int startRow = endRow - cntPerPage + 1;

//		List<Review> list = repository.selectAll(startRow, endRow);
		List<Review> list = repository.customerSelectAll(startRow, endRow, loginedId);
		int totalCnt = repository.customerPageCount(loginedId); // 총 상품수

		int cntPerPageGroup = 5;


		PageBean<Review> pb = new PageBean<>(cntPerPage, totalCnt, list, cntPerPageGroup, currentPage);
//		return repository.selectAll(startRow, endRow);
		return pb;
	}
}
