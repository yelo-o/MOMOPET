// 주소 검색후 데이터 받아오기

function getAddr(){

	// AJAX 주소 검색 요청

	$.ajax({

		url:"http://www.juso.go.kr/addrlink/addrLinkApiJsonp.do"	// 주소검색 OPEN API URL

		,type:"post"

		,data:$("#form").serialize() 								// 요청 변수 설정

		,dataType:"jsonp"											// 크로스도메인으로 인한 jsonp 이용, 검색결과형식 JSON 

		,crossDomain:true

		,success:function(jsonStr){									// jsonStr : 주소 검색 결과 JSON 데이터			

			$("#list").html("");									// 결과 출력 영역 초기화

			var errCode = jsonStr.results.common.errorCode;

			var errDesc = jsonStr.results.common.errorMessage;

			if(errCode != "0"){ 

				$("#pageApi").html("");

				if(errCode ==  "E0001"){ alert("승인되지 않은 KEY입니다."); }

				else if(errCode ==  "E0005"){ alert("검색어를 입력해주세요."); }

				else if(errCode ==  "E0006"){ alert("시도명으로는 검색이 불가합니다."); }

				else { alert("에러가 발생하였습니다. 잠시후 다시 시도해주세요."); }

			}else{

				if(jsonStr!= null){

					makeListJson(jsonStr);							// 결과 JSON 데이터 파싱 및 출력

					pageMake(jsonStr);

				}

			}

		}

		,error: function(xhr,status, error){

			alert("에러발생");										// AJAX 호출 에러

		}

	});

}



// 주소검색한 리스트를 html에 생성

function makeListJson(jsonStr){

	var htmlStr = "";

	htmlStr += "<table>";

	// jquery를 이용한 JSON 결과 데이터 파싱

	$(jsonStr.results.juso).each(function(){

		htmlStr += "<tr>";

		htmlStr += "<td>"+this.roadAddrPart1+"</td>";

		htmlStr += "<td>"+this.roadAddrPart2+"</td>";

		htmlStr += "<td>"+this.engAddr+"</td>";

		htmlStr += "<td>"+this.zipNo+"</td>";

     	htmlStr += "<td><input type=\"button\" onclick=\"addressing(\'"+this.zipNo+"\',\'"+this.roadAddrPart1+"\',\'"+this.roadAddrPart2+"\')\" value=\"선택\"></td>";

		htmlStr += "</tr>";

	});

	htmlStr += "</table>";

	// 결과 HTML을 FORM의 결과 출력 DIV에 삽입

	$("#list").html(htmlStr);

}	



// 주소값 넣어주기

function addressing(zipNo,roadAddrPart1,roadAddrPart2){

	document.form.zipNo.value = zipNo; // 우편번호

	document.form.addr.value = roadAddrPart1;//+" "+roadAddrPart2; // 도로명주소

}



//페이지 이동

function goPage(pageNum){

	document.form.currentPage.value=pageNum;

	getAddr();

}



// json타입 페이지 처리 (주소정보 리스트 makeListJson(jsonStr); 다음에서 호출)

function pageMake(jsonStr){

	var total = jsonStr.results.common.totalCount; // 총건수

	console.log("총건수:"+total);

	var pageNum = document.form.currentPage.value;// 현재페이지

	var paggingStr = "";

	if(total < 1){

		var htmlStr = "";

		htmlStr += "<table>";

		htmlStr += "<tr>";

		htmlStr += "<td>검색결과가 없습니다.</td>";

		htmlStr += "</tr>";

		htmlStr += "</table>";

		$("#list").html(htmlStr);

		$("#pageApi").html("");

	}else{

		if(total > 1000){

			total=1000;

		}

		var PAGEBLOCK=10; // 10

		var pageSize=10; // 10

		var totalPages = Math.floor((total-1)/pageSize) + 1; // 총페이지

		var firstPage = Math.floor((pageNum-1)/PAGEBLOCK) * PAGEBLOCK + 1; // 리스트의 처음 ( (2-1)/10 ) * 10 + 1 // 1 11 21 31

		if( firstPage <= 0 ) firstPage = 1;	// 처음페이지가 1보다 작으면 무조건 1

		var lastPage = firstPage-1 + PAGEBLOCK; // 리스트의 마지막 10 20 30 40 50

		if( lastPage > totalPages ) lastPage = totalPages;	// 마지막페이지가 전체페이지보다 크면 전체페이지

		var nextPage = lastPage+1 ; // 11 21 

		var prePage = firstPage-PAGEBLOCK ;	

		if( firstPage > PAGEBLOCK ){

			paggingStr +=  "<a href='javascript:goPage("+prePage+");'>◁</a>  " ; // 처음 페이지가 아니면 <를 넣어줌

		}		

		for(var i=firstPage; i<=lastPage; i++ ){

			if( pageNum == i )

				paggingStr += "<a style='font-weight:bold;color:blue;font-size:15px;' href='javascript:goPage("+i+");'>" + i + "</a>  ";

			else

				paggingStr += "<a href='javascript:goPage("+i+");'>" + i + "</a>  ";

		}		

		if( lastPage < totalPages ){

			paggingStr +=  "<a href='javascript:goPage("+nextPage+");'>▷</a>"; // 마지막페이지가 아니면 >를 넣어줌

		}		

		$("#pageApi").html(paggingStr);

	}	

}