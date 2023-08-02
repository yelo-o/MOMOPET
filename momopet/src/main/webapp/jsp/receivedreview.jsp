<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>리뷰 조회</title>
</head>
<body>
	<h1>내가 받은 리뷰</h1>
		<div class="container">
			<span>${requestScope.writingDate}</span>
			<span>${requestScope.reviewRating}</span>
			<div>${requestScope.reviewContent}</div>
		</div>
</body>
</html>