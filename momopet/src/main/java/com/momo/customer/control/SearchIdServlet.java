package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.customer.dto.Customer;
import com.momo.customer.service.CustomerService1;
import com.momo.exception.FindException;

/**
 * Servlet implementation class FindIdServlet
 */
@WebServlet("/searchid")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService1 service;

	public SearchIdServlet() {
		// service = new CustomerService();
		service = CustomerService1.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// String id = request.getParameter("id");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String userId = "";
		System.out.println(name + email);

		/*
		 * HttpSession session = request.getSession(); String
		 * searchId=request.getParameter("searchId"); session.getAttribute("searchId");
		 */

		int status = 0;
		try {
			Customer c = service.SearchId(name, email);
			status = 1;
			System.out.println("서블릿에서 불러온 c.getUserId() : " + c.getUserId());
			userId = c.getUserId();
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
		} catch (FindException e) {
			System.out.println("서블릿에서 막힘");
			e.printStackTrace();
		}


		String path = "/jsp/searchidresult.jsp"; 
		RequestDispatcher rd =request.getRequestDispatcher(path);
		request.setAttribute("status", status); 
		rd.forward(request, response);

	}

}
