package com.momo.history.service;



import java.util.ArrayList;
import java.util.List;

import com.momo.board.dto.Board;
import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.history.dao.HistoryRepository;
import com.momo.history.dto.History;
import com.momo.util.PageBean;

public class HistoryService {
	private static HistoryService service = new HistoryService();
	private HistoryRepository repository;
	
	public HistoryService() {
		repository = new HistoryRepository();
	}
	public static HistoryService getInstance() {
		return service;
	}
	
	
	public void addHistory(String sitterId, String loginedId, String startDate, String endDate) throws AddException{
		repository.insert(sitterId, loginedId, startDate, endDate);
	}
	public List<History> SelectById(String loginedId) throws FindException{
		List<History> list = new ArrayList<>();
		list = repository.SelectById(loginedId);
		return list;
	}
	
	/**
	 * 히스토리 목록을 검색한다. 한 페이지당 최대 5개의 히스토리를 검색한다
	 * @param currentPage
	 * @return
	 * @throws FindException
	 */
	public com.momo.util.PageBean<History> findAll(int currentPage, String loginedId) throws FindException{
		int cntPerPage = 10; //5개까지 보여줄거임
		//ex) cp: 1, 2, 3
		int endRow = currentPage*cntPerPage;
		int startRow = endRow - cntPerPage + 1;
		
		List<History> list = repository.selectAll(startRow, endRow, loginedId);
		int totalCnt = repository.count(loginedId); //총 상품수
		
		int cntPerPageGroup = 5;
		
		PageBean<History> pb = new PageBean<>(cntPerPage, totalCnt, list,
				                   cntPerPageGroup, currentPage);
		return pb;
	}

}
