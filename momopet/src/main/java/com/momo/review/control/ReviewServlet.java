package com.momo.review.control;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.exception.AddException;
import com.momo.review.dto.Review;
import com.momo.review.service.ReviewService;
import com.momo.exception.AddException;



@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
	
	private ReviewService service;
	public ReviewServlet() {
		service = ReviewService.getInstance();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int reviewRating = Integer.parseInt(request.getParameter("reviewRating"));
		String reviewContent = request.getParameter("reviewContent");
		
		HttpSession session  =  request.getSession();
		String reviewWriter = (String)session.getAttribute("loginedId");
		
		String userId = request.getParameter(reviewWriter); // 결제완료 창에서 사용자 Id값을 아직 받지 못해서 임의로 값 넣음
		
		LocalDate now = LocalDate.now();
		String writingDate = now.toString();
		
		Review reviewList = new Review(reviewNo, reviewRating, reviewContent, reviewWriter, userId, writingDate);
		service.add(reviewList);
		
		
//	    // request 객체에 값을 설정하여 JSP 페이지로 전달
//	    request.setAttribute("writingDate", writingDate);
//	    request.setAttribute("reviewRating", reviewRating);
//	    request.setAttribute("reviewContent", reviewContent);
//		
//		String path = "/jsp/receivedreview.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
	}

}
