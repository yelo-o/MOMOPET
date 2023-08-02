package com.momo.customer.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.momo.customer.dto.Customer;
import com.momo.exception.FindException;

public class CustomerRepository3 {

	private SqlSessionFactory sessionFactory;
	
	//CustomerRepository3 호출 시에 자동으로 SQL 연결
	public CustomerRepository3() {
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
	
//	public Customer selectAll(String loginedId) throws FindException{
//		SqlSession session = null;
//		System.out.println("리포지토리에서 loginedId : " + loginedId);
//		try {
//			session = sessionFactory.openSession();
//			Customer c =
//					session.selectOne("com.momo.customer.mapper.CustomerMapper.selectAll",
//							loginedId);
//			System.out.println("리포지토리에서 이름 : " + c.getName());
//			return c;
//		} catch(Exception e) {
//			e.printStackTrace();
//			throw new FindException("아이디에 해당하는 정보가 없습니다");
//		}
//		
//	}
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
}
