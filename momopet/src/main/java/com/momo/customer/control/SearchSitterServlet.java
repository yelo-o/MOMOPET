package com.momo.customer.control;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/searchsitter")
public class SearchSitterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public SearchSitterServlet() {
		service = CustomerService.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		request.setCharacterEncoding("utf-8");
		String address = request.getParameter("address");			
		System.out.println("SearchSitterServlet에서 시작 주소: " + address);
		
		List<Customer> list = null;
		int status = 0;
		try {
			list = service.findSitters(address);
			status = 1;
			//System.out.println("서블릿 테스트 - list.get(0).getName() : " + list.get(0).getName());
			request.setAttribute("list", list);
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		String path = "/jsp/searchsitterresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("list", list);
		rd.forward(request, response);
	}
}
