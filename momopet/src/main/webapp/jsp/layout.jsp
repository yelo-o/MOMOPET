<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>레이아웃</title>
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/layout.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<%-- <script src="<c:out value="${contextPath}"/>/js/layoutjq.js"></script> --%>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<br><br><br><br><br>
	<div class="usepetsitter">
		<div class="parent">언제 어디서든 펫시터를 부르세요</div>
		<br>
		<div class="child">혼자 남겨진 반려동물을 생각하며, 외출을 망설인 적이 있으신가요? 이제
			MOMOPET에서 펫시터에게 맡기고, 여러분의 소중한 일상을 마음 편히 보내세요.</div>

	</div>

	<%@ include file="./footer.jsp"%>
</body>
</html>