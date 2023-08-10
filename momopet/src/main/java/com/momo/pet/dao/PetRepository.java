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
	public void insert(String userId, String petType, String petName, 
			   		   String petSex, String petBreed, String petBirth,
			   		   String petRemarks) throws AddException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();
			Map<String, Object> map = new HashMap<>();
			map.put("userId", userId);
			map.put("petType", petType);
			map.put("petName", petName);
			map.put("petSex", petSex);
			map.put("petBreed", petBreed);
			map.put("petBirth", petBirth);
			map.put("petRemarks", petRemarks);
			
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