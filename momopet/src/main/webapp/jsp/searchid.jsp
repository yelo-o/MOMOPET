<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/searchid.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/findidjq.js"></script>
</head>
 <body>
    <section class="container">
      <header>아이디 찾기</header>
      <form class="findid">
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
  </body>
</html>