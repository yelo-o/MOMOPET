$(()=>{
	const sectionObj = $('section#mypagenav>div') //ajax로 바뀌어질 섹션 선언
	
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
})
