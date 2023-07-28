<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<header>
    <h1>	
        <a class="logo" href="<c:out value="${contextPath}"/>/jsp/layout.jsp">모모펫</a>
    </h1>
    <nav>
        <ul>
 
        <c:set var="loginedId" value="${sessionScope.loginedId}"/>
        <c:choose>
        	<c:when test="${empty loginedId}">
        		<li><a href="<c:out value="${contextPath}"/>/jsp/login.jsp">로그인</a></li>
            	<li><a href="<c:out value="${contextPath}"/>/jsp/signup.jsp">회원가입</a></li>
        	</c:when>
        	<c:otherwise>
        		<li><a href="logout">로그아웃</a></li>
        	</c:otherwise>
        </c:choose>
            <li><a href="searchSitters">시터찾기</a></li>
            <li><a href="board">자랑하기</a></li>
            <li><a href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">히스토리</a></li>
            <li><a href="<c:out value="${contextPath}"/>/jsp/review.jsp">리뷰</a></li>
            <li><a href="<c:out value="${contextPath}"/>/jsp/informationcheck.jsp">내정보확인</a></li>
        </ul>
    </nav>
</header>