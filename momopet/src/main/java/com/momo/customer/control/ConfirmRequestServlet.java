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

/**
 * Servlet implementation class ConfirmRequestServlet
 */
@WebServlet("/confirmrequest")
public class ConfirmRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public ConfirmRequestServlet() {
		service = CustomerService.getInstance();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sitterId = request.getParameter("sitterId");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		int status =0;
		try {
			Customer c= service.recheckSitter(sitterId);
			status =1;
			System.out.println("sitterList에서 불러온 sitterId"+c.getUserId());
			session.setAttribute("sitterId", sitterId);
			session.setAttribute("name", name);
			session.setAttribute("gender", gender);			
		} catch (FindException e) {
			e.printStackTrace();
		}
		System.out.println("sitterlistresult.jsp에서 가지고옴"+sitterId+name+gender);
		
		String path = "/jsp/confirmresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status",status);
		rd.forward(request, response);
	}

}