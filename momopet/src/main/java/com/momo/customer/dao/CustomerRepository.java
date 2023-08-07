package com.momo.customer.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
			if(c == null) {
				throw new FindException("고객이 없습니다");
			}
			System.out.println("c.id=" + c.getUserId() + ", c.pwd=" + c.getPwd() + ",c.name="+c.getName());
			System.out.println("리포지토리에서 c.getBirth() : " + c.getBirthDate());
			return c;
		}catch(Exception e) {
//			e.printStackTrace();
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
	public void insert(Customer c) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Map<String, Object> map = new HashMap<>();
			map.put("i", c.getUserId());
			map.put("p", c.getPwd());
			map.put("n", c.getName());
			map.put("e", c.getEmail());
			map.put("pn", c.getPhoneNumber());
			map.put("a", c.getAddress());
			map.put("s", c.getUserSex());
			map.put("r", c.getRole());
			map.put("b", c.getBirthDate());
			map.put("d", c.getDateCreated());
			map.put("u", c.getUserStatus());
			
			session.insert("com.momo.customer.mapper.CustomerMapper.signup", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}	
	}
	
//	public List<Map<String, Object>> selectSitters(int userType) throws FindException {
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//		SqlSession session = null;
//		try {
//			session = sessionFactory.openSession();
//			list = session.selectList("com.momo.customer.mapper.CustomerMapper.selectSitters",
//                    userType);		
//			return list;			
//		} catch (Exception e) {
//			throw new FindException("시터검색 실패:" + e.getMessage());
//		} finally {
//			if(session != null) {
//				session.close();
//			}
//		}
//	}
	
	public List<Customer> selectSitters(String address) throws FindException {
		System.out.println("리포지토리에서 주소 확인 : " + address);
		List<Customer> list = new ArrayList<>();
		
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			
			Map<String, Object> map = new HashMap<>();
			map.put("a", address);
			
			list = session.selectList("com.momo.customer.mapper.CustomerMapper.selectSitters", map);		
			System.out.println("repository - list.get(0).getName() : " + list.get(0).getName());
			return list;
		} catch (Exception e) {
			throw new FindException("시터 검색 실패: " + e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	public int countSitters() throws FindException{
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			return session.selectOne("com.momo.customer.mapper.CustomerMapper.countSitters");
		} catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if(session!=null) {
				session.close();
			}
		}
	}
	
	
	public void infoupdate(String loginedId, String phoneNumber, String email, String address) throws AddException {
		System.out.println("리포지토리에서 loginedId : "+ loginedId + ", email : " + email + ", address: " + address);
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			
			Map<String, Object> map = new HashMap<>();
			map.put("id", loginedId);
			map.put("phoneNumber", phoneNumber);
			map.put("email", email);
			map.put("address", address);
			
			int n = session.update("com.momo.customer.mapper.CustomerMapper.infoupdate", map); //성공하면 n = 1로 받고, 실패하면 n = 0으로 받음 
			if (n == 0) {
				throw new AddException("업데이트 실패했습니다");
			} else {
				session.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	
	
	
}