<%@page import="com.momo.customer.dto.Customer"%>
<%@page import="com.momo.customer.dto.PetOwner"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/profilesend.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<c:out value="${contextPath}"/>/js/profilesendjq.js"></script>
</head>

<body>
    <header>
        <tr>
            <div><input name="name" readonly="readonly" value="${name}">에게 연락하기</div>
        </tr>
        <br>
        <div>
            <div>날짜 정하기</div>
        </div>
        <div>
            <form>
                <p><input type="date"></p>
            </form>
        </div>
        <br>
        <div class="time">
            <div>
                <div>시작 시간</div>
                <p><input type="time"></p>
            </div>
            <div>
                <div>종료 시간</div>
                <p><input type="time"></p>
            </div>
        </div>
        <br>
        <div>내 반려견 사진 추가하기</div>
        <!-- <div class="mypetphoto">frontback com.my.test.control >> UploadServlet.java 파일 참고하면서 파일 업로드
            하는것 넣기</div> -->
        <br>
        <br>
        <div>
            <p>반려동물 정보</p>
            <div class="petid">
                <div>이름 : <input value="${pet_name}"></div><br>
                <div>성별 : <input value="${pet_sex}"></div><br>
                <div>품종 : <input value="${pet_breed}"></div><br>
                <div>주의사항 : <input value="${pet_remarks}"></div>
            </div>
        </div>
        <br>
        <br>
        <div class="myphonenumber">
            <span>내 전화번호 :</span>
            <span><input phonenumber="phonenumber" value="${phone_number}"></span>
        </div>
        <div>
            <br>
            <br>
        </div>
        <div class="container">
            <h1>메세지</h1>
            <form id="dataForm">
                <label for="recipientEmail">
                    <input name="senduser" value="${id}">
                </label>
                <label for="message">Message:</label>
                <textarea id="message" rows="9"></textarea>
                <button type="submit">보내기</button>
            </form>
        </div>
    </header>
</body>

</html>
