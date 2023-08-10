package com.momo.history.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.exception.AddException;
import com.momo.history.service.HistoryService;

@WebServlet("/updatehistorystatus")
public class UpdateHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HistoryService service;
	public UpdateHistoryServlet() {
		service = HistoryService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String historyNo = request.getParameter("historyNo");
		String hstat = request.getParameter("status");
		/*
		 * System.out.println("**--서블릿에서 받아 온 데이터--**");
		 * System.out.println("historyNo : " + historyNo);
		 * System.out.println("status : " + hstat);
		 */
		
		request.setAttribute("status", 0);
		
		try {
			service.updateHistoryStatus(historyNo, hstat);
			request.setAttribute("status", 1);
			
		} catch (AddException e) {
			e.printStackTrace();
		}
		
		String path = "/jsp/historyupdateresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
