<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/signup.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/signupjq.js"></script>

    </head>
    <body>
        <form class="signup">
        	<button type="button" class="testClick" >testClick</button>
        	<button type="button" class="testShow" >testShow</button>
        	<table class="singupInfo">
        		<tr class="signupId">
        			<td>아이디</td>
        			<td><input name="id" 
	                   		   id="id"
	                   		   placeholder="아이디를 입력하세요"></td>
	                <td class="signUpDupchk"><button id="btIdDupchk" type="button" class="btIdDupchk" >아이디중복확인</button></td>
        		</tr>
        		<tr>
        			<td>비밀번호</td>
        			<td><input name="pwd" 
	                   		   id="pwd"
	                  		   type="password"></td>
        		</tr>
        		<tr>
        			<td>비밀번호재확인</td>
        			<td><input name="pwd1" 
	                   		   id="pwd1"
	                   		   type="password"></td>
        		</tr>
        		<tr>
        			<td>이름</td>
        			<td><input name="name" 
	                  		   id="name"
	              		       type="text"></td>
        		</tr>
        		<tr>
        			<td>생년월일</td>
        			<td><input name="birthdate" 
	                  		   id="birthdate"
	              		       type="date"></td>
        		</tr>
        		<tr>
        			<td>성별</td>
        			<td><select>
        					<option value="male">남</option>
        					<option value="female">여</option>
    					</select></td>
        		</tr>
        		<tr>
        			<td>이메일</td>
        			<td><input name="email" 
	               		       id="email"
	                  		   type="text"></td>
	            </tr>
	            <tr>
	            	<td>전화번호</td>
	            	<td><input name="phoneNumber" 
	                		   id="phoneNumber"
	                 		   type="text"></td>
	            </tr>
	            <tr>
	            	<td>주소</td>
	            	<td><input name="address" 
	                 		   id="address"
	                  		   type="text"></td>
	            </tr>
	            <tr>
        			<td>역할 선택</td>
        			<td><select>
        					<option value="sitter">돌보미</option>
        					<option value="petOwner">보호자</option>
    					</select></td>
        		</tr>
        	</table>
        <button type="submit" class="signup">회원가입</button>
        </form>
    </body>
</html>