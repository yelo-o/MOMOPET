package com.momo.board.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.board.service.BoardService;
import com.momo.exception.FindException;
import com.momo.util.PageBean;

@WebServlet("/boardlist")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service;
	public BoardListServlet() {
		service = BoardService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = 1;
		String cp = request.getParameter("cp");
		if(cp != null && !cp.equals("")) {
			currentPage = Integer.parseInt(cp);
		}
		try {
			PageBean pb = service.findAll(currentPage);
			request.setAttribute("pagebean", pb);
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		String path = "/jsp/board.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
