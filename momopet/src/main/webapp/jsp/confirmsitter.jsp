<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/confirmsitter.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/confirmsitterjq.js"></script>
<title>돌보미신청확인</title>
</head>
 <body>
            <section class="container">
                <header> 아래의 돌보미님께 돌봄 신청을 하시겠습니까?</header>
                <form>
                    <div>
                        돌보미정보
                    </div>
                    <button>예</button>
                    <button>아니오</button>
                </form>

            </section>
        </body>
</html>