package com.momo.review.service;

import java.util.ArrayList;
import java.util.List;

import com.momo.exception.AddException;
import com.momo.exception.FindException;
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

	// 리뷰 등록
	public void add(Review review) throws AddException {
		try {
			repository.insert(review);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}

	public List<Review> checkReviews(Review r) throws AddException, FindException {
		List<Review> reviewList = new ArrayList<>();

		try {
			reviewList = repository.checkReviews(r);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		return reviewList;
	}
	
	public List<Review> checkReviews2(Review r) throws AddException, FindException {
		List<Review> reviewList = new ArrayList<>();

		try {
			reviewList = repository.checkReviews2(r);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		return reviewList;
	}
}
