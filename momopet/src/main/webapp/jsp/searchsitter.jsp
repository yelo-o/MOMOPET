<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/searchsitter.css">
<link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/layout.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/searchsitterjq.js"></script>
<title>돌보미찾기</title>
</head>
 <body>
 <jsp:include page="./header.jsp"/>
    <section class="container">
      <header>돌보미 찾기</header>
      <form action="#" class="searchsitter">
        <div class="pet-box">
            <h3>돌봄이 필요한 친구는?</h3>
            <div class="pet-option">
              <div class="pet">
                <input type="radio" id="check-dog" name="gender" checked />
                <label for="check-dog">개</label>
              </div>
              <div class="pet">
                <input type="radio" id="check-cat" name="gender" />
                <label for="check-cat">고양이</label>
              </div>
            </div>
          </div>
          <div class="pet-box">
            <h3>어디서 돌봄이 필요하시나요?</h3>
            <div class="place-option">
              <div class="place">
                <input type="radio" id="check-dropinvisit" name="place" checked />
                <label for="check-dropinvisit">우리집에서</label>
              </div>
              <div class="place">
                <input type="radio" id="check-boarding" name="place" checked />
                <label for="check-boarding">돌봄님 댁에서</label>
              </div>
              <div class="place">
                <input type="radio" id="check-walking" name="place" checked />
                <label for="check-walking">산책</label>
              </div>
            </div>
          </div>

          <div class="input-box">
            <label>돌봄이 필요한 날짜</label>
            <input type="date" placeholder="시작날짜" />
            <input type="date" placeholder="종료날짜" />
          </div>
        <div class="input-address">
          <label>장소</label>
          <input type="text" placeholder="주소를 입력하세요" id="address" name="address"/>
        </div>
        <div class="pet-qty">
            <label>몇 마리 인가요?</label><br>
            <input type="number">
        </div>
        <button type="submit">Submit</button>
      </form>
    </section>
     <%@include file="./footer.jsp" %>
  </body>
</html>