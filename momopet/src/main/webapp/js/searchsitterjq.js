//dom트리가 완성되고
//렌더링준비가 완료되었을 때 window객체의 load이벤트가 발생한다

$(()=>{
    //DOM트리에서 form객체찾기
    const formObj = $('form.searchsitter')

    //시터조회버튼 객체찾기
    const btSubmit = $('#submit')

	const backURL = '/momopet'
		
    //가입버튼-전송버튼 클릭->폼의 서브밋이벤트발생 
    //--시터조회 클릭해서 시터 목록 불러오기 START--
    formObj.submit((e)=>{
		
        
        $(e.target)
        .attr('action', 'http://localhost:8888/momopet/sitterlist')
        .attr('method', 'get')
l
        $.ajax({
            url: $(e.target).attr('action'),
            method: $(e.target).attr('method'),
            data: formObj.serialize(),
            success: (responseObj)=>{
                if(responseObj.trim() == '0'){
                    //실패경우 할 일
                    /*alert("실패:" + responseObj.msg)*/
                    alert("시터조회 실패")
                } else {
                    //성공경우 할 일
                    //location.href='sitterlistresult.jsp'
                    location.href=`/momopet/sitterlist`
                    alert("시터조회 성공!")
                }               
            },
            error: (xhr)=>{
				alert("에러:" + xhr.status)
            }
        })

        return false //e.preventDefault() e.stopPropagation()

    })
    
    
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
