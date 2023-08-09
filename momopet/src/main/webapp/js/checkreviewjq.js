$(() => {
	//--페이지 이동 버튼 클릭할 때 할일 START--
	$('div.pagegroup>span').click((e) => {
		//alert("클릭")
		//$(e.target).css("background-color", "#000")
		const classValue = $(e.target).attr('class') //page 3, page 4, page 7
		//alert("클래스 value : " + classValue)
		const pageNo = classValue.substring(10)
		//alert("페이지를 요청 : " + pageNo)
		location.href = `reviewlist?cp=${pageNo}`
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