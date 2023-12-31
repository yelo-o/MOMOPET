<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/searchpwd.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/searchpwdjq.js"></script>
</head>
 <body>
 <jsp:include page="./header.jsp"/>
    <section class="container">
      <header>비밀번호 찾기</header>
      <form class="searchpwd">
        <div class="input-box">
            <label>아이디</label>
            <input type="text" placeholder="아이디를 입력하세요" name="userid" required />
            
          </div>
        <div class="input-box">
          <label>이름</label>
          <input type="text" placeholder="이름을 입력하세요" name="name" required />
        </div>

        <div class="input-box">
          <label>이메일</label>
          <input type="text" placeholder="이메일을 입력하세요" name="email" required />
        </div>

        <button>Submit</button>
      </form>
    </section>
     <%@include file="./footer.jsp" %>
  </body>
</html>