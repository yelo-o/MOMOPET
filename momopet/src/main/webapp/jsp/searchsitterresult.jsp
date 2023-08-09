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
  <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/searchsitter.css">
  <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/layout.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="<c:out value="${contextPath}"/>/js/sitterresultlistjq.js"></script>

<body>
 <jsp:include page="./header.jsp" /> 
    
    <div class="center">
    	<h1>돌보미 조회 목록</h1>
    		
		<c:set var="msg" value="${requestScope.msg}" />
    	<c:set var="list" value="${requestScope.list}" />
	
		<c:choose>
			<c:when test="${!empty msg}">
				<h3>시터 목록 검색 실패:<c:out value="${msg}" /></h3>
			</c:when>
	
			<c:otherwise>
				<c:forEach items="${list}" var="s">
				<form class="<c:out value="${s.userId}" />">
					<div class="txt_field">
					      <input type="hidden" name="testId" value="${s.userId}">
					아이디 :<span class="sitterId"><c:out value="${s.userId}"/></span><br>
					이름 : <span class="name"><c:out value="${s.name}"/></span><br>
					      <span hidden="hidden" class="gender"> <c:out value="${s.userSex}"/> </span> <!-- data 0또는 1로 남김 --> 
					성별 : <span>
							  <c:choose>
							       <c:when test="${s.userSex==0}">남자<br>
							       </c:when>    
							       <c:otherwise>여자<br>
							       </c:otherwise>
							  </c:choose>		
					      </span>
					자기소개 : <span class="introduce"><c:out value="${s.introduce}"/></span><br>
					<%-- <div class="request"><input type="submit" value="${s.userId}님에게 돌봄요청"></div> --%>
					<div class="request"><button class="<c:out value="${s.userId}" />" type="submit">${s.userId}님에게 돌봄요청</button></div>
					</div>
				</form>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
	
</body>

</html>