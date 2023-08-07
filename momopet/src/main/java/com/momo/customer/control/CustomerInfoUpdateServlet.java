package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.customer.service.CustomerService;
import com.momo.exception.AddException;

@WebServlet("/infoupdate")
public class CustomerInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public CustomerInfoUpdateServlet() {
		service = CustomerService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션 객체 불러옴
		String loginedId = (String)session.getAttribute("loginedId"); //세션에 저장된 로그인된 아이디 불러옴
		
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		if (loginedId == null) {
			request.setAttribute("status", 0);
		} else {
			try {
				service.infoModify(loginedId, phoneNumber, email, address); //파라미터로 받은 값들 service로 전달
				request.setAttribute("status", 1);
				
			} catch(AddException e) {
				e.printStackTrace();
			}
		}
		String path = "/jsp/infoupdateresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
