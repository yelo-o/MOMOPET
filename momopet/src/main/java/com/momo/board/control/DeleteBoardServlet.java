package com.momo.board.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.board.service.BoardService;
import com.momo.exception.RemoveException;
@WebServlet("/deleteboard")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service;
	public DeleteBoardServlet() {
		service = BoardService.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션 객체 불러옴
		request.setCharacterEncoding("utf-8");
		String boardNo = request.getParameter("boardNo");
		String boardId = request.getParameter("boardId");
		String loginedId = (String)session.getAttribute("loginedId");
		
		System.out.println("boardNo : " + boardNo + ", boardId : " + boardId);
		System.out.println("loginedId : " + loginedId);
		
		if(!loginedId.equals(boardId)) {
			request.setAttribute("status", 0);
		} else {
			try {
				service.remove(boardNo, boardId);
				request.setAttribute("status", 1);
			} catch (RemoveException e) {
				e.printStackTrace();
			}
		}
		String path = "/jsp/deleteboardresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
