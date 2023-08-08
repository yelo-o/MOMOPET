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
			        	<li><a href="<c:out value="${contextPath}"/>/jsp/informationcheck.jsp">내 정보 확인</a></li>
			        	<li><a href="<c:out value="${contextPath}"/>/jsp/petinfo.jsp">내 펫 정보 확인</a></li>
			        	<li><a href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">내가 보낸 요청 내역</a></li>
			        	<li><a href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">거래 완료 내역</a></li>
			        	<%-- <li><a href="<c:out value="${contextPath}"/>/jsp/review.jsp">내가 쓴 리뷰 보기</a></li> --%>
			        </ul>
			    </nav>
		    </aside>
		    <div>
		    	정보 불러오기
		    </div>
	    </section>
	</body>
</html>