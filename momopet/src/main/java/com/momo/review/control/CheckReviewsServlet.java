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

import com.momo.review.dto.Review;
import com.momo.review.service.ReviewService;

@WebServlet("/checkReviews")
public class CheckReviewsServlet extends HttpServlet {
	private ReviewService service;

	public CheckReviewsServlet() {
		service = ReviewService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

//		String reviewWriter = "미스터조"; // 임의의 값
	    HttpSession session = request.getSession();
	    String reviewWriter = (String) session.getAttribute("loginedId");
	    System.out.println("세션으로부터 가지고 오는 ID: " + reviewWriter);

		Review r = new Review(reviewWriter);
		

		List<Review> reviewList = new ArrayList<>();
		try {
			reviewList = service.checkReviews(r);
			System.out.println("ReviewRepository.java로 부터 가져오는 리스트: " + reviewList);
		} catch (Exception e) {
		}

		request.setAttribute("reviewList", reviewList); // reviewList를 request에 저장
		String path = "/jsp/checkreview.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		//ajax = 사용자가 넣어주는 파라미터를 서블릿으로 전달
		//시터 조회를 할 때 주소를 사용자한테 받아오는데, 그걸 ajax에서 파라미터로 서블릿으로 넘겨줘서 디비까지 접근, 주소에 해당하는 시터들을 리스트로 반환
		//ajax는 사용자의 입력값을 서블릿과 interaction해줌
	}

}
