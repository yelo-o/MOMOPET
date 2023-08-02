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
	
	public List<Map<String, Object>> selectSitters(int userType) throws FindException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			list = session.selectList("com.momo.customer.mapper.CustomerMapper.selectSitters",
                    userType);		
			return list;			
		} catch (Exception e) {
			throw new FindException("시터검색 실패:" + e.getMessage());
		} finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	public void insert(Customer c) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
//			session.insert("com.my.customer.mapper.CustomerMapper.insert", c);
			Map<String, Object> map = new HashMap<>();
			map.put("i", c.getId());
			map.put("p", c.getPwd());
			map.put("n", c.getName());
			map.put("e", c.getEmail());
			map.put("pn", c.getPhoneNumber());
			map.put("a", c.getAddress());
			map.put("s", c.getGender());
			map.put("r", c.getRole());
			map.put("b", c.getBirthdate());
			map.put("d", c.getDateCreated());
			map.put("u", c.getUserStatus());
			
			session.insert("com.momo.customer.mapper.CustomerMapper.insert", map);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		
//		Connection conn = null;
//		try {
//			conn = MyConnection.getConnection();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//			throw new AddException(e.getMessage());
//		}
//		String selectSQL = "INSERT INTO customer(id, pwd, name) VALUES (?, ?, ?)";
//		PreparedStatement pstmt = null;
//		
//		try {
//			pstmt = conn.prepareStatement(selectSQL);
//			pstmt.setString(1, c.getId());
//			pstmt.setString(2, c.getPwd());
//			pstmt.setString(3, c.getName());
//			pstmt.executeUpdate();
////		} catch (SQLIntegrityConstraintViolationException e) {
////			e.printStackTrace();
////			throw new AddException("회원가입 실패");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("회원가입 실패: 아이디는 최대 5자까지만 가능합니다");
//			throw new AddException("회원가입 실패: 아이디는 최대 5자까지만 가능합니다");
//		}
		
	}
	public Customer selectById(String id) throws FindException{
		
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();//Connection과 같은 뜻
			Customer c = session.selectOne("com.momo.customer.mapper.CustomerMapper.selectById",
					                       id);
						 //session.selectList()
			if(c == null) {
				throw new FindException("고객이 없습니다");
			}
			System.out.println("c.id=" + c.getId() + ", c.pwd=" + c.getPwd() + ",c.name=" + c.getName());
			return c;
		}catch(Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());			
		}finally {
			if(session != null) {
				session.close(); //DBCP에게 Connection돌려줌
			}
		}
//		Connection conn = null;
//		try {
//			conn = MyConnection.getConnection();
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		}
//		String selectSQL = "SELECT *\r\n"
//				+ "FROM customer\r\n"
//				+ "WHERE id=?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(selectSQL);
//			pstmt.setString(1, id);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				return new Customer(
//						rs.getString("id"),
//						rs.getString("pwd"),
//						rs.getString("name")
//						);
//			}else {
//				throw new FindException("고객이 없습니다");
//			}
//		} catch (SQLException e) {			
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		}
		
	}
}
