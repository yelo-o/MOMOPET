<%@page import="com.momo.history.dto.History"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h3>히스토리 조회 목록</h3>

<c:set var="hList" value="${requestScope.list}"/>
<hr>
<table class="historylist" style="border: 1px solid;">
<tr><th>히스토리번호</th><th>돌보미id</th><th>보호자id</th><th>돌봄시작날짜</th><th>돌봄종료날짜</th><th>현황</th><th>승인버튼</th></tr>

<c:forEach items="${hList}" var="list">
<fmt:formatDate var="formattedStartDate" value="${list.startDate}" pattern="yyyy-MM-dd" />
<fmt:formatDate var="formattedEndDate" value="${list.endDate}" pattern="yyyy-MM-dd" />
<tr>
	<td>${list.historyNo}</td>
	<td>${list.sitterId}</td>
	<td>${list.userId}</td>
	<td><c:out value="${formattedStartDate}" /></td>
	<td><c:out value="${formattedEndDate}" /></td>
	<td>${list.status}</td>
	<td><button>승인</button>	<button>거절</button></td>
</tr>
</c:forEach>
</table>

	
</body>

</html>