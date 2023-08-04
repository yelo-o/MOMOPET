package com.momo.review.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.momo.exception.AddException;
import com.momo.review.dto.Review;

public class ReviewRepository {
	private SqlSessionFactory sessionFactory;

	public ReviewRepository() {
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void insert(Review r) throws AddException {
		SqlSession session = null;
		
		try {
			session = sessionFactory.openSession();
			
			Map<String, Object> map = new HashMap<>();
			
			//map.put("reviewNo", reviewNo);
			map.put("reviewRating", r.getReviewRating());
			map.put("reviewContent", r.getReviewContent());
			map.put("reviewWriter", r.getReviewWriter());
			map.put("userId", r.getUserId()); // 결제완료 창에서 사용자 Id값을 아직 받지 못해서 임의로 값 넣음
			//map.put("writingDate", rl.getWritingDate()); //SQL SYSDATE로 대신함
			
			session.insert("com.momo.review.mapper.ReviewMapper.insert", map);
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
		
		
		