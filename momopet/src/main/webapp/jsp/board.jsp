<%-- <%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%> --%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>전체 조회</title>
  <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/board.css">
  <link rel="stylesheet" href="<c:out value=" ${contextPath}" />/css/layout.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="<c:out value=" ${contextPath}" />/js/boardjq.js"></script>
</head>

<body>
  <jsp:include page="./header.jsp" />

  <div class="board_wrap">
    <div class="board_title">
      <strong>자랑하기</strong>
      <p>귀욤둥이들을 자랑해보세요🥰</p>
    </div>
  
    <c:set var="msg" value="${requestScope.msg}" />
    <c:set var="pb" value="${requestScope.pagebean}" />
    <c:set var="list" value="${pb.list}" />
    
    <%-- <c:out value="${fn:length(list)}"/>
    <c:out value="${pb.totalCnt}"/> --%>
    <c:choose>
      <c:when test="${!empty msg}">
        <h3>게시판 목록 검색 실패:<c:out value="${msg}" /></h3>
      </c:when>
    <c:otherwise>
      <div class="board_list_wrap">
        <div class="board_list">
          <div class="top">
            <div class="num">번호</div>
            <div class="title">제목</div>
            <div class="writer">글쓴이</div>
            <div class="date">작성일</div>
            <div class="count">조회</div>
          </div>
          
            
          <c:forEach items="${list}" var="b" varStatus="status">
	        <div class="board <c:out value="${b.boardNo}"/>">
	          <div class="num"><c:out value="${pb.totalCnt - b.rn + 1}"/></div>
	          <%-- <div class="num"><c:out value="${b.rn}"/></div> --%>
	          <div class="title"><c:out value="${b.boardTitle}"/></div>
	          <div class="writer"><c:out value="${b.boardId}"/></div>
              <fmt:formatDate var="formattedDate" value="${b.postingDate}" pattern="yyyy-MM-dd" />
	          <div class="date"><c:out value="${formattedDate}" /></div>
	          <!-- <div class="count">조회수</div> -->
	          <div class="count"><c:out value="${b.views}"/></div>
	        </div>
          </c:forEach>
        </div> 
      </div>
  

    <div class="pagegroup">
	    <c:set var="currentPage" value="${pb.currentPage}" />
	    <c:set var="totalPage" value="${pb.totalPage}" />
	    <c:set var="startPage" value="${pb.startPage}" />
	    <c:set var="endPage" value="${pb.endPage}" />
	    <c:if test="${startPage > 1 }">
	      <span class="page<c:out value=" ${startPage-1}" />"><</span>
	    </c:if>
	      <c:forEach begin="${startPage}" end="${endPage}" var="i">
	        <span class="page<c:out value=" ${i}" />"><c:out value="${i}" /></span>
	      </c:forEach>
	    <c:if test="${totalPage > endPage}">
	      <span class="page<c:out value=" ${endPage+1}" />">></span>
	    </c:if>
    </div>
    
      <div class="bt_wrap">
        <a href="<c:out value="${contextPath}"/>/jsp/boardwrite.jsp" class="on">등록</a>
      </div>
    </c:otherwise>
    </c:choose>
    </div>
      </div>
</body>

</html>