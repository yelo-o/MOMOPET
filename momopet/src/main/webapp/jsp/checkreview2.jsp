<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>내가 작성한 리뷰 보기</title>
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/checkreview.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value=" ${contextPath}" />/js/checkreviewjq2.js"></script>
</head>
<body>
	<%-- <jsp:include page="./header.jsp" />
	<jsp:include page="./aside.jsp" /> --%>
	<c:set var="msg" value="${requestScope.msg}" />
	<c:set var="pb" value="${requestScope.pagebean}" />
	<c:set var="list" value="${pb.list}" />

	<c:set var="customerId" value="${list[0].reviewWriter}" />

	<h1>"${customerId}"님이 작성한 리뷰 목록</h1>
	<div class="reviewList-wrap">
		<table style="border: 0px solid;">
			<tr>
				<th>내 리뷰를 받은 시터 ID</th>
				<th>리뷰 작성일</th>
				<th>평점</th>
				<th>내가 작성한 리뷰</th>
			</tr>
			<c:forEach items="${list}" var="review">
				<!-- c:set과 차이 공부 -->
				<tr align="center" style="height: 50px;">
					<td style="width: 250px;">${review.reviewWriter}</td>
					<td style="width: 250px;">${review.reviewDate}</td>
					<%-- <td style="width: 100px;">${review.reviewRating}</td> --%>
					<td style="width: 250px;"><c:forEach begin="1"
							end="${review.reviewRating}" var="star">
							<img src="${contextPath}/images/star.png" alt="${star}점"
								style="width: 20px;">
						</c:forEach></td>

					<td style="width: 500px;">${review.reviewContent}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

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

<%-- 	<div style="text-align: right;">
		<a href="${contextPath}/jsp/review.jsp">
			<button>리뷰 등록 테스트 버튼</button>
		</a>
	</div> --%>
</body>
</html>
