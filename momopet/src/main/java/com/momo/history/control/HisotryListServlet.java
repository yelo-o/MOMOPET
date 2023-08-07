package com.momo.history.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.exception.FindException;
import com.momo.history.dto.History;
import com.momo.history.service.HistoryService;

@WebServlet("/historylist")
public class HisotryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HistoryService service;
	public HisotryListServlet() {
		service = HistoryService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String loginedId = (String)session.getAttribute("loginedId");
		
		try {
			List<History> h = service.SelectById(loginedId);
			request.setAttribute("list", h);
		} catch (FindException e) {
			e.printStackTrace();
		}
		
		String path = "/jsp/historylistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
