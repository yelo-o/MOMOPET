<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/layout.css">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/mypage.css">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/historylist.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/mypagejq.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/historylistjq.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/checkreviewjq.js"></script>

    </head>
    <body>
		<jsp:include page="./header.jsp"/>
	    <section id="mypagenav">
	    	<aside>
		    	<nav id="mypage">
			        <ul>
			        <c:set var="loginedId" value="${sessionScope.loginedId}"/>
			        <c:set var="userType" value="${sessionScope.userType}"/>
			        	<li><a class="customerInfoChk" href="<c:out value="${contextPath}"/>/jsp/customerinfo.jsp">내 정보 확인</a></li>
			        	
			        	<c:choose>
			        	<c:when test="${userType eq 0}">
			        		<li><a class="historylistChk" href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">받은 요청 목록</a></li>
			        		<li><a href="#" id="sitterReviewList">내가 받은 리뷰 보기</a></li> <!-- URL 변경하지 않고 페이지빈 사용 -->
			        	</c:when>
			        	<c:otherwise>
			        		<li><a href="#" id="customerReviewList">내가 작성한 리뷰 보기</a></li>
			        		<li><a href="#" id="customerReview">리뷰 등록</a></li>
			        	</c:otherwise>
			        	</c:choose>
			        	
			        </ul>
		        </nav>
		    </aside>
		    <div class="aside-next">
		    	<img src="<c:out value="${contextPath}/images/puppy.jpg" />">
		    </div>
		</section>

 	<%@include file="./footer.jsp" %>
	</body>
</html>