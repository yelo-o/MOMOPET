<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/aftersearchid.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<title>아이디확인</title>
</head>

<body>
	<c:set var="userId" value="${requestScope.userId}" />
	<section class="container">
		<header> 고객님의 아이디는 아래와 같습니다</header>
		<form>
			<div>
				아이디 :
				<c:out value="${userId}" />
			</div>
			<button>
				<a href="${contextPath}/jsp/login.jsp">로그인하기</a>
			</button>
			<button>
				<a href="${contextPath}/jsp/searchpwd.jsp">비밀번호 찾기</a>
			</button>
		</form>
	</section>
</body>
</html>