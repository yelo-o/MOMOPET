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
			map.put("status", 1);
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

			/*
			 * try { session = sessionFactory.openSession(); History h =
			 * session.selectOne("com.momo.history.mapper.HistoryMapper.selectById",
			 * loginedId); if(h==null) { throw new FindException("로그인하세요"); }
			 * System.out.println("로그인된 아이디 : "+loginedId); return h; }catch(Exception e) {
			 * throw new FindException("히스토리 검색 실패:"+e.getMessage()); }finally { if(session
			 * !=null) { session.close(); }
			 */
		}

	}
}