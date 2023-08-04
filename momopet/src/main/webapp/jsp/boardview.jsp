<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 상세보기</title>
    <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/board.css">
    <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/layout.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <%-- <script src="<c:out value=" ${contextPath}" />/js/boardjq.js"></script> --%>
    <%-- <script src="<c:out value=" ${contextPath}" />/js/toboardupdatejq.js"></script> --%>
    <script src="<c:out value=" ${contextPath}" />/js/boardviewjq.js"></script>
</head>

<body>
  <jsp:include page="./header.jsp" />
  <!-- 개행하기 위한 속성값 추가 -->
  <% pageContext.setAttribute("LF", "\n"); %>
  
  <c:choose>
   <c:when test="${!empty msg}">
     <h3>게시물조회 실패:<c:out value="${msg}" /></h3>
   </c:when>
   <c:otherwise>
    <c:set var="b" value="${requestScope.Board}"/>
    <c:set  var="con" value="${b.boardContent}" />
    <%-- <c:set var="date" value="${b.postingDate}" /> --%>
	<%-- <fmt:formatDate value="${b.postingDate}" pattern="yyyy-MM-dd" var="formattedDate" /> --%>
    
    <%-- <c:out value="${b}"/> --%>
    <div class="board_wrap">
        <div class="board_title">
            <strong>자랑하기</strong>
            <p>귀욤둥이들을 자랑해보세요🥰</p>
        </div>
        
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                    <c:out value="${b.boardTitle}"/>
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd><c:out value="${b.boardNo}" /></dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><c:out value="${b.boardId}" /></dd>
                    </dl>
                    <dl>
                        <dt>작성일</dt>
                        <dd><c:out value="${b.postingDate}" /></dd>
                    </dl>
                    <dl>
                        <dt>조회</dt>
                        <dd>기능 구현 아직 못함</dd>
                    </dl>
                </div>
			    <!-- con으로 선언한 변수를 개행하기 위해 fn 사용  -->
                <div class="cont">${fn:replace(con, LF, '<br>')}</div>
            </div>
        </div>
    </div>
   </c:otherwise>
  </c:choose>
    <div class="bt_wrap">
   		<button class="on" type="button" onclick="location.href='<c:out value="${contextPath}"/>/boardlist'" >목록</button>
        <button class="updatepage">수정</button>
        <button class="delete">삭제</button>
        <%-- <button></button><a href="<c:out value="${contextPath}"/>/boardlist" class="on">목록</a> --%>
        <!-- <a href="#">수정</a>
        <a class="delete" >삭제</a> -->
    </div>
</body>
</html>