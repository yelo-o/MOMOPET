<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/findpwd.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/findpwdjq.js"></script>
</head>
 <body>
    <section class="container">
      <header>비밀번호 찾기</header>
      <form class="findpwd">
        <div class="input-box">
            <label>아이디</label>
            <input type="text" placeholder="아이디를 입력하세요" required />
          </div>
        <div class="input-box">
          <label>이름</label>
          <input type="text" placeholder="이름을 입력하세요" required />
        </div>

        <div class="input-box">
          <label>이메일</label>
          <input type="text" placeholder="이메일을 입력하세요" required />
        </div>

        <div class="column">
          <div class="input-box">
            <label>전화번호</label>
            <input type="text" placeholder="전화번호를 입력하세요" required />
          </div>
          </div>

         <div class="input-box">
            <label for="answercolor">좋아하는 색은?</label><br>
            <input type="text" placeholder="답변을 입력하세요" name="answercolor" id="answercolor">
        </div>
        
        <div class="input-box">
            <label for="answercity">좋아하는 도시는?</label><br>
            <input type="text" placeholder="답변을 입력하세요" name="answercity" id="answercity">
        </div>
        <button><a href="../jsp/afterfindid.jsp">Submit</a></button>
      </form>
    </section>
  </body>
</html>