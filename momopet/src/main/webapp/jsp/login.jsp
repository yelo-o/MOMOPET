<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/login.css">
<link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/layout.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/loginjq.js"></script>
</head>
<body>
<jsp:include page="./header.jsp"/>
    <section class="center">
        <h1>로그인</h1>
        <form class="login">
            <div class="txt_field">
                <input type="text" name="id" required>
                <span></span>
                <label>아이디</label>
            </div>
            <div class="txt_field">
                <input type="password" name="pwd" required>
                <span></span>
                <label>비밀번호</label>
            </div>
            <div class="checkbox">
            <input type="checkbox" checked>아이디저장
            </div>
            <button>Login</button> 
            <div class="find">
                <span class="pass"><a href="../jsp/searchid.jsp">아이디찾기</a></span>
                <span class="findpwd"><a href="../jsp/searchpwd.jsp">비밀번호찾기</a></span>
            </div>
            <div class="signup_link">
            아직 회원이 아니신가요? <a href="${contextPath}/jsp/signup.jsp">signup</a>
            </div>
        </form>
    </section>
 <%@include file="./footer.jsp" %>
</body>
</html>