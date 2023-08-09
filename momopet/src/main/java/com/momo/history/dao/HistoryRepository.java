package com.momo.history.dao;

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

import com.momo.board.dto.Board;
import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.history.dto.History;

public class HistoryRepository {
	private SqlSessionFactory sessionFactory;
	public HistoryRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void insert(String sitterId, String loginedId, String startDate, String endDate) throws AddException{
		SqlSession session = null;

		try {
			if(loginedId== null && sitterId==null) {
				throw new AddException("추가할 히스토리가 없습니다.");
			}

			Map<String, Object> map = new HashMap<>();
			System.out.println("MAP에 왔다" + loginedId+startDate+endDate+sitterId);
			map.put("userId", loginedId);
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			map.put("status", 0);
			map.put("sitterId", sitterId);
			session = sessionFactory.openSession();
			System.out.println("마이바티스 연결직전");
			int n = session.insert("com.momo.history.mapper.HistoryMapper.insert", map);
			if(n == 0) {
				throw new AddException("DB추가 실패");
			} else {
				System.out.println("DB 추가 성공했습니다");
				session.commit();
			}
			//System.out.println(h.getUserId()+h.getStartDate()+h.getEndDate()+h.getSitterId());	
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
			}
		}

	}
	
	public int count(String loginedId) throws FindException{
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			int c = session.selectOne("com.momo.history.mapper.HistoryMapper.count", loginedId);
			if (c==0) {
				throw new FindException("조회된 데이터가 없습니다.");
			}
			return c;
		} catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	public List<History> SelectById(String loginedId) throws FindException{
		List<History> list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			list = session.selectList("com.momo.history.mapper.HistoryMapper.selectById", loginedId);
			//System.out.println("1번 게시물 인덱스 불러오기 : " + list.get(0).getRn());
			return list;
		} catch(Exception e) {
			throw new FindException("히스토리 검색 실패 : " + e.getMessage());
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	
	/**
	 * 히스토리를 검색한다
	 * @param startRow
	 * @param endRow
	 * @return
	 * @throws FindException
	 */
	public List<History> selectAll(int startRow, int endRow, String loginedId) throws FindException{
		List<History> list = new ArrayList<>();
		
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Map<String, Object> map = new HashMap<>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			map.put("userId", loginedId);
			
			list = session.selectList("com.momo.history.mapper.HistoryMapper.selectAllById", map);
			//System.out.println("히스토리번호 불러오기 : " + list.get(0).getHistoryNo());
			return list;
		} catch(Exception e) {
			throw new FindException("히스토리 검색 실패 : " + e.getMessage());
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
}