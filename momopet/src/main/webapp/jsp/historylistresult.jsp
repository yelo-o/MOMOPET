<%@page import="com.momo.history.dto.History"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/historylist.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="<c:out value="${contextPath}"/>/js/historylistjq.js"></script>
</head>

<body>
	<c:set var="msg" value="${requestScope.msg}" />
	<c:set var="pb" value="${requestScope.pagebean}" />
	<c:set var="list" value="${pb.list}" />

	<h3>히스토리 조회 목록</h3>

<%-- <c:set var="hList" value="${requestScope.list}"/> --%>
	<hr>

	<table class="historylist" style="border: 1px solid;">
	<tr><th>히스토리번호</th><th>돌보미ID(내 ID)</th><th>요청하신 보호자 ID</th><th>돌봄시작날짜</th><th>돌봄종료날짜</th><th>현황</th><th>승인버튼</th></tr>
	
	<c:forEach items="${list}" var="h">
		<c:set var="stat" value="${h.status}" />
		<fmt:formatDate var="formattedStartDate" value="${h.startDate}" pattern="yyyy-MM-dd" />
		<fmt:formatDate var="formattedEndDate" value="${h.endDate}" pattern="yyyy-MM-dd" />
		<tr>
			<%-- <td><c:out value="${h.historyNo}"/></td> --%>
			<td><c:out value="${pb.totalCnt - h.rn + 1}"/></td>
			<%-- <td><c:out value="${h.historyNo}"/></td> --%>
			<td>${h.sitterId}</td>
			<td>${h.userId}</td>
			<td><c:out value="${formattedStartDate}" /></td>
			<td><c:out value="${formattedEndDate}" /></td>
			<td>
				<c:choose>
					<c:when test="${stat==0}">&nbsp;대기중&nbsp;
					</c:when>
					<c:otherwise>&nbsp;수락&nbsp;
					</c:otherwise>
				</c:choose>
			</td>
			<td><button>승인</button>	<button>거절</button></td>
		</tr>
	</c:forEach>
	</table>
	
	<!-- 페이지 버튼 -->
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

	
</body>

</html>