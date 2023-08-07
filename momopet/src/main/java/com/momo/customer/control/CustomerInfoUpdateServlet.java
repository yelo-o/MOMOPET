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
	private CustomerService service;
	public CustomerInfoUpdateServlet() {
		service = CustomerService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션 객체 불러옴
		String loginedId = (String)session.getAttribute("loginedId"); //세션에 저장된 로그인된 아이디 불러옴
		
		//boardeditjq.js에서 전달된 파라미터 변수로 저장
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birth = request.getParameter("birth");
		//System.out.println("서블릿으로 전달된 파라미터 userId : " + userId + ", name : " + name );
		System.out.println("phoneNumver : " + phoneNumber);
		if (loginedId == null) {
			request.setAttribute("status", 0);
		} else {
			try {
				service.infoModify(loginedId, phoneNumber, email, address, birth); //파라미터로 받은 값들 service로 전달
				request.setAttribute("status", 1);
				
			} catch(AddException e) {
				e.printStackTrace();
			}
		}
		String path = "/jsp/infoupdateresult.jsp"; //위에서 예외발생없이 제대로 끝났으면 boardeditresult.jsp로 이동
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
