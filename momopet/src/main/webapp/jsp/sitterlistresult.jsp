<%@page import="java.util.Map"%>
<%@page import="com.momo.customer.dto.Customer"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <%-- <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/searchsitter.css"> --%>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="<c:out value="${contextPath}"/>/js/searchsitterjq.js"></script>
</head>

<body>
	<h3>시터 조회 목록</h3>
	
<%-- 	<%
	String msg = (String)request.getAttribute("msg");
	if(msg != null){
	%><%=msg%>
	<%
	return;
	}
	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");
	%>   --%>

	<c:set var="msg" value="${requestScope.msg}"/>
	<c:set var="sList" value="${requestScope.list}"/>

	<c:choose>
		<c:when test="${!empty msg}">
			<h3>시터 목록 검색 실패:<c:out value="${msg}" /></h3>
		</c:when>

		<c:otherwise>
			<table class="sitterlist" style="border: 1px solid;">
				<tr>
					<th>이름</th>
					<th>돌보미id</th>
					<th>성별</th>
					<th>요청보내기</th>
				</tr>
				
				<c:forEach items="${sList}" var="s">
					<tr>
						<td><c:out value = "${s.name}"/></td>
						<td><c:out value = "${sitter.id}"/></td>
						<td>
							<c:out value = "${sitter.gender}"/>
							<c:set value="${list.gender}" var="gender"/>
							<c:if test="${gender == 0}">
								남자
							</c:if>
							<c:if test="${gender == 1}">
								여자
							</c:if>
						</td>
						<td><button>요청하기</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>

</html>