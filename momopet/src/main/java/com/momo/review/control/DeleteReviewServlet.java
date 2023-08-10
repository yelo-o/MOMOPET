package com.momo.review.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.exception.AddException;
import com.momo.exception.RemoveException;
import com.momo.review.dto.Review;
import com.momo.review.service.ReviewService;

@WebServlet("/deletereview")
public class DeleteReviewServlet extends HttpServlet {
	private ReviewService service;
	public DeleteReviewServlet() {
		service = ReviewService.getInstance();
	}
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session  =  request.getSession();
		String loginedId = (String)session.getAttribute("loginedId");
		
		
		
		int status = 0;
		try {
			service.delete(loginedId);
		} catch (RemoveException e) {
			e.printStackTrace();
		}
		status = 1; 
		
		request.setAttribute("status", status);
		String path = "/jsp/reviewresult.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
