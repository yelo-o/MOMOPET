$(() => {
	const sectionObj = $('section#mypagenav>div')
	
	//--페이지 이동 버튼 클릭할 때 할일 START--
	$('div.pagegroup>span').click((e) => {
		//alert("클릭")
		//$(e.target).css("background-color", "#000")
		const classValue = $(e.target).attr('class') //page 3, page 4, page 7
		//alert("클래스 value : " + classValue)
		const pageNo = classValue.substring(5) //공백포함 5자리 자르기
		//alert("페이지를 요청 : " + pageNo)
		//location.href = `reviewlist2?cp=${pageNo}`
		$.ajax({
			url:'/momopet/customerreviewlist', // ★ 맵핑에 숫자 들어가면 cp 인식 안됨
			method:'post',
			data: 'cp='+ pageNo, //pageNo 전달
			success:(responseData) => {
				sectionObj.empty()
				sectionObj.html(responseData) 
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
	})
	//--페이지 이동 버튼 클릭할 때 할일 END--

	//--페이지 이동 hover START--
	$('div.pagegroup>span').hover((e) => {
		$(e.target).css("background-color", "#000")
		$(e.target).css("color", "white")
	}, (e) => {
		$(e.target).css("background-color", "white")
		$(e.target).css("color", "black")
	})
	//--페이지 이동 hover END--
})