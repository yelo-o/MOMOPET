<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<c:out value="${contextPath}"/>/css/findid.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<c:out value="${contextPath}"/>/js/findjq.js"></script>
</head>
 <body>
    <section class="container">
      <header>아이디 찾기</header>
      <form action="#" class="form">
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

        <div class="question">
            <label>질문지</label><br>
            <select class="select-box">
                <option value="">선택하세요</option>
                <option value="q1">좋아하는 색은?</option>
                <option value="q2">좋아하는 노래는?</option>
                <option value="q3">좋아하는 음식은?</option>
                <option vlaue="q4">좋아하는 도시는?</option>
            </select><br>
        </div>
    
        <div class="input-box">
            <label for="answer">답변</label><br>
            <input type="text"name="answer" id="answer">
        </div>
        <button>Submit</button>
      </form>
    </section>
  </body>
</html>