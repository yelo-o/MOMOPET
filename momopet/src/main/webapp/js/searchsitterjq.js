//dom트리가 완성되고
//렌더링준비가 완료되었을 때 window객체의 load이벤트가 발생한다

$(()=>{
    //DOM트리에서 form객체찾기
    const formObj = $('form.searchsitter')

    //시터조회버튼 객체찾기
    const btSubmit = $('#submit')
		

    //--시터조회 클릭해서 시터 목록 불러오기 START--
    formObj.submit((e)=>{
		//alert("e의 값은 : " + e)
		//alert("e.CurrentTarget의 값은 : " + e.currentTarget)

        $.ajax({
            url: `/momopet/searchsitter`,
            method: 'post',
            /*data: formObj.serialize(),*/
            data:formObj.serialize(),
            success: (responseData)=>{
				/*location.href=`/momopet/jsp/sitterlistresult.jsp`*/
				/*location.href=`/momopet/sitterlist`*/
/*				if(responseData==0) {
					alert("조회실패")	
				}else{ //성공한 경우
					location.href=`/momopet/sitterlist`
					alert("조회성공!")
				}*/
				/*location.href=`/momopet/sitterlist`
				alert("조회성공!")*/
				$('body').empty()
				$('body').html(responseData)
			},
            error: (xhr)=>{
				alert("에러:" + xhr.status)
            }
        })

        return false //e.preventDefault() e.stopPropagation()

    })
    //--시터조회 클릭해서 시터 목록 불러오기 END--
    
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
