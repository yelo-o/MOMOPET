package com.momo.customer.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.momo.customer.dto.Customer;
import com.momo.customer.service.CustomerService;
import com.momo.exception.AddException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public SignupServlet() {
//		service = new CustomerService();
		service = CustomerService.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		int gender = Integer.parseInt(request.getParameter("gender"));
		int role = Integer.parseInt(request.getParameter("role"));
		String birthdate = (request.getParameter("birthdate")).toString();		
		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
//		LocalDateTime ldt = LocalDateTime.now();  
		
		
//		Date date = Calendar.getInstance().getTime();  
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
//        String dateCreated = dateFormat.format(date);  
        
//        Date date = new Date(Calendar.getInstance().getTime().getTime());
//        String dateCreated = date.toString();
		
//		Date date = new Date();
//      SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
//      String dateCreated = format.format(date);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dateCreated = sdf.getInstance();
//      Calendar today = Calendar.getInstance();
      
//      String dateCreated = "2023-08-01";
        
		LocalDate now = LocalDate.now();
		String dateCreated = now.toString();
		
		int userStatus = 0;
	
		Customer c = new Customer(id, pwd, name, email, phoneNumber, address, gender, role, birthdate, dateCreated, userStatus);
		
		//회원가입하기
		int status = 0;
		try {
			service.signup(c);
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
