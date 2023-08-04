package com.momo.pet.dao;

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
import com.momo.pet.dto.Pet;

public class PetRepository {
	private SqlSessionFactory sessionFactory;
	public PetRepository() {
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
	public void insert(Pet p) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Map<String, Object> map = new HashMap<>();
			map.put("i", p.getUserId());
			map.put("t", p.getPetType());
			map.put("n", p.getPetName());
			map.put("s", p.getPetSex());
			map.put("b", p.getPetBreed());
			map.put("bi", p.getPetBirth());
			map.put("r", p.getPetRemarks());
			
			session.insert("com.momo.pet.mapper.PetMapper.signup", map);
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
}