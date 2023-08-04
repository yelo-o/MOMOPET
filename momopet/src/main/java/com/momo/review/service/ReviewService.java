package com.momo.review.service;

import com.momo.exception.AddException;
import com.momo.review.dao.ReviewRepository;
import com.momo.review.dto.Review;

public class ReviewService {
	
	private static ReviewService service = new ReviewService();
	private ReviewRepository repository;

	public static ReviewService getInstance() {
		return service;
	}
	
	public void add(Review reviewList) throws AddException {
		try {
			repository.insert(reviewList);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	
}
