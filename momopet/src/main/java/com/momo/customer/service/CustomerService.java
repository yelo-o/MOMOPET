package com.momo.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.momo.board.dto.Board;
import com.momo.customer.dao.CustomerRepository;
import com.momo.customer.dto.Customer;
import com.momo.exception.AddException;
import com.momo.exception.FindException;
import com.momo.util.PageBean;

public class CustomerService {
	private static CustomerService service = new CustomerService();
	private CustomerRepository repository;

	private CustomerService() {
		repository = new CustomerRepository();
	}
	public static CustomerService getInstance() {
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
	
	public Customer findInfo(String loginedId) throws FindException{
		Customer c = repository.selectById(loginedId);
		return c;
	}
	
	public void infoModify(String loginedId, String phoneNumber, String email, String address, String introduce) throws AddException {
		repository.infoupdate(loginedId, phoneNumber, email, address, introduce);
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
	
	public void signup(String userId, String name, String pwd, String phoneNumber, String email, 
			String address, String birthDate, String userSex, String userType, 
			String userStatus, String introduce, String dateCreated) throws AddException {
		try {
			repository.insert(userId, name, pwd, phoneNumber, email, address, birthDate, 
					   		  userSex, userType, userStatus, introduce, dateCreated);
		} catch (AddException e) {
			throw new AddException("회원가입 실패");
		} 
	}
	
//	public List<Map<String, Object>> findSitters() throws FindException {
//		List<Map<String, Object>> list = null;
//		try {
//			list = repository.selectSitters(0);
//			return list;
//		} catch (FindException e) {
//			throw new FindException("시터가 없습니다");
//		}
//	}
	
	public List<Customer> findSitters(String address) throws FindException {
		System.out.println("서비스에서 주소 확인 : " + address);
		List<Customer> list = null;
		try {
			list = repository.selectSitters(address);
			System.out.println("service - list.get(0).getName() : " + list.get(0).getName());
			return list;
		} catch (FindException e) {
			throw new FindException("시터조회 실패");
		}
	}
	public Customer recheckSitter(String id) throws FindException{
		Customer c = repository.selectById(id);
		return c;
	}
	
}
