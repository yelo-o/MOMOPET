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
  <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/layout.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>

<body>
<%--     <jsp:include page="./header.jsp" /> --%>
    
    <div class = "sitter_wrap">
    	<div class ="sitter_title">
    		<strong>시터 조회 목록</strong>
    	</div>
		
		<c:set var="msg" value="${requestScope.msg}" />
    	<c:set var="list" value="${requestScope.list}" />
	
		<c:choose>
			<c:when test="${!empty msg}">
				<h3>시터 목록 검색 실패:<c:out value="${msg}" /></h3>
			</c:when>
	
			<c:otherwise>
				<div class="sitter_list_wrap">
					<div class="sitter_list">
						<div class="top">
							<div class="id">id</div>
							<div class="name">이름</div>
							<div class="gender">성별</div>
							<div class="request">요청</div>
						</div>
					
						<c:forEach items="${list}" var="s">
							<div class="id"><c:out value="${s.userId}"/></div>
							<div class="name"><c:out value="${s.name}"/></div>
							<div class="gender"><c:out value="${s.userSex}"/></div>
							<div class="request"><button>요청하기</button></div>
						</c:forEach>
					</div>
				</div>
				
			</c:otherwise>
		</c:choose>
	</div>
</body>

</html>