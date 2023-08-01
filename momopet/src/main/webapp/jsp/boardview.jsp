<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="<c:out value=" ${contextPath}" />/js/boardjq.js"></script>
</head>

<body>
  <c:choose>
   <c:when test="${!empty msg}">
     <h3>상품조회 실패:<c:out value="${msg}" /></h3>
   </c:when>
   <c:otherwise>
    <c:set var="b" value="${requestScope.Board}"/>
    <%-- <c:out value="${b}"/> --%>
    <div class="board_wrap">
        <div class="board_title">
            <strong>자랑하기</strong>
            <p>귀욤둥이들을 자랑해보세요🥰</p>
        </div>
        
        <div class="board_view_wrap">
            <div class="board_view">
                <div class="title">
                    글 제목이 들어갑니다.
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
                <div class="cont">
                  <c:out value="${b.boardContent}" />
                </div>
                </c:otherwise>
    </c:choose>
            </div>
            
            <div class="bt_wrap">
                <a href="<c:out value="${contextPath}"/>/boardlist" class="on">목록</a>
                <a href="boardedit.jsp">수정</a>
                <a href="#">삭제</a>
            </div>
        </div>
    </div>
</body>
</html>