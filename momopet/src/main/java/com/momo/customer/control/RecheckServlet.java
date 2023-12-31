package com.momo.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.customer.service.CustomerService;

/**
 * Servlet implementation class RecheckServlet
 */
@WebServlet("/recheck")
public class RecheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginedId = (String) session.getAttribute("loginedId");
		System.out.println("로그인된 아이디는 : " + loginedId);
		String sitterId = (String) session.getAttribute("sitterId");
		System.out.println("jsp에서 가지고 온 시터아이디 : " + sitterId);
		String name = (String) session.getAttribute("name");
		int gender = (int) session.getAttribute("gender");
		String introduce = (String) session.getAttribute("introduce");

		if(loginedId == null) {
			request.setAttribute("msg", "로그인하세요");
		}else {
			String path = "/jsp/confirmsitter.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			request.setAttribute("sitterId", sitterId);
			request.setAttribute("name", name);
			request.setAttribute("gender", gender);
			request.setAttribute("introduce", introduce);
			rd.forward(request, response);
		}
	}
}
