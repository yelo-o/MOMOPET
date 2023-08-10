<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/review.css">
<title>리뷰조회</title>
<style></style>
</head>
<body>
<%-- <div class="center-container">
	<div class="form-container">
		<h2 align="center">리뷰 쓰기</h2>
		<form id="writeForm" method="get" action="review" encType="UTF-8"> <!-- ★ form 형식 지켜주기 -->
			<div>
				<input name="userId" placeholder="리뷰를 받을 시터 아이디를 입력해주세요." required style="width: 270px;"">
			</div><br>
			<!--<input type="hidden" name="reviewNo" value="시퀀스">
	    	<input type="hidden" name="loginedId" value="세션 아이디"> -->
			<textarea name="reviewContent" placeholder="등록할 리뷰를 입력해주세요." required style="width: 300px; height: 100px;"></textarea>
			<div class="star-rating">
				<img src="<c:out value="${contextPath}/images/star.png" />"
					data-rating="1" alt="1점"> <img
					src="<c:out value="${contextPath}/images/star.png" />"
					data-rating="2" alt="2점"> <img
					src="<c:out value="${contextPath}/images/star.png" />"
					data-rating="3" alt="3점"> <img
					src="<c:out value="${contextPath}/images/star.png" />"
					data-rating="4" alt="4점"> <img
					src="<c:out value="${contextPath}/images/star.png" />"
					data-rating="5" alt="5점">
			</div>
	
			<input type="hidden" name="reviewRating" value="0" required>
	
			<button class="submit-bt" type="submit">리뷰 등록</button>
		</form>
	</div>
	</div> --%>
	<div style="text-align: center;">
       <h1>리뷰 쓰기</h1><br>
        <form id="writeForm" method="get" action="review" encType="UTF-8" style="text-align: center;">
            <div style="width: 270px; margin: 0 auto;">
                <input name="userId" placeholder="리뷰를 받을 시터 아이디를 입력해주세요." required style="width: 250px; height: 20px;">
            </div><br>
            <textarea name="reviewContent" placeholder="등록할 리뷰를 입력해주세요." required style="width: 1000px; height: 100px; margin: 0 auto;"></textarea>
            <div class="star-rating" style="margin: 0 auto;">
                <img src="<c:out value="${contextPath}/images/star.png" />" data-rating="1" alt="1점">
                <img src="<c:out value="${contextPath}/images/star.png" />" data-rating="2" alt="2점">
                <img src="<c:out value="${contextPath}/images/star.png" />" data-rating="3" alt="3점">
                <img src="<c:out value="${contextPath}/images/star.png" />" data-rating="4" alt="4점">
                <img src="<c:out value="${contextPath}/images/star.png" />" data-rating="5" alt="5점">
            </div>
            <input type="hidden" name="reviewRating" value="0" required>
            <button class="submit-bt" type="submit">리뷰 등록</button>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="<c:out value="${contextPath}/js/reviewjq.js" />"></script>
</body>
</html>
