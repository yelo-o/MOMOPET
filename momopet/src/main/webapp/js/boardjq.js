$(()=>{
	
	//--게시글 클릭해서 상세정보 불러오기 START--
    $('div.board').click((e)=>{
        const boardNo = $(e.currentTarget).attr('class').split(" ")[1]
        $.ajax({
            url: `/momopet/board`,
            data: `boardNo=${boardNo}`,
            success: (responsedata)=>{
                $('.board_wrap').empty()
                $('.board_wrap').html(responsedata)
            },
            error: (xhr)=>{
				alert("에러" + xhr.status)
			}
        })
    })
    //--게시글 클릭해서 상세정보 불러오기 END--

    //--게시글 등록 버튼 클릭 START--
    $('button.on').click(() => {
		$('.board_wrap').load('/momopet/jsp/boardwrite.jsp')
	})
    //--게시글 등록 버튼 클릭 END--
	
	//--페이지 이동 버튼 클릭할 때 할일 START--
    $('div.pagegroup>span').click((e)=>{
		//$(e.target).css("background-color", "#000")
		const classValue = $(e.target).attr('class') //page 3, page 4, page 7
		//alert("클래스 value : " + classValue)
		const pageNo = classValue.substring(5)
		//alert("페이지를 요청 : " + pageNo)
		location.href=`boardlist?cp=${pageNo}`
	})
	//--페이지 이동 버튼 클릭할 때 할일 END--
	
	//--페이지 이동 hover START--
    $('div.pagegroup>span').hover((e)=>{
		$(e.target).css("background-color", "#000")
		$(e.target).css("color", "white")
	}, (e)=>{
		$(e.target).css("background-color", "white")
		$(e.target).css("color", "black")
	})
	//--페이지 이동 hover END--
})