package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.customer.service.CustomerService1;

/**
 * Servlet implementation class ResultPwdServlet
 */
@WebServlet("/resultpwd")
public class ResultPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService1 service;
	public ResultPwdServlet() {
		service = CustomerService1.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		//세션얻기
		HttpSession session = request.getSession();
		String pwd = (String) session.getAttribute("pwd");
		System.out.println("sessionpwd 불러옴 : " + pwd);
	
		
		
		String path = "/jsp/aftersearchpwd.jsp";
		request.setAttribute("pwd", pwd);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		//request.setAttribute("status", status);
		rd.forward(request, response);

	}

}