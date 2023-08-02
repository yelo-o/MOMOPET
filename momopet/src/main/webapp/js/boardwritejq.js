$(()=>{
	const addboardObj = $('form.board_wrap')

	//--등록 버튼 클릭해서 상세정보 불러오기 START--
    addboardObj.submit((e)=>{
		// alert("e의 값은 : "+ e)
		//alert("e.CurrentTarget의 값은 : "+ e.currentTarget)
        $.ajax({
            url: `/momopet/addboard`,
			method: 'post',
            data: addboardObj.serialize(),
            success: (responseData)=>{
				//alert(responsedata)
				if(responseData == 0){
					location.href=`/momopet/boardlist`;
					alert('게시물 등록 실패 ㅠㅠ')
				} else { // 게시물 등록 성공한 경우
					location.href=`/momopet/boardlist`;
					alert('게시물 등록 완료!');
					// location.reload();
				}
                //location.href = `/momopet/jsp/boardview.jsp`
                // $('div.board_wrap').empty()
                // $('div.board_wrap').html(responsedata)

            },
            error: (xhr)=>{
				alert("에러" + xhr.status)
			}
        })
		return false;
    })
    //--등록 버튼 클릭해서 상세정보 불러오기 END--
})