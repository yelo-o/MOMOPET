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
                    <c:set var="sitterId" value="${requestScope.sitterId}" />
    				<c:set var="name" value="${requestScope.name}" />
    				<c:set var="gender" value="${requestScope.gender}" />
                        <h1>돌보미정보</h1>
                        이름 : <span class="sitterName"><c:out value="${name}"/></span>
                        <br>
                        아이디 : <span class="sitterId"><c:out value="${sitterId}"/></span>
                        <br>
                        <span hidden="hidden" class="sitterGender"><c:out value ="${gender}"/></span> <!-- 진짜 gender(숫자)는 숨기고, 아래에서 출력  -->
                        성별 : <span>
                        		<c:choose>
							       <c:when test="${gender==0}">남자<br>
							       </c:when>    
							       <c:otherwise>여자<br>
							       </c:otherwise>
							    </c:choose>		
                              </span>
                        <br>
                        자기소개 : <br>
                    </div>
                   <div class="datepicker-to-from">
                    돌봄 시작날짜 : <input type = "date" name ="startDate" id = "startDate" placeholder="시작일자를 클릭하세요">
                    
                    돌봄 종료날짜 : <input type = "date" name ="endDate" id = "endDate" placeholder="종료일자를 클릭하세요"> 
                    </div>

                    <button class="yes">예</button>
                    <button type="button" onclick="location.href='<c:out value="${contextPath}"/>/jsp/searchsitter.jsp'">아니오</button>
                </form>

            </section>
        </body>
</html>