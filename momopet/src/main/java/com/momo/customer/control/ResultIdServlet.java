package com.momo.customer.control;

import java.io.Console;
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
 * Servlet implementation class ResultIdServlet
 */
@WebServlet("/resultid")
public class ResultIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService1 service;
	public ResultIdServlet() {
		service = CustomerService1.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		//세션얻기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		System.out.println("session아이디 불러옴 : " + userId);
	
		
		
		String path = "/jsp/aftersearchid.jsp";
		request.setAttribute("userId", userId);
		RequestDispatcher rd = request.getRequestDispatcher(path);
		//request.setAttribute("status", status);
		rd.forward(request, response);

	}

}
