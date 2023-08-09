<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/layout.css">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/mypage.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/mypagejq.js"></script>
    </head>
    <body>
		<jsp:include page="./header.jsp"/>
	    <section id="mypagenav">
	    	<aside>
		    	<nav id="mypage">
			        <ul>
			        	<%-- <li><a href="<c:out value="${contextPath}"/>/jsp/customerinfo.jsp">내 정보 확인</a></li> --%>
			        	<li><a class="customerInfoChk" href="<c:out value="${contextPath}"/>/jsp/customerinfo.jsp">내 정보 확인</a></li>
			        	<li><a href="sitterAvailability">내 시터 프로필 확인</a></li>
			        	<li><a href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">내가 받은 요청 내역</a></li>
			        	<li><a href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">거래 완료 내역</a></li>
			        	<%-- <li><a href="<c:out value="${contextPath}"/>/checkReviews">내가 받은 리뷰 보기</a></li> --%>
			        	<li><a href="<c:out value="${contextPath}"/>/reviewlist" id="checkReviewsLink">내가 받은 리뷰 보기</a></li>
			        	<li><a href="<c:out value="${contextPath}"/>/reviewlist2" id="checkReviewsLink2">내가 쓴 리뷰 보기</a></li>
			        </ul>
		        </nav>
		    </aside>
		    <div>
		    	정보 불러오기
		    </div>
		</section>
		        	
		        	
		 		<%-- <ul>
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
		            <li><a href="<c:out value="${contextPath}"/>/jsp/member_update.jsp">내정보수정</a></li>
		        </ul> --%>


	</body>
</html>