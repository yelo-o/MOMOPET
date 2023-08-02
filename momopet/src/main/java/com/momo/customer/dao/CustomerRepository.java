package com.momo.customer.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.momo.customer.dto.Customer;
import com.momo.customer.dto.History;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

public class CustomerRepository {
	private SqlSessionFactory sessionFactory;
	public CustomerRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory =
					new SqlSessionFactoryBuilder().build(inputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public Customer selectById(String id) throws FindException{

		SqlSession session = null;
		try {
			session = sessionFactory.openSession();//Connection과 같은 뜻
			Customer c = 
					session.selectOne(
							"com.momo.customer.mapper.CustomerMapper.selectById", 
							id);
			//session.selectList()
			if(c == null) {
				throw new FindException("고객이 없습니다");
			}
			System.out.println("c.id=" + c.getUserId() + ", c.pwd=" + c.getPwd() + ",c.name="+c.getName());
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());			
		}finally {
			if(session != null) {
				session.close(); //DBCP에게 Connection돌려줌
			}
		}
	}
	public Customer selectByName(String name, String email) throws FindException{
		SqlSession session = null;
		Map<String, Object> param =new HashMap<>();
		System.out.println("map까지 왔다" + name+ ":" + email);
		param.put("name", name);
		param.put("email", email);
		try {
			session = sessionFactory.openSession(true);//Connection과 같은 뜻
			System.out.println("마이바티스 연결 직전");
			Customer c = 
					session.selectOne("com.momo.customer.mapper.CustomerMapper.selectByName", param);
			if(c == null) {
				throw new FindException("고객이 없습니다");
			}
			System.out.println("c.id=" + c.getUserId() + ", c.name=" + c.getName() + ",c.email="+c.getEmail());
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());			
		}finally {
			if(session != null) {
				session.close(); //DBCP에게 Connection돌려줌
			}
		}
	}
	public Customer searchPwd(String userid, String name, String email) throws FindException{
		SqlSession session = null;
		Map<String, Object> param = new HashMap<>();
		System.out.println("Map에 왔다." +userid +email);
		param.put("id", userid);
		param.put("name", name);
		param.put("email", email);
		try {
			session = sessionFactory.openSession(true);//Connection과 같은 뜻
			System.out.println("마이바티스 연결 직전");
			Customer c = 
					session.selectOne("com.momo.customer.mapper.CustomerMapper.searchPwd", param);
			if(c == null) {
				throw new FindException("고객이 없습니다");
			}
			System.out.println("c.id=" + c.getUserId() + ", c.name=" + c.getName() + ",c.email="+c.getEmail());
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());			
		}finally {
			if(session != null) {
				session.close(); //DBCP에게 Connection돌려줌
			}
		}
	}
	public void insertrequest(SqlSession session, History h) throws AddException{
		try {
			session.insert("com.momo.customer.mapper.HistoryMapper.inserthistory");
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		
	}
}