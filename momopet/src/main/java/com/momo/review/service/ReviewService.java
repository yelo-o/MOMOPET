package com.momo.review.service;

import com.momo.exception.AddException;
import com.momo.review.dao.ReviewRepository;
import com.momo.review.dto.Review;

public class ReviewService {
	
	private static ReviewService service = new ReviewService();
	private ReviewRepository repository;
    private ReviewService() {
        repository = new ReviewRepository(); // ★ Initialize the repository
    }
	public static ReviewService getInstance() {
		return service;
	}
	
	public void add(String reviewNo, String reviewRating, String reviewContent, String reviewWriter, String userId) throws AddException {
		try {
			repository.insert(reviewNo, reviewRating, reviewContent, reviewWriter, userId);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	
}
