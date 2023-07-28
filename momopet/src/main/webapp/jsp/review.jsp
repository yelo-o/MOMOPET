<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰조회</title>
</head>
<body>
	<h2>리뷰 쓰기</h2>
	<form id="writeForm">
		<input type="hidden" name="userName" value="인성">
		<textarea name="review" placeholder="리뷰를 입력하세요" required></textarea>
		<div class="star-rating">
			<img src="<c:out value="${contextPath}/images/star.png" />" data-rating="1" alt="1점" style="width: 30px; height: 30px;">
			<img src="<c:out value="${contextPath}/images/star.png" />" data-rating="2" alt="2점" style="width: 30px; height: 30px;">
			<img src="<c:out value="${contextPath}/images/star.png" />" data-rating="3" alt="3점" style="width: 30px; height: 30px;">
			<img src="<c:out value="${contextPath}/images/star.png" />" data-rating="4" alt="4점" style="width: 30px; height: 30px;">
			<img src="<c:out value="${contextPath}/images/star.png" />" data-rating="5" alt="5점" style="width: 30px; height: 30px;">
		</div>
		<input type="hidden" name="starRating" value="0" required>
		<button type="submit">리뷰 등록</button>
	</form>

	<h2>내가 쓴 리뷰 목록</h2>
	<div id="reviewList"></div>

	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="<c:out value="${contextPath}/js/reviewjq.js" />"></script>
</body>
</html>
