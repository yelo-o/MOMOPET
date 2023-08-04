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
import com.momo.exception.AddException;

@WebServlet("/updateboard")
public class UpdateBoardServlet extends HttpServlet {
	private BoardService service;
	public UpdateBoardServlet() {
		service = BoardService.getInstance();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //세션 객체 불러옴
//		session.setAttribute("loginedId", "test1"); //테스트용 아이디 넣어봄
		String loginedId = (String)session.getAttribute("loginedId");
		
		String boardNo = request.getParameter("boardNo");
		String title = request.getParameter("boardTitle");
		String content = request.getParameter("boardContent");
		System.out.println("boardNo : " + boardNo);
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		
		if (loginedId == null) {
//			request.setAttribute("msg", "로그인하세요");
			request.setAttribute("status", 0);
		} else {
			try {
				service.modify(loginedId, boardNo, title, content);
				request.setAttribute("status", 1);
				
			} catch(AddException e) {
				e.printStackTrace();
			}
		}
		String path = "/jsp/boardeditresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
