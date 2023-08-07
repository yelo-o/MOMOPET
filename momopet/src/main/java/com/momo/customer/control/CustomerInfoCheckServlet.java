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
import com.momo.customer.service.CustomerService;
import com.momo.exception.FindException;

@WebServlet("/customerinfocheck")
public class CustomerInfoCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public CustomerInfoCheckServlet() {
		service = CustomerService.getInstance();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(); //세션이 있으면 있는 거 쓰고, 세션이 없으면 새로 생성함
	    //session.setAttribute("loginedId", "yshin"); //로그인버튼 누르기 귀찮아서 테스트 아이디 지정
	    String loginedId = (String)session.getAttribute("loginedId"); 
	    System.out.println("로그인된 아이디 : " + loginedId);
	    
	    try {
	    	Customer c = service.findInfo(loginedId);
	    	request.setAttribute("customer", c);
	    } catch (FindException e) {
	    	e.printStackTrace();
	    }
	    
	    String path = "/jsp/customerinfo.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
