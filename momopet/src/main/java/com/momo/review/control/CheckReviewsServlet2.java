package com.momo.review.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.exception.AddException;
import com.momo.review.dto.Review;
import com.momo.review.service.ReviewService;

@WebServlet("/checkReviews2")
public class CheckReviewsServlet2 extends HttpServlet {
	private ReviewService service;
	private static final long serialVersionUID = 1L; 

	public CheckReviewsServlet2() {
		service = ReviewService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

//		String reviewWriter = "미스터조"; // 임의의 값
	    HttpSession session = request.getSession();
	    String reviewWriter = (String) session.getAttribute("loginedId");
		System.out.println(reviewWriter);

		Review r = new Review(reviewWriter);

		List<Review> reviewList = new ArrayList<>();
		try {
			reviewList = service.checkReviews2(r);
			System.out.println(reviewList);
		} catch (Exception e) {
		}

		request.setAttribute("reviewList", reviewList); // reviewList를 request에 저장
		String path = "/jsp/checkreview2.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
