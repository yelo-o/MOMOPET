<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/findid.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/findjq.js"></script>
</head>
<body>
	<header>
		<nav>
			<ul>
				<li><a href="#" id="idinquiry" class="blind">아이디찾기</a></li>
				<li><a href="#" id="idinquiry" class="blind">비밀번호찾기</a></li>
			</ul>
		</nav>
		</h1>
	</header>
	<section>
	<div>
		<h3 class="title">비밀번호찾기</h3>
		<div class="info">
			<label for="id">아이디</label><input name="id" id="id"> <br>
			<label for="name">이름</label><input name="name" id="name"> <br>
			<label for="email">이메일</label><input name="email" id="email">
			<p>질문으로 아이디 찾기</p>
			<div class="question">
				<select class="type">
					<option value="">선택하세요</option>
					<option value="q1">좋아하는 색은?</option>
					<option value="q2">좋아하는 노래는?</option>
					<option value="q3">좋아하는 음식은?</option>
					<option value="q4">좋아하는 도시는?</option>
				</select> <br> <label for="answer">답변</label><input name="answer"
					id="answer">
			</div>

		</div>
	</div>
	<button>아이디 찾기</button>
	</section>
</body>
</html>
