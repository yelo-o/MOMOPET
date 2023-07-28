<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="http://127.0.0.1:5500/webproject/personal_information.html">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="../jsp/member_updatejq.js"></script>
</head>

<body>
	<form>
		<h3>회원 정보 수정</h3>
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" readonly="readonly"
					value="${user.name }"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" readonly="readonly"
					value="${userid }"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" name="pwdpwd"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="birth"></td>
			</tr>

			<tr>
				<button class="buttonupdate">수정하기</button>
				<button class="buttonback">뒤로가기</button>

			</tr>
		</table>
	</form>
</body>
</html>