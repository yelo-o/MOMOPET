<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>내가 받은 리뷰 보기</title>
</head>
<body>
    <c:set var="customerId" value="${reviewList[0].reviewWriter}" />
	<h1>"${customerId}"님이 작성한 리뷰 목록</h1>
	<table border="1">
		<tr>
			<th>내 리뷰를 받은 시터</th>
			<th>리뷰 등록 번호</th>
			<th>리뷰 작성일</th>
			<th>평점</th>
			<th>내가 쓴 리뷰 내용</th>
		</tr>
		<c:forEach items="${reviewList}" var="review">
			<tr align="center">
				<td>${review.userId}</td>
				<td>${review.reviewNo}</td>
				<td>${review.writingDate}</td>
				<td>${review.reviewRating}</td>
				<td>${review.reviewContent}</td>
			</tr>
			
		</c:forEach>
	</table>
	<br>

	<a href="${contextPath}/jsp/review.jsp">
		<button>리뷰 등록 테스트 버튼</button>
	</a>
</body>
</html>
