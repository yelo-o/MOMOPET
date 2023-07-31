$(()=>{
    $('div.board_view').click((e)=>{
        const boardNo = $(e.currentTarget).attr('class').split(" ")[1]

        $.ajax({
            url: `/momopet/board`,
            data: 'boardNo=${boardNo}',
            success: (responsedata)=>{
                location.href = `/momopet/boardView.jsp`

            },
            error: (xhr)=>{
				alert("에러" + xhr.status)
			}
        })
    })

    $('div.pagegroup>span').click((e)=>{
		const classValue = $(e.target).attr('class') //page3, page4, page7
		//alert("클래스 value : " + classValue)
		const pageNo = classValue.substring(5)
		//alert("페이지를 요청 : " + pageNo)
		location.href=`boardlist?cp=${pageNo}`
	})
})