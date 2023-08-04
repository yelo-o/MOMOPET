package com.momo.review.control;
import java.io.IOException;

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



@WebServlet("/review")
public class AddReviewServlet extends HttpServlet {
	
	private ReviewService service;
	public AddReviewServlet() {
		service = ReviewService.getInstance();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String reviewNo = "1"; //임의의 값
		//String reviewRating = request.getParameter("reviewRating");
//		String reviewRating = "2";
		String reviewRating = request.getParameter("reviewRating");
		String reviewContent = request.getParameter("reviewContent");
		
		HttpSession session  =  request.getSession();
		String reviewWriter = (String)session.getAttribute("loginedId");
//		session.setAttribute("loginedId", "test1");
//		String reviewWriter = (String)session.getAttribute("loginedId");
		
		String userId = "미스터조"; // 임의의 값, 결제완료 창에서 시터ID 받아야함
		
		//LocalDate now = LocalDate.now();
		//String writingDate = now.toString();
		
		Review r = new Review(reviewNo, reviewRating, reviewContent, reviewWriter, userId);
		System.out.println("jsp로부터 가져온 리뷰 내용: " + reviewContent);
		int status = 0;
		try {
			service.add(r);
			status = 1; 
		} catch (AddException e) {
		}
		
//	    // request 객체에 값을 설정하여 JSP 페이지로 전달
	  
//	    request.setAttribute("reviewRating", reviewRating);
//	    request.setAttribute("reviewContent", reviewContent);
////		
		String path = "/jsp/review.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}

}
