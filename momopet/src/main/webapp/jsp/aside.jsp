<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- <section id="mypagenav"> -->
	<aside>
		<nav id="mypage">
			<ul>
				<%-- <li><a href="<c:out value="${contextPath}"/>/jsp/customerinfo.jsp">내 정보 확인</a></li> --%>
				<li><a class="customerInfoChk"
					href="<c:out value="${contextPath}"/>/jsp/customerinfo.jsp">내
						정보 확인</a></li>
				<li><a href="sitterAvailability">내 시터 프로필 확인</a></li>
				<li><a
					href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">내가
						받은 요청 내역</a></li>
				<li><a
					href="<c:out value="${contextPath}"/>/jsp/historylist.jsp">거래
						완료 내역</a></li>
				<%-- <li><a href="<c:out value="${contextPath}"/>/checkReviews">내가 받은 리뷰 보기</a></li> --%>
				<li><a href="<c:out value="${contextPath}"/>/reviewlist"
					id="checkReviewsLink">내가 받은 리뷰 보기</a></li>
				<li><a href="<c:out value="${contextPath}"/>/reviewlist2"
					id="checkReviewsLink2">내가 쓴 리뷰 보기</a></li>
			</ul>
		</nav>
	</aside>
	<!-- <div>정보 불러오기</div> -->
<!-- </section> -->