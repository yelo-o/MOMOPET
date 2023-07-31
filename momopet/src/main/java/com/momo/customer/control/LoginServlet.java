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
import com.momo.customer.service.CustomerService2;
import com.momo.exception.FindException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService2 service;
	public LoginServlet() {
		//service = new CustomerService();
		service = CustomerService2.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기
		String id =  request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//로그인 성공했을 때 Session에 기억해놓는 것
		//session 얻기
		HttpSession session = request.getSession();
		session.removeAttribute("loginedId");
		
		int status = 0;
		try {
			Customer c = service.login(id,pwd);
			status =1;
			session.setAttribute("loginedId", id);
		}catch(FindException e) {
			e.printStackTrace();
			
		}
		String path="/jsp/loginresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}

}
