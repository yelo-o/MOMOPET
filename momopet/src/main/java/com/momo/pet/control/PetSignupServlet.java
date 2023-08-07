package com.momo.pet.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.exception.AddException;
import com.momo.pet.dto.Pet;
import com.momo.pet.service.PetService;

@WebServlet("/petsignup")
public class PetSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PetService service;
	public PetSignupServlet() {
		service = PetService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기
		String userId = request.getParameter("id");
		int petType = Integer.parseInt(request.getParameter("petType"));
		String petName = request.getParameter("petName");
		String petSex = request.getParameter("petSex");
		String petBreed = request.getParameter("petBreed");
		String petBirth = (request.getParameter("petBirth")).toString();
		String petRemarks = request.getParameter("petRemarks");
	
		Pet p = new Pet(userId, petType, petName, petSex, petBreed, petBirth, petRemarks);
		
		//회원가입하기
		int status = 0;
		try {
			service.signup(p);
			status = 1;
		} catch (AddException e) {
			
		}
		
		//전달하기
		String path = "/jsp/signupresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}

}
