package com.momo.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.momo.customer.dao.CustomerRepository;
import com.momo.customer.dto.Customer;
import com.momo.customer.dto.Histories;
import com.momo.customer.dto.History;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

public class CustomerService1 {
	private static CustomerService1 service = new CustomerService1();
	private CustomerRepository repository;

	private CustomerService1() {
		repository = new CustomerRepository();
	}
	public static CustomerService1 getInstance() {
		return service;
	}
	public Customer login(String id, String pwd)
			throws FindException{
		Customer c = repository.selectById(id);
		if(pwd.equals(c.getPwd())){
			return c; //로그인 성공
		}else {
			throw new FindException("로그인 실패");
		}
	}
	public Customer SearchId(String name, String email) throws FindException{
		Customer c = repository.selectByName(name, email);
		if(email.equals(c.getEmail())){
			System.out.println("서비스에서 SearchId() 메서드 진행");
			return c; //아이디찾기 성공
		}else {
			throw new FindException("정보가 없습니다.");
		}
	}
	public void add(String loginedId, Map<String, Integer>history) throws AddException{
		History h = new History();
		h.setHistoryNo(0);
		
		List<Histories> histories = new ArrayList<>();
		Set<String>keys = history.keySet();
		for(String historyNo : keys) {
			Histories hs = new Histories();
			hs.getH1();
			hs.getH2();
			histories.add(hs);
		}
		h.setHistoryNo(0);
		
		repository.insertrequest(null, h);
		
	}
}
