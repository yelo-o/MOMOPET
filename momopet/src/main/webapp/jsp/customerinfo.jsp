<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ include file="zyhchoz.jsp" %> --%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/customerinfo.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<c:out value=" ${contextPath}" />/js/customerinfojq.js"></script>
</head>

<body>
    <c:set var="c" value="${requestScope.customer}" />
    <%-- <c:set var="bir" value="${c.customer}" /> --%>
    <fmt:formatDate var="formattedDate" value="${c.birthDate}" pattern="yyyy-MM-dd" />
   	<div class="customerinfo">
    <h1>내 정보 확인</h1>
    <br>
    <form>
        <table>
            <tr>
                <td>이름 : </td>
                <td><c:out value="${customer.name}"/></td>
            </tr>
            <tr>
                <td>아이디 : </td>
                <td><c:out value="${customer.userId}"/></td>
            </tr>
<%--             <tr>
                <td>비밀번호 : </td>
                <td><c:out value="${c.pwd}"/></td>
            </tr> --%>
            <tr>
				<td>휴대폰번호 : </td>
				<td><c:out value="${c.phoneNumber}"/></td>
			</tr>
            <tr>
                <td>이메일 : </td>
                <td><c:out value="${c.email}"/></td>
            </tr>
            <tr>
                <td>주소 : </td>
                <td><c:out value="${c.address}"/></td>
            </tr>
            <tr>
                <td>생년월일 : </td>
                <%-- <td><c:out value="${c.birthDate}"/></td> --%>
                <td><c:out value="${formattedDate}" /></td>
            </tr>
<%--             <tr>
                <td>시급 : </td>
                <td><c:out value="${c.pay}"/></td>
            </tr>
            <tr>
                <td>자기소개 : </td>
                <td><c:out value="${c.introduce}"/></td>
            </tr> --%>

            <tr>
                <td><input class="button" type="submit" value="회원수정하기" onclick="return joinCheck()"></td>
            </tr>

        </table>
    </form>
    </div>
</body>

</html>