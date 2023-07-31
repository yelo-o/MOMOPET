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

import com.momo.exception.FindException;
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
			return list;
		} catch(Exception e) {
			throw new FindException("게시글 검색 실패 : " + e.getMessage());
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
}
