<%@page import="com.momo.customer.dto.Customer"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String id = request.getParameter("user_id");
CustomerService3 service = new CustomerService3();
Customer dto =service.service(id);

%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="../js/informationcheckjq.js"></script>
</head>
<body>
	<h3>내 정보 확인</h3>
	<form class="my">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" readonly="readonly"
					value="${dto.getuser_id}"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" readonly="readonly"
					value="${customer.pwd}"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" readonly="readonly"
					value="${customer.name}"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email" readonly="readonly"
					value="${customer.email}"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone_number" readonly="readonly"
					value="${customer.phone_number}"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" readonly="readonly"
					value="${customer.address}"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth" readonly="readonly"
					value="${customer.birth_date}"></td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td><input type="text" name="introduct" readonly="readonly"
					value="${customer.introduce}"></td>
			</tr>
			<tr>
				<td>시급</td>
				<td><input type="text" name="introduct" readonly="readonly"
					value="${customer.pay}"></td>
			</tr>

		</table>
		<button class="button">회원수정하기</button>
	</form>
</body>
</html>