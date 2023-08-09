<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>내가 받은 리뷰 보기</title>
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/checkreview.css">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/layout.css">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/aside.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value=" ${contextPath}" />/js/checkreviewjq.js"></script>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<br>
	<jsp:include page="./aside.jsp" />
	<c:set var="msg" value="${requestScope.msg}" />
	<c:set var="pb" value="${requestScope.pagebean}" />
	<c:set var="list" value="${pb.list}" />

	<c:set var="sitterId" value="${list[0].userId}" />
	

	<h1>"${sitterId}"님이 받은 리뷰 목록</h1>
	<div class="reviewList-wrap">
		<table border="0">
			<tr>
				<th>리뷰 작성자</th>
				<th>리뷰 받은 날짜</th>
				<th>평점</th>
				<th>내가 받은 리뷰 내용</th>
			</tr>
			<c:forEach items="${list}" var="review">
				<tr align="center" style="height: 50px;">
					<td style="width: 200px;">${review.reviewWriter}</td>
					<td style="width: 200px;">${review.reviewDate}</td>
					<td style="width: 100px;">${review.reviewRating}</td>
					<td style="width: 500px;">${review.reviewContent}</td>
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
		<c:set var="cntPerPageGroup" value="${pb.cntPerPageGroup}"/>

		<c:if test="${startPage > 1 }">
			<span class="page<c:out value=" ${startPage-1}" />"><</span>
		</c:if>
		
		<c:if test="${totalPage} < ${cntPerPageGroup}">
			<c:forEach begin="${startPage}" end="${endPage}" var="i">
				<span class="page<c:out value=" ${i}" />"><c:out value="${i}" /></span>
			</c:forEach>
		</c:if>
		

		<c:forEach begin="${startPage}" end="${endPage}" var="i">
			<span class="page<c:out value=" ${i}" />"><c:out value="${i}" /></span>
		</c:forEach>

		<c:if test="${totalPage > endPage}">
			<span class="page<c:out value=" ${endPage+1}" />">></span>
		</c:if>
	</div>

	
	<div style="text-align: right;">
	<a href="${contextPath}/jsp/review.jsp">
		<button>리뷰 등록 테스트 버튼</button>
	</a>
	</div>
</body>
</html>
