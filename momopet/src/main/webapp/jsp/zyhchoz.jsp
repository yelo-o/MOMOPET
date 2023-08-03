<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String loginedId = (String) session.getAttribute("loginedId");
    System.out.println("로그인된 아이디 : " + loginedId);
    com.momo.customer.service.CustomerService service = com.momo.customer.service.CustomerService.getInstance();
    try {
        com.momo.customer.dto.Customer c = service.findInfo(loginedId);
        request.setAttribute("customer", c);
        System.out.println("c.getName() : " + c.getName());
    } catch (com.momo.exception.FindException e) {
        e.printStackTrace();
    }
%>