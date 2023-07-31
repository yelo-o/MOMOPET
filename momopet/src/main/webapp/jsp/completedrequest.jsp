<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/completedrequest.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/completedrequest.js"></script>
<title>돌보미요청신청완료</title>
</head>
<body>
	<section class="container">
		<header> 돌보미 요청이 완료되었습니다.</header>
		<p>돌보미님의 수락을 기다려주세요</p>
		<form>
			<button class="backtomain">메인화면으로 가기</button>
			<button class="backtositter">돌보미찾기화면으로 돌아가기</button>
		</form>

	</section>
</body>
</html>