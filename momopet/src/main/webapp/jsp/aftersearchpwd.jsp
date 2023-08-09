<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/aftersearchpwd.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/searchpwdjq.js"></script>
<title>비밀번호확인</title>
</head>
<body>
 <jsp:include page="./header.jsp"/>
	<c:set var="pwd" value="${requestScope.pwd}" />
	<section class="container">
		<header> 고객님의 비밀번호는 아래와 같습니다</header>
		<form>
			<div>
				비밀번호 :
				<c:out value="${pwd}" />
			</div>
			<button>
				<a href="${contextPath}/jsp/login.jsp">로그인하기</a>
			</button>
			<%-- <button>
				<a href="${contextPath}/jsp/searchpwd.jsp">비밀번호 설정하기</a> --%>
			</button>
		</form>
	</section>
	     <%@include file="./footer.jsp" %>
</body>
</html>