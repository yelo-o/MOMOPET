package com.momo.customer.service;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import com.momo.customer.dao.CustomerRepository3;
import com.momo.customer.dto.Customer;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

public class CustomerService3 {
	private static CustomerService3 service = new CustomerService3();
	private CustomerRepository3 repository;
	public CustomerService3() {
		repository = new CustomerRepository3();
	}
	public static CustomerService3 getInstance() {
		return service;
	}

//	public Info findByuserId(String userId) throws FindException{
//		return repository.SelectuserId(userId);
//	}
//	
//	public void add(String loginedId, String title, String content) throws AddException {
//		repository.insert(loginedId, title, content);
//	}
	
	public Customer findAll(String loginedId) throws FindException {
		if(loginedId == null || loginedId.equals("")) {
			throw new FindException("서비스에서 로그인아이디를 못받았습니다.");
		} else {
			Customer c = repository.selectById(loginedId);
			return c;
		}
//		System.out.println("서비스에서 loginedId : " + loginedId);
//		System.out.println("서비스에서 이름 : " + c.getName());
	}
}