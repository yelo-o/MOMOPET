package com.momo.customer.service;

import java.util.List;
import java.util.Map;

import com.momo.customer.dao.CustomerRepository;
import com.momo.customer.dto.Customer;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

public class CustomerService {
//	private CustomerRepository repository;
	private static CustomerService service = new CustomerService();
	private CustomerRepository repository;

	private CustomerService() {
		repository = new CustomerRepository();
	}
	public static CustomerService getInstance() {
		return service;
	}
	public List<Map<String, Object>> findSitters() throws FindException {
		List<Map<String, Object>> list = null;
		try {
			list = repository.selectSitters(0);
			return list;
		} catch (FindException e) {
			throw new FindException("시터가 없습니다");
		}
	}
	public void signup(Customer c) throws AddException {
		try {
			repository.insert(c);
		} catch (AddException e) {
			throw new AddException("회원가입 실패");
		} 
		
	}
	public void idDupChk(String id) throws FindException {
		Customer c = null;
		try {
			//id에 해당 고객이 있는 경우(중복된 경우)
			c = repository.selectById(id);
		}catch(FindException e) { 
			//id에 해당 고객이 없는 경우(id사용가능한 경우)
		}
		
		if(c != null) {
			throw new FindException("이미 사용중인 아이디입니다");
		}
		
	}
	public Customer login(String id, String pwd) throws FindException {
		Customer c = repository.selectById(id);	
		if(pwd.equals(c.getPwd())) {
			return c;
		} else {
			throw new FindException("로그인 실패");
		}
	}
}
