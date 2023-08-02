<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="loginedId" value="${sessionScope.loginedId}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성</title>
    <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/board.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<c:out value=" ${contextPath}" />/js/boardwritejq.js"></script>
    
</head>
<body>
    <form class="board_wrap">
        <div class="board_title">
            <strong>자랑하기</strong>
            <p>귀욤둥이들을 자랑해보세요🥰</p>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" name="title" placeholder="제목 입력"></dd>
                    </dl>
                </div>
                <!-- <div class="info">
                    <dl>
                        <dt>글쓴이</dt>
                        <dd><input type="text" placeholder="글쓴이 입력"></dd>
                    </dl>
                    <dl>
                        <dt>작성일자</dt>
                        <dd>2023.07.29 16:00</dd>
                        <dd><input type="text" placeholder="작성일자 입력"  value="2023.07.29"></dd>
                    </dl>
                </div> -->
                <div class="cont">
                    <textarea name="content" placeholder="내용 입력"></textarea>
                </div>
            </div>
            <div class="bt_wrap">
                <button class="on">등록</button>
                <button type="button" onclick="location.href='<c:out value="${contextPath}"/>/boardlist'" >취소</button>
            </div>
        </div>
    </form>
</body>
</html>