<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/signup.css">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/layout.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/signupjq.js"></script>

    </head>
    <body>
    	<jsp:include page="./header.jsp"/>
        <form class="signup">
        	<table>
        		<tr>
        			<td>아이디</td>
        			<td><input name="id" 
	                   		   id="id"
	                   		   placeholder="아이디를 입력하세요"></td>
	                <td><button id="btIdDupchk" type="button" class="btIdDupchk" >아이디중복확인</button></td>
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
        			<td><select id="gender" name="gender">
        					<option value="none">선택하세요</option>
        					<option value="0">남</option>
        					<option value="1">여</option>
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
	            	<td>상세 주소</td>
	            	<td><input name="addressDetails" 
	                 		   id="addressDetails"
	                  		   type="text"></td>
	            </tr>
	            <tr>
        			<td>역할 선택</td>
        			<td><select id="role" name="role">
        					<option value="none">선택하세요</option>
        					<option value="0">돌보미</option>
        					<option value="1">보호자</option>
    					</select></td>
        		</tr>
        	</table>
        	<div class="petInfo" id="petInfo">
        		<table>
        			<th>펫1</th>
        			<tr>
        				<td>동물종류</td>
        				<td><select>
        						<option value="none">선택하세요</option>
        						<option value="dog">개</option>
        						<option value="cat">고양이</option>
    						</select></td>
        			</tr>
	        		<tr>
	        			<td>이름</td>
	        			<td><input name="name" 
		                  		   id="name"
		              		       type="text"></td>
	        		</tr>
	        		<tr>
	        			<td>종류</td>
	        			<td><input name="breed" 
		                  		   id="breed"
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
	        					<option value="none">선택하세요</option>
	        					<option value="male">남</option>
	        					<option value="female">여</option>
	    					</select></td>
	        		</tr>
	        		<tr>
	        			<td>몸무게(kg)</td>
	        			<td><input name="weight" 
		                  		   id="weight"
		              		       type="text"></td>
	        		</tr>
	        		<tr>
        				<td>주의사항</td>
        				<td><input name="petRemarks" 
	                   		   	   id="petRemakrs"
	                  		   	   type="text"></td>
        			</tr>
        			<tr>
        				<td><button id="addPet" type="button">펫추가</button></td>
        			</tr>
        		</table>
        	</div>
        	<div class="terms" id="terms">
        		<h1>필수약관</h1>
		        <p>
		            이 웹사이트의 서비스를 이용하시려면 아래의 약관에 동의해야 합니다.
		            <br>
		            약관 내용 확인 후 동의해주세요.
		        </p>
		        <div class="terms-content">
		            <!-- 약관 내용 -->
		            <h2>시터로써 지켜야할 약속</h2>
		            <p>1. 목줄 사용: 반드시 견종과 크기에 맞는 목줄을 사용해야 합니다. 목줄은 강아지를 통제하고 안전하게 산책하는 데 도움을 줍니다.</p>
		            <p>2. 소통과 인사: 다른 강아지와 사람들을 만날 때, 안녕하는 것은 예의입니다. 
		                강아지가 사람이나 다른 동물과 친근하게 만날 수 있도록 훈련하는 것이 좋습니다.</p>
		            <p>3. 공공 장소 규칙: 공공 장소에서는 강아지가 다른 사람이나 동물에게 위협을 주지 않도록 주의해야 합니다. 
		                또한, 강아지가 다른 사람의 재산에 손상을 입히지 않도록 조심해야 합니다.</p>
		            <p>4. 쓰레기 처리: 강아지가 배설물을 하게 되면 반드시 깨끗하게 치워야 합니다. 
		                공공 장소에서는 쓰레기를 버리는 지역을 따르는 것이 중요합니다.</p>
		            <p>5. 더운 날씨와 추운 날씨: 더운 여름이나 추운 겨울에는 강아지를 위한 추가적인 보호와 산책 시간을 조절하는 것이 중요합니다.</p>
		            <p>6. 휴식과 물 공급: 긴 산책 동안은 강아지가 휴식을 취할 수 있는 시간을 주고 충분한 물을 제공해야 합니다.</p>
		            <p>7. 유해한 물질에 대한 경계: 산책 중 강아지가 유해한 물질을 섭취하지 않도록 주의해야 합니다. 
		                평범한 산책 길에도 강아지에게 위험할 수 있는 물건이 있을 수 있습니다.</p>
		            <p>8. 보호 동물에 대한 주의: 일부 강아지는 보호 본능이 강해지므로 다른 동물과의 만남에 주의해야 합니다.</p>
		            <p>9. 반려동물 보험: 산책 중에 사고가 발생할 수 있으므로 강아지에게 적절한 보험 가입을 고려해보는 것이 좋습니다.</p>
		        		
        			<span><input type="checkbox"> 위의 동의서를 읽고 동의합니다. </span>
        		</div>
        	</div>
        	<button type="submit" id="signup" class="signup">회원가입</button>
        </form>
    </body>
</html>