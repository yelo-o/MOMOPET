package com.momo.customer.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.customer.service.CustomerService1;
import com.momo.exception.AddException;

/**
 * Servlet implementation class RequestSitterServlet
 */
@WebServlet("/requestsitter")
public class RequestSitterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService1 service;
	public RequestSitterServlet() {
		service= CustomerService1.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("loginedId");
		String loginedId = (String)session.getAttribute("loginedId");
		String hn = request.getParameter("historyNo");
		String id = request.getParameter("userId");
		String userType=request.getParameter("usertype");
		
		
		if(hn !=null && !hn.equals("")) {
		int	historyNo=Integer.parseInt(hn);
		}
		Map<String, Integer>history = (Map)session.getAttribute("history");
		if(history == null) {
			history =  new HashMap<>();
			session.setAttribute("history", history);
		}
		try {
			service.add(loginedId, history);
		} catch (AddException e) {
			e.printStackTrace();
		}
		System.out.println("히스토리내역"+history);	
	}

}
