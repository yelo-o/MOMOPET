package com.momo.board.dao;

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
import com.momo.exception.RemoveException;
import com.momo.board.dto.Board;

public class BoardRepository {
	private SqlSessionFactory sessionFactory;
	public BoardRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Board SelectByBoardNo(String boardNo) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Board b = session.selectOne("com.momo.board.mapper.BoardMapper.SelectByBoardNo", boardNo);
			if(b == null) {
				throw new FindException("해당하는 게시물이 없습니다");
			}else {
				System.out.println("Boardrepository selectByBoardNo() b.boardNo=" + b.getBoardNo()
				+ ", b.boardId=" + b.getBoardId() + ", b.title=" + b.getBoardTitle());
				return b;
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	public int count() throws FindException{
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectOne("com.momo.board.mapper.BoardMapper.count");
		} catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	/**
	 * 상품목록을 검색한다
	 * @param startRow 시작행
	 * @param endRow 끝행
	 * @return 게시판목록
	 * @throws FindException 상품조회 시 DB와의 연결 실패 또는 SQL구문오류 시 예외발생한다
	 */
	public List<Board> selectAll(int startRow, int endRow) throws FindException{
		List<Board> list = new ArrayList<>();
		
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Map<String, Integer> map = new HashMap<>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			list = session.selectList("com.momo.board.mapper.BoardMapper.selectAll", map);
			//System.out.println("1번 게시물 인덱스 불러오기 : " + list.get(0).getRn());
			return list;
		} catch(Exception e) {
			throw new FindException("게시글 검색 실패 : " + e.getMessage());
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	public void insert(String loginedId, String title, String content) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
//			session.insert("com.my.customer.mapper.CustomerMapper.insert", c);
			if(title == null || title.equals("") || content == null || content.equals("")) {
				throw new Exception("제목이나 내용이 비어있습니다.");
			}
			//sql문에 입력할 HashMap 파라미터 선언
			Map<String, Object> map = new HashMap<>();
			map.put("id", loginedId);
			map.put("title", title);
			map.put("content", content);
			session.insert("com.momo.board.mapper.BoardMapper.insert", map);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	public void delete(String boardNo, String boardId) throws RemoveException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
//			session.insert("com.my.customer.mapper.CustomerMapper.insert", c);
//			if(title == null || title.equals("") || content == null || content.equals("")) {
//				throw new Exception("제목이나 내용이 비어있습니다.");
//			}
			
			Map<String, Object> map = new HashMap<>();
			map.put("boardNo", boardNo);
			map.put("boardId", boardId);
			
			session.delete("com.momo.board.mapper.BoardMapper.delete", map);
			session.commit();
		} catch(Exception e) {
			e.printStackTrace();
			throw new RemoveException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	public void update(String loginedId, String boardNo, String title, String content) throws AddException {
		System.out.println("리포지토리에서 loginedId : "+ loginedId + ", boardNo : " + boardNo + ", title: " + title + ", content : " + content);
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			
			Map<String, Object> map = new HashMap<>();
			map.put("id", loginedId);
			map.put("boardNo", boardNo);
			map.put("title", title);
			map.put("content", content);
			
			int n = session.update("com.momo.board.mapper.BoardMapper.update", map);
			if(n == 0) {
				throw new AddException("업데이트 실패했습니다");
			} else {
				session.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
}
