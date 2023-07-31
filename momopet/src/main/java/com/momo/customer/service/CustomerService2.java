package com.momo.customer.service;

import com.momo.customer.dao.CustomerRepository2;
import com.momo.customer.dto.Customer;
import com.momo.customer.dto.Histories;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

public class CustomerService2 {
	private static CustomerService2 service = new CustomerService2();
	private CustomerRepository2 repository;
	
	private CustomerService2() {
		repository = new CustomerRepository2(); 
	}
	
	public static CustomerService2 getInstance() {
		return service;
	}
	
	/**
	 * @return customer객체
	 */
	public Customer login(String id, String pwd)
			throws FindException{
		Customer c = repository.selectById(id);
		if(pwd.equals(c.getPwd())) {
			return c;
		}else {
			throw new FindException("로그인실패");
		}
	}
	
	/**
	 * DB 연결 전 dto 직접 연결 테스트
	 * @return Histories 객체
	 */
	public Histories getHistoryList() {
		return new Histories();
	}
	/**
	 * 
	 * @return
	 */
	public Histories getHistoryList(String id) {
		
		return new Histories();
	}
	
	
	
}
