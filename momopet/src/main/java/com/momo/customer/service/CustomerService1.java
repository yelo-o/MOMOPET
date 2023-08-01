package com.momo.customer.service;

import com.momo.customer.dao.CustomerRepository;
import com.momo.customer.dto.Customer;
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
	public Customer findId(String name, String email) throws FindException{
		Customer c = repository.selectByName(;
		if(email.equals(c.getEmail())){
			System.out.println("서비스에서 findId() 메서드 진행");
			return c; //아이디찾기 성공
		}else {
			throw new FindException("정보가 없습니다.");
		}
	}
}
