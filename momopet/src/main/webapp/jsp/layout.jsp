<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>레이아웃</title>
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/layout.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<%-- <script src="<c:out value="${contextPath}"/>/js/layoutjq.js"></script> --%>
</head>
<body>
	<jsp:include page="./header.jsp" />
	<br>
	<div class="sitter-picture">
			<!-- <img src="https://i.cbc.ca/1.6654160.1668638085!/fileImage/httpImage/what-to-consider-when-looking-for-a-pet-sitter.jpg"> -->
	</div>
	<div class="content">
	혼자 남겨진 반려동물을 생각하며, 외출을 망설인 적이 있으신가요? <br>
	이제 MOMOPET에서 돌봄님에게 맡기고, <br>
	여러분의 소중한 일상을 마음 편히 보내세요.
	</div>
	
	<div class="container service">
		<h1>모모펫 서비스 소개</h1>
		<div class="center">
			<img src="https://www.wagglespetresort.com/wp-content/uploads/2023/07/dog-boarding-is-best-when-you-are-away-980x653.jpg">
		</div>
		<!-- <div class="dog-picture">
		</div> -->
		<div class="col-1">
			<div class="service-row">
				<h2>우리집에서</h2>
				<div class="content">
				돌봄님이 보호자님 댁에 방문하여 펫과 
				<br>함께 놀아주고, 먹여주고, 산책도 시켜드립니다.
				<br>고양이의 경우 리터박스도 치워드립니다.
				</div>
			</div>
			<div class="service-row">
				<h2>돌봄님 댁에서</h2>
				<div class="content">
				보호자님이 돌봄님 댁에 펫을 데려다주시기만 하면 
				<br>펫은 돌봄님 댁에서 돌봄님의 가족처럼 보살펴드립니다.
				</div>
			</div>
			<div class="service-row">
				<h2>산책</h2>
				<div class="content">
				보호자님이 바쁘신 날에 돌봄님이 보호자님 댁에 가서
				<br>보호자님 펫을 동네 산책을 시켜드립니다. 
				</div>
			</div>
		</div>

	</div>

	<div class="howtouse">
		<h1>모모펫 사용방법</h1>
		<!-- <div class="cat-picture">
		</div> -->
		<div class="center">
			<img src="https://veterinariadavinci.com.br/blog/wp-content/uploads/2017/10/cat-sitter-saiba-mais-sobre-essa-profissao.jpg">
		</div>
		<div class="col-2">
			<div class="service-row">
				<h2>1.돌봄님 찾기</h2>
				<div class="content">
				주위에 계신 돌봄님들을 찾아보고 리뷰도 확인 후,
				<br>나와 내 펫에 제일 잘 맞는 돌봄님을 찾기
				</div>
			</div>
			<div class="service-row">
				<h2>2.돌봄님께 요청하기</h2>
				<div class="content">
				원하시는 돌봄님을 찾은 후,
				<br>해당 돌봄님께 요청 보내기
				</div>
			</div>
			<div class="service-row">
				<h2>3.기다리기</h2>
				<div class="content">
				돌봄님의 회신을 기다리기
				</div>
			</div>
		</div>
	</div>

 	<%@ include file="./footer.jsp"%> 
	
</body>
</html>