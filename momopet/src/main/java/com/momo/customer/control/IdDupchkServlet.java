package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.customer.service.CustomerService;
import com.momo.exception.FindException;

@WebServlet("/iddupchk")
public class IdDupchkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public IdDupchkServlet() {
//		service = new CustomerService();
		service = CustomerService.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기
		String id = request.getParameter("id");
		
		//아이디중복확인하기
		int status = 0;
		try {
			service.idDupChk(id);
			status = 1;
			
		} catch (FindException e) {

		}
		
		//전달하기
		String path = "/jsp/iddupchkresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
		
	}

}
