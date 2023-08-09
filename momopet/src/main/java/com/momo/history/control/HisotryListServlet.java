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
import com.momo.util.PageBean;

@WebServlet("/historylist")
public class HisotryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HistoryService service;
	public HisotryListServlet() {
		service = HistoryService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		String cp = request.getParameter("cp");
		HttpSession session = request.getSession();
		String loginedId = (String)session.getAttribute("loginedId");
		
		if(cp != null && !cp.equals("")) {
			currentPage = Integer.parseInt(cp);
		}
		
		try {
			PageBean pb = service.findAll(currentPage, loginedId);
			request.setAttribute("pagebean", pb);
			
			/*
			 * if(pb == null) { throw new FindException("조회된 데이터가 없습니다."); }
			 */
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		
		String path = "/jsp/historylistresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
