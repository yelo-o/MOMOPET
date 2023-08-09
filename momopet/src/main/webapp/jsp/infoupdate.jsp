<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/infoupdate.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<c:out value=" ${contextPath}" />/js/infoupdatejq.js"></script>
</head>

<body>
    <c:set var="c" value="${requestScope.customer}" />
    <c:set var="phone" value="${c.phoneNumber}" />
    <c:set var="em" value="${c.email}" />
    <c:set var="add" value="${c.address}" />
    
    <fmt:formatDate var="formattedDate" value="${c.birthDate}" pattern="yyyy-MM-dd" />
    
    <h1>내 정보 확인</h1>
    <form class="infoupdate">
        <table>
            <tr>
                <td>이름 : </td>
                <td><c:out value="${c.name}"/></td>
            </tr>
            <tr>
                <td>아이디 : </td>
                <td><c:out value="${c.userId}"/></td>
            </tr>
<%--        <tr>
                <td>비밀번호 : </td>
                <td><c:out value="${c.pwd}"/></td>
            </tr> --%>
            <tr>
				<td>휴대폰번호 : </td>
				<td><input type="text" name="phoneNumber" value="${phone}"></td>
			</tr>
            <tr>
                <td>이메일 : </td>
                <td><input type="text" name="email" value="${em}"></td>
            </tr>
            <tr>
                <td>주소 : </td>
                <td><input type="text" name="address" value="${add}"></td>
            </tr>
            <tr>
                <td>생년월일 : </td>
                <td><c:out value="${formattedDate}" /></td>
                <%-- <td><c:out value="${c.userId}"/></td> --%>
            </tr>
		<%--<tr>
                <td>시급 : </td>
                <td><c:out value="${c.pay}"/></td>
            </tr>
            <tr>
                <td>자기소개 : </td>
                <td><c:out value="${c.introduce}"/></td>
            </tr> --%>

            <tr>
                <td><input class="buttonupdate" type="submit" value="수정하기" ></td>
                <td><input class="buttonback" type="button" value="뒤로가기" ></td>
            </tr>

        </table>
    </form>
</body>

</html>