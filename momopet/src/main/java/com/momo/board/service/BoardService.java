package com.momo.board.service;

import java.util.List;

import com.momo.board.dao.BoardRepository;
import com.momo.board.dto.Board;
import com.momo.exception.FindException;
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

	public Board findByBoardNo(String boardNo) throws FindException{
		return repository.SelectByBoardNo(boardNo);
	}
	/**
	 * 상품목록을 검색한다. 한 페이지당 최대4개의 상품을 검색한다
	 * @param currentPage 검색할 페이지
	 * @return 페이지에 해당하는 상품목록
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
