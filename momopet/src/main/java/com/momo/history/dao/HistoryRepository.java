package com.momo.history.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.momo.exception.AddException;
import com.momo.history.dto.History;

public class HistoryRepository {
	private SqlSessionFactory sessionFactory;
	public HistoryRepository() {
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
	public History insert(String loginedId, String startDate, String endDate, String sitterId) throws AddException{
		SqlSession session = null;
		Map<String, Object> param = new HashMap<>();
		System.out.println("MAP에 왔다" + loginedId+startDate+endDate+sitterId);
		param.put("userId", loginedId);
		param.put("startDate", startDate);
		param.put("EndDate", endDate);
		param.put("staus", 1);
		param.put("sitterId", sitterId);
		
		try {
		session = sessionFactory.openSession();
		System.out.println("마이바티스 연결직전");
		History co = 
				session.selectOne("com.momo.history.mapper.HistoryMapper.insertHistory", param);
		if(co==null) {
			throw new AddException("추가할 고객이없습니다.");
		}
		System.out.println(co.getUserId()+co.getStartDate()+co.getEndDate());	
		return co;
		}catch(Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}finally {
			if(session != null) {
				session.close();
				session.commit();
			}
		}
		
	}
}