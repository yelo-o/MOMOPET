<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 수정</title>
    <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/board.css">
    <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/layout.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<c:out value=" ${contextPath}" />/js/boardeditjq.js"></script>
</head>

<body>
  <%-- <jsp:include page="./header.jsp" /> --%>
  <c:choose>
   <c:when test="${!empty msg}">
     <h3>게시물조회 실패:<c:out value="${msg}" /></h3>
   </c:when>
   <c:otherwise>
    <c:set var="b" value="${requestScope.Board}"/>
    <c:set var="tit" value="${b.boardTitle}" />
    <c:set var="con" value="${b.boardContent}" />
    <c:set var="no" value="${b.boardNo}" />
    <form class="board_wrap" id="f1">
        <div class="board_title">
            <strong>자랑하기</strong>
            <p>귀욤둥이들을 자랑해보세요🥰</p>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input id="boardTitle" name="boardTitle" type="text" placeholder="${tit}"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>번호</dt>
                        <dd><span id="btNo"><c:out value="${b.boardNo}" /></span></dd>
                    </dl>
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><span><c:out value="${b.boardId}" /></span></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea type="text" id="boardContent" name="boardContent" placeholder="${fn:replace(con, LF, '<br>')}"></textarea>
                </div>
            </div>
        </div>
            <div class="bt_wrap">
            	<button type="submit" id="updatebtn">수정</button>
                <!-- <a href="board.jsp">취소</a> -->
                <button class="on" type="button" onclick="location.href='<c:out value="${contextPath}"/>/boardlist'" >취소</button>
            </div>
    </form>
   </c:otherwise>
  </c:choose>
</body>
</html>