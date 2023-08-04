package com.momo.customer.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.customer.dto.Customer;
import com.momo.customer.service.CustomerService;
import com.momo.exception.FindException;
import com.momo.util.PageBean;

@WebServlet("/sitterlist")
public class SitterListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public SitterListServlet() {
		service = CustomerService.getInstance();
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Map<String, Object>> list;
//		try {
//			list = service.findSitters();
//			request.setAttribute("list", list);
//		} catch (FindException e) {
//			e.printStackTrace();
//			request.setAttribute("msg", e.getMessage());
//		}
//				
//		String path = "/jsp/sitterlistresult.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		rd.forward(request, response);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Customer> list;
		try {
			list = service.findSitters();
			//System.out.println("서블릿 테스트 - list.get(0).getName() : " + list.get(0).getName());
			request.setAttribute("list", list);
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		String path = "/jsp/sitterlistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
