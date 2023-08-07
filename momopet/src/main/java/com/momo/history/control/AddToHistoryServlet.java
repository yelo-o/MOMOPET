package com.momo.history.control;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.exception.AddException;
import com.momo.history.service.HistoryService;

/**
 * Servlet implementation class AddToHistoryServlet
 */
@WebServlet("/addtohistory")
public class AddToHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HistoryService service;
	public AddToHistoryServlet() {
		service = HistoryService.getInstance();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginedId = (String) session.getAttribute("loginedId");
		String sitterId = (String) session.getAttribute("sitterId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		
		System.out.println("로그인된 아이디 : " + loginedId+ "시터찾기로 전달받은 정보 : "+sitterId+startDate+endDate);
		
		if(loginedId == null) {
			request.setAttribute("msg", "로그인하세요");
		}else {
			try {
				service.addHistory(sitterId, loginedId, startDate, endDate);
				request.setAttribute("status",1);
			} catch (AddException e) {
				e.printStackTrace();
			}
		}
		String path ="/jsp/addtohistoryresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);	
	}

}
