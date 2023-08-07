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
import com.momo.exception.FindException;

@WebServlet("/boardeditpage")
public class BoardEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service;
	public BoardEditServlet() {
		service = BoardService.getInstance();
	}
	
	/* 게시판 선택 후에 수정버튼 클릭 시, 수정페이지로 이동(게시판의 번호를 이용해서 게시판 내용을 받아온 후에 boardedit.jsp로 불러온 Board 객체 전달) */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String s = request.getParameter("boardNo");
			System.out.println("s의 값은 : "+ s);
			Board b = service.findByBoardNo(s);
			request.setAttribute("Board", b);
		} catch (FindException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}
		String path = "/jsp/boardedit.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
