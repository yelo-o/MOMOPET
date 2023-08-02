package com.momo.board.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.momo.board.dto.Board;
import com.momo.board.service.BoardService;
import com.momo.exception.AddException;
import com.momo.exception.FindException;

@WebServlet("/addboard")
public class AddBoardServlet extends HttpServlet {
	private BoardService service;
	public AddBoardServlet() {
		service = BoardService.getInstance();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(); //세션 객체 불러옴
		//session.setAttribute("loginedId", "id93"); //테스트용 아이디 넣어봄
		String loginedId = (String)session.getAttribute("loginedId"); //기존에 로그인한 상태라면 "loginedId" 속성에 로그인한 아이디가 있을 것
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("title은 : "+ title);
		System.out.println("content은 : "+ content);
		System.out.println("로그인된 아이디는 : "+ loginedId);
		
		if (loginedId == null) {
//			request.setAttribute("msg", "로그인하세요");
			request.setAttribute("status", 0);
		} else {
			try {
				service.add(loginedId, title, content);
				request.setAttribute("status", 1);
				
			} catch(AddException e) {
				e.printStackTrace();
			}
		}
		String path = "/jsp/addboardresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
