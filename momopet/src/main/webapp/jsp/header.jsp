<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/header.css">
    </head>
    
<body>
  <nav>
	<h3 >	
        <a class="logo" href="<c:out value="${contextPath}"/>/jsp/layout.jsp">모모펫</a>
    </h3>
	
        <ul class="firstlink">
        <c:set var="loginedId" value="${sessionScope.loginedId}"/>

          <li><a href="<c:out value="${contextPath}"/>/jsp/searchsitter.jsp">돌보미찾기</a></li>

          <li><a href="<c:out value="${contextPath}"/>/jsp/searchsitter.jsp">돌봄님찾기</a></li>

          <li><a href="<c:out value="${contextPath}"/>/boardlist">자랑하기</a></li>
        </ul>
        
        <ul class="secondlink">
         <c:choose>
        	<c:when test="${empty loginedId}">
         	 <li><a href="<c:out value="${contextPath}"/>/jsp/signup.jsp">회원가입</a></li>
          	 <li><a href="<c:out value="${contextPath}"/>/jsp/login.jsp">로그인</a></li>
            </c:when>
            <c:otherwise>
            <ul class ="submain">
        		<li><a href="<c:out value="${contextPath}"/>/jsp/mypage.jsp">마이페이지</a>
		            <%-- <ul class="dropdown">
		              <li><a href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">히스토리</a></li>
		              <li><a href="<c:out value="${contextPath}"/>/jsp/review.jsp">리뷰</a></li>
		              <li><a href="<c:out value="${contextPath}"/>/customerinfocheck">내정보확인</a></li>
		              <li><a href="<c:out value="${contextPath}"/>/jsp/member_update.jsp">내정보수정</a></li>
		            </ul> --%>
		            </li>
	          	<li><a href="<c:out value="${contextPath}"/>/logout">로그아웃</a></li>
	          	</ul>
        	</c:otherwise>
        </c:choose>
        </ul>
  </nav>
</body>
</html>