package com.momo.customer.control;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.customer.dto.Customer;
import com.momo.customer.service.CustomerService;
import com.momo.exception.AddException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public SignupServlet() {
		service = CustomerService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기
		String userId = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String birthDate = request.getParameter("birthdate");
		String userSex = request.getParameter("gender");
		String userType = request.getParameter("userType");
		String userStatus = "0";
		String introduce = request.getParameter("introduce");
		//String userSex = Integer.parseInt(request.getParameter("gender"));
		//String role = Integer.parseInt(request.getParameter("role"));
//		String birth = (request.getParameter("birthdate")).toString();	
		
		LocalDate now = LocalDate.now();
		String dateCreated = now.toString();
		
//		String pay = "0";
	
		//Customer c = new Customer(userId, name, pwd, phoneNumber, email, address, birthDate, pay, introduce, userSex, role, userStatus, dateCreated);
		
		//회원가입하기
		int status = 0;
		try {
			service.signup(userId, name, pwd, phoneNumber, email, address, birthDate, 
						   userSex, userType, userStatus, introduce, dateCreated);
			System.out.println("Signup Servlet : 회원가입 성공" + userId);
			status = 1;
		} catch (AddException e) {
			
		}
		
		//전달하기
		String path = "/jsp/signupresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}

}
