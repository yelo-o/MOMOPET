package com.momo.history.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.momo.exception.AddException;
import com.momo.history.dao.HistoryRepository;
import com.momo.history.dto.Confirmation;
import com.momo.history.dto.SitterInfo;

public class HistoryService {
	private static HistoryService service = new HistoryService();
	private HistoryRepository repository;
	
	public HistoryService() {
		repository = new HistoryRepository();
	}
	public static HistoryService getInstance() {
		return service;
	}
	
	public void addHistory(String userId, String startDate, String endDate, String sitterId) throws AddException{
		repository.insert(userId, startDate, endDate, sitterId);
	}
}
