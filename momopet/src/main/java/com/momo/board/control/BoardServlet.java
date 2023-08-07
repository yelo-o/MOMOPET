package com.momo.board.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.board.dto.Board;
import com.momo.board.service.BoardService;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service;
	public BoardServlet() {
		service = BoardService.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String s = request.getParameter("boardNo");
			System.out.println(s +"번의 게시물");
			// 조회수 갱신
			service.modify(s);
			// boardNo에 맞는 게시판 객체 불러오기 
			Board b = service.findByBoardNo(s);
			request.setAttribute("Board", b);
		} catch (FindException | AddException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		String path = "/jsp/boardview.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
