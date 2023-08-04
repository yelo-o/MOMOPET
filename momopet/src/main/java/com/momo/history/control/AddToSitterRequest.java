package com.momo.history.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToSitterRequest
 */
@WebServlet("/addtositterrequest")
public class AddToSitterRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sitterId = request.getParameter("sitterId");
		String name = request.getParameter("name");
		String introduce  = request.getParameter("introduce");
		String startDate = request.getParameter("startDate");
		String endDate= request.getParameter("endDate");
		
		HttpSession session = request.getSession();
		Map<String, Object>sitterInfo = (Map)session.getAttribute("sitterInfo");
		if(sitterInfo==null) {
			sitterInfo = new HashMap<>();
			session.setAttribute("sitterinfo", sitterInfo);
		}
		System.out.println("sitterinfo : " +sitterInfo);
		
		
	}

}
