package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.customer.service.CustomerService3;

@WebServlet("/profilesend")
public class ProfileSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService3 service;
	public ProfileSendServlet() {
		service = CustomerService3.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginedId = (String) session.getAttribute("loginedId");
		System.out.println("로그인된 아이디 : " + loginedId);
	}
		
		

}
