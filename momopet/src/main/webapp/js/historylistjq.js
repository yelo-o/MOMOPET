$(()=>{
	const sectionObj = $('section#mypagenav>div') //ajax로 바뀌어질 섹션 선언
	const approveBtn = $('.approveBtn') //승인 버튼
	const cancelBtn = $('.cancelBtn') //취소 버튼
	
	
    //--페이지 이동 버튼 클릭할 때 할일 START--
    $('div.pagegroup>span').click((e) => {
		//$(e.target).css("background-color", "#000")
		const classValue = $(e.target).attr('class') //page 3, page 4, page 7
		//alert("클래스 value : " + classValue)
		const pageNo = classValue.substring(5)
		//alert("페이지를 요청 : " + pageNo)
		$.ajax({
			url: '/momopet/historylist', //HisotryListServlet 서블릿 호출
			method: 'post',
			data: 'cp='+ pageNo, //pageNo 전달
			success: (responseData) => {
				sectionObj.empty()
				sectionObj.html(responseData) 
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
	})
    //--페이지 이동 버튼 클릭할 때 할일 END--
    
    //--승인 버튼 클릭 때 할 일 START--
    $('button').click((e) => {
		const classValue = $(e.target).attr('class')
		//alert(classValue)
		const hStatus = classValue.substring(0,1)
		const hNo = classValue.substring(2)
		//alert("hStatus:"+ hStatus)
		//alert("hNo:"+ hNo)
		
		$.ajax({
			url: '/momopet/updatehistorystatus',
			method: 'post',
			data: 'historyNo=' + hNo + '&status=' +  hStatus, //pageNo 전달
			success: (responseData) => {
				if (responseData == 0) {
					location.href=`/momopet/jsp/mypage.jsp`;
					alert("요청 실패")
				} else {
					location.href=`/momopet/jsp/mypage.jsp`;
					alert("요청 완료")
				}
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
	})
    
    
    //--승인 버튼 클릭 때 할 일 END--
})
