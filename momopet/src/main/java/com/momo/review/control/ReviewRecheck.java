package com.momo.review.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReviewRecheck
 */
@WebServlet("/reviewrecheck")
public class ReviewRecheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginedId = (String)session.getAttribute("loginedId");
		System.out.println("로그인 한 아이디는 : " + loginedId);
		String userId = request.getParameter("userId");
		System.out.println("시터 아이디: " + userId);
		String reviewNo = request.getParameter("reviewNo");
		System.out.println("삭제, 수정에 필요한 리뷰넘버: " + reviewNo);
		
		if(loginedId == null) {
			request.setAttribute("msg", "로그인하세요");
		}else {
			String path = "/jsp/confirmsitter.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
