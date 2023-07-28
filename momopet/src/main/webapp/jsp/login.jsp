<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/login.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/loginjq.js"></script>
</head>
<body>

	<form class="login">
		<h3 class="title">로그인하기</h3>
		<div class="logo">MOMOPET</div>
		<div class="id">
			<label for="id">아이디</label> <input name="id" id="id"
				placeholder="아이디를 입력하세요"> <span><input
				type="checkbox" checked> 아이디 저장</span>
		</div>

		<div class="pwd">
			<label for="pwd">비밀번호</label> <input name="pwd" id="pwd"
				type="password">
		</div>
		<div>
		<button class="bt_login">로그인</button>
		</div>
		<ul>
			<li><a target="_blank" href="${contextPath}/jsp/findid.jsp">아이디찾기</a></li>
			<li><a target="_blank" href="${contextPath}/jsp/findpwd.jsp">비밀번호찾기</a></li>
			<li><a target="_blank" href="${contextPath}/jsp/signup.jsp">회원가입</a></li>
		</ul>

	</form>
</body>
</html>