<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/addrlinkSample.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/addressjq.js"></script>
		
    </head>
    <body>
    	<jsp:include page="./header.jsp"/>
		<form name="form" id="form" method="post">

  			<input type="hidden" name="currentPage" value="1"/>				<!-- 요청 변수 설정 (현재 페이지. currentPage : n > 0) -->

			  <input type="hidden" name="countPerPage" value="10"/>		<!-- 요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100) -->
			  <input type="hidden" name="resultType" value="json"/> 			<!-- 요청 변수 설정 (검색결과형식 설정, json) --> 
			
			  <input type="hidden" name="confmKey" value="U01TX0FVVEgyMDIzMDczMTA5MTAxODExMzk3NTE="/>		<!-- 요청 변수 설정 (승인키) -->
			
			  <input type="text" name="keyword" value=""/>						<!-- 요청 변수 설정 (키워드) -->
			
			  <input type="button" onClick="getAddr();" value="주소검색하기"/>
			
			  <div id="list"> <!-- 검색 결과 리스트 출력 영역 --> </div>
			
			  <div class="paginate" id="pageApi"></div>
			
		</form>
	</body>
</html>