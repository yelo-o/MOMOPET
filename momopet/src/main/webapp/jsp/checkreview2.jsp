<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>내가 받은 리뷰 보기</title>
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/checkreview.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value=" ${contextPath}" />/js/checkreviewjq2.js"></script>
</head>
<body>
<jsp:include page="./header.jsp"/>
	<c:set var="msg" value="${requestScope.msg}" />
	<c:set var="pb" value="${requestScope.pagebean}" />
	<c:set var="list" value="${pb.list}" />

	<c:set var="customerId" value="${list[0].reviewWriter}" />
	<div class="reviewList-wrap">
		<h1>"${customerId}"님이 작성한 리뷰 목록</h1>
		<table border="1">
			<tr>
				<th>내 리뷰를 받은 시터</th>
				<th>리뷰 작성일</th>
				<th>평점</th>
				<th>내가 쓴 리뷰 내용</th>
			</tr>
			<c:forEach items="${list}" var="review">
				<!-- c:set과 차이 공부 -->
				<tr align="center">
					<td>${review.userId}</td>
					<td>${review.reviewDate}</td>
					<td>${review.reviewRating}</td>
					<td>${review.reviewContent}</td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<br>

	<div class="pagegroup">
		<c:set var="currentPage" value="${pb.currentPage}" />
		<c:set var="totalPage" value="${pb.totalPage}" />
		<c:set var="startPage" value="${pb.startPage}" />
		<c:set var="endPage" value="${pb.endPage}" />

		<c:if test="${startPage > 1 }">
			<span class="page<c:out value=" ${startPage-1}" />"><</span>
		</c:if>

		<c:forEach begin="${startPage}" end="${endPage}" var="i">
			<span class="page<c:out value=" ${i}" />"><c:out value="${i}" /></span>
		</c:forEach>

		<c:if test="${totalPage > endPage}">
			<span class="page<c:out value=" ${endPage+1}" />">></span>
		</c:if>
	</div>

	<a href="${contextPath}/jsp/review.jsp">
		<button>리뷰 등록 테스트 버튼</button>
	</a>
</body>
</html>
