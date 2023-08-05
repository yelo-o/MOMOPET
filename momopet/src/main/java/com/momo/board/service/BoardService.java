package com.momo.board.service;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import com.momo.board.dao.BoardRepository;
import com.momo.board.dto.Board;
import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.exception.RemoveException;
import com.momo.util.PageBean;

public class BoardService {
	private static BoardService service = new BoardService();
	private BoardRepository repository;
	public BoardService() {
		repository = new BoardRepository();
	}
	public static BoardService getInstance() {
		return service;
	}

	public Board findByBoardNo(String boardNo) throws FindException {
		return repository.SelectByBoardNo(boardNo);
	}
	
	public void add(String loginedId, String title, String content) throws AddException {
		repository.insert(loginedId, title, content);
	}
	
	public void remove(String boardNo, String boardId) throws RemoveException {
		repository.delete(boardNo, boardId);
	}
	
	public void modify(String boardNo) throws AddException {
		repository.update(boardNo);
	}
	
	public void modify(String loginedId, String boardNo, String title, String content) throws AddException {
		repository.update(loginedId, boardNo, title, content);
	}
	
	/**
	 * 게시판 목록을 검색한다. 한 페이지당 최대 5개의 게시판을 검색한다
	 * @param currentPage 검색할 페이지
	 * @return 페이지에 해당하는 게시판 목록
	 * @throws FindException
	 */
	public com.momo.util.PageBean<Board> findAll(int currentPage) throws FindException{
		int cntPerPage = 5;
		//ex) cp: 1, 2, 3
		int endRow = currentPage*cntPerPage;
		int startRow = endRow - cntPerPage + 1;
		
		List<Board> list = repository.selectAll(startRow, endRow);
		int totalCnt = repository.count(); //총 상품수
		
		int cntPerPageGroup = 5;
//		PageBean pb = new PageBean(); //롬복활용
//		pb.setCntPerPage(cntPerPage);
//		pb.setTotalCnt(totalCnt);
//		pb.setList(list);
//		pb.setCntPerPageGroup(cntPerPageGroup);
//		pb.setCurrentPage(currentPage);
		
		PageBean<Board> pb = new PageBean<>(cntPerPage, totalCnt, list,
				                   cntPerPageGroup, currentPage);
//		return repository.selectAll(startRow, endRow);
		return pb;
	}

}
