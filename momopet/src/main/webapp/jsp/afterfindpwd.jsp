<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/afterfindpwd.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/findjq.js"></script>
<title>비밀번호 변경</title>
</head>
<body>
            <section class="container">
                <header> 새로운 비밀번호를 설정해주세요</header>
                <form>
                    <div class="txt_field">
                        <label>비밀번호 : </label>
                        <input type="password" required>
                        <span></span>
                    </div>
                    <div class="txt_field">
                        <label>비밀번호 확인 : </label>
                        <input type="password" required>
                        <span></span>
                    </div>
                    <button><a href="${contextPath}/jsp/login.jsp">로그인하기</a></button>
                    <button><a href="${contextPath}/jsp/layout.jsp">메인페이지로 돌아가기</a></button>
                </form>

            </section>
        </body>
</html>