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
		Map<String,Object>sitterinfo = (Map)session.getAttribute("sitterInfo");
		
		System.out.println("로그인된 아이디 : " + loginedId);
		System.out.println("요청한 시터의 정보 : "+ sitterinfo);
		
		if(loginedId == null) {
			request.setAttribute("msg", "로그인하세요");
		}else if(sitterinfo==null) {
			request.setAttribute("msg","선택한 돌보미가 없습니다");
		}else {
			try {
				service.addHistory(loginedId, loginedId, loginedId, loginedId);
				request.setAttribute("status",1);
				session.removeAttribute("sitterinfo");
			} catch (AddException e) {
				request.setAttribute("status",0);
				e.printStackTrace();
			}
		}
		String path ="/jsp/addtohistoryresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);	
		/*String sitterId = request.getParameter("sitterId");
		String name = request.getParameter("sittername");
		String sex = request.getParameter("sex");
		String introduce = request.getParameter("introduce");

	
		if(loginedId == null) {
			request.setAttribute("status",0);
		}else {
			service.addHistory(loginedId, );
		}*/
	}

}
