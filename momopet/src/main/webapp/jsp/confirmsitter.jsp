<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
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
                    <div>
                    돌봄 시작날짜 : <input type = "date" name = "startDate" placeholder="시작일자를 클릭하세요">
                    돌봄 종료날짜 : <input type = "date" name = "finishDate" placeholder="종료일자를 클릭하세요"> 
                    </div>
                    <button class="yes">예</button>
                    <button class="no">아니오</button>
                </form>

            </section>
        </body>
</html>