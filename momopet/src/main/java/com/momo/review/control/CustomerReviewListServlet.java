package com.momo.review.control;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.review.service.ReviewService;
import com.momo.exception.FindException;
import com.momo.util.PageBean;

@WebServlet("/reviewlist2")
public class CustomerReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService service;
	public CustomerReviewListServlet() {
		service = ReviewService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    String loginedId = (String) session.getAttribute("loginedId");
	    System.out.println("세션으로부터 가지고 오는 ID: " + loginedId);

//		Review r = new Review(reviewWriter);
//		List<Review> reviewList = new ArrayList<>();
//		try {
//			reviewList = service.checkReviews(r);
//			System.out.println("ReviewRepository.java로 부터 가져오는 리스트: " + reviewList);
//		} catch (Exception e) {
//		}
		//-------------------------- 
		
	    int currentPage = 1;
		String cp = request.getParameter("cp");
		if(cp != null && !cp.equals("")) {
			currentPage = Integer.parseInt(cp);
		}
		try {
			PageBean pb = service.customerFindAll(currentPage, loginedId);
			System.out.println("ReviewRepository.java로 부터 가져오는 page<T>리스트: " + pb);
			request.setAttribute("pagebean", pb);
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		
//		request.setAttribute("reviewList", reviewList);
		String path = "/jsp/checkreview2.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}