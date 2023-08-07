package com.momo.history.service;



import java.util.ArrayList;
import java.util.List;

import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.history.dao.HistoryRepository;
import com.momo.history.dto.History;

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

}
