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
 * Servlet implementation class SearchPwdServlet
 */
@WebServlet("/searchpwd")
public class SearchPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService1 service;
	
	public SearchPwdServlet() {
		service = CustomerService1.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = "";
		System.out.println("searchPwdServlet : " +userId+name+email);
		
		int status = 0;
		try {
			Customer c = service.SearchPwd(userId, name, email);
			System.out.println(c+" -- ");
			status =1;
			pwd = c.getPwd();
			HttpSession session = request.getSession();
			session.setAttribute("pwd", pwd);
		} catch (FindException e) {
			e.printStackTrace();
		}
		String path = "/jsp/searchpwdresult.jsp"; 
		RequestDispatcher rd =request.getRequestDispatcher(path);
		request.setAttribute("status", status); 
		rd.forward(request, response);
	}
}
