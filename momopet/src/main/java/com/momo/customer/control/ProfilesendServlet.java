package com.momo.customer.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reviewWriting")
public class ProfilesendServlet extends HttpServlet {


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String review_no = request.getParameter("review_no");
		String review_rating = request.getParameter("review_rating");
		String review_content = request.getParameter("review_content");
		String review_writer = request.getParameter("review_writer");
		String review_receiver = request.getParameter("review_no");
		String review_date = request.getParameter("review_no");
	}

}
