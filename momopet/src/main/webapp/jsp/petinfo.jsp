<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script src="<c:out value="${contextPath}"/>/js/petinfojq.js"></script>
	</head>
	<body>
		<h3>내 펫 정보 확인</h3>
		<form>
			<table>
				<tr>
					<td>동물종류</td>
					<td><input type="text" name="pettype" readonly="readonly"
						value="${a}"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" readonly="readonly"
						value="${a}"></td>
				</tr>
				<tr>
					<td>종류</td>
					<td><input type="text" name="breed" readonly="readonly"
						value="${a}"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="date" name="birthdate" readonly="readonly"
						value="${a}"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td><input type="text" name="gender" readonly="readonly"
						value="${a}"></td>
				</tr>
				<tr>
					<td>몸무게(kg)</td>
					<td><input type="text" name="weight" readonly="readonly"
						value="${a}"></td>
				</tr>
				<tr>
					<td>주의사항</td>
					<td><input type="text" name="remarks" readonly="readonly"
						value="${remarks}"></td>
				</tr>
	
			</table>
			<button class="button">펫 정보 수정하기</button>
		</form>
	
	</body>
</html>