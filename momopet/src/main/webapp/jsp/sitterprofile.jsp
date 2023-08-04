<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Sitter Profile</title>
<link rel="stylesheet" href="/momopet/css/profile.css">
</head>
<body>
	<!-- 시터 프로필 영역 시작 -->
	<div class="profile_wrap">
		<div class="profile_photo">
			<img alt="" src="/momopet/images/profile.png">
		</div>
		<!-- 시터 프로필 요약 영역 -->
		<div class="profile_summary_wrap">
			<!-- 시터 이름 및 헤더 영역 -->
			<h1>시터 이름</h1>
			<!-- 시터 동네 정보 영역 -->
			<div>활동 지역</div>
			<!-- 시터 평점 및 리뷰수 영역 -->
			<span> </span> <a href="#reviews">리뷰수()</a><br>
			<!-- 시터에게 메시지 보내기 및 즐겨찾기 버튼 영역 -->
			<a href="#contact">에게 연락하기</a>
		</div>
	</div>


	<!-- 서비스 가격 정보 영역 -->
	<div class="table_wrap">
		<div>
			<h2>서비스 가격</h2>
			<table>
				<tbody>
					<tr>
						<td>시터의 집에서 돌봄</td>
						<td>DB에서 넘겨받은 가격</td>
					</tr>
					<tr>
						<td>보호자의 집에서 돌봄</td>
						<td>DB에서 넘겨받은 가격</td>
					</tr>
					<tr>
						<td>방문</td>
						<td>DB에서 넘겨받은 가격</td>
					</tr>
					<tr>
						<td>산책</td>
						<td>DB에서 넘겨받은 가격</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- 시터가 받은 리뷰들 영역 -->
	<div class="review_wrap">
		<div>
			<h2>시터 리뷰</h2>
			<div>
				<div>친절해요</div>
				<div>리뷰 2</div>
				<div>리뷰 3</div>
			</div>
			<button>더 보기</button>
		</div>
	</div>

	<!-- 시터 소개 영역 -->
	<div class="intro_wrap">
		<div>
			<h2>시터 소개</h2>
			<p></p>
		</div>
	</div>
	<!-- 시터 프로필 영역 끝 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="/momopet/js/profilejq.js"></script>
</body>
</html>