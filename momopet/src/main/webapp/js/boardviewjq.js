$(()=>{
	//버튼 맵핑
	const deleteBtn = $('.delete')
	const updatePageBtn = $('.updatepage')
	
	//내용 맵핑
	const boardNo = $('div.info > dl:first-child() dd').html() //게시판번호 가져옴
	const boardId = $('.info > dl:nth-child(2) dd').html() //게시판 작성자 가져옴
	
	//--삭제버튼 클릭 START--
    deleteBtn.click((e)=>{
		// alert("e의 값은 : "+ e)
		//alert("e.CurrentTarget의 값은 : "+ e.currentTarget)
        $.ajax({
            url: `/momopet/deleteboard`,
			method: 'get',
            data: `boardNo=${boardNo}&boardId=${boardId}`,
            success: (responseData)=>{
				//alert(responseData)
				if(responseData == 0){
					location.href=`/momopet/boardlist`;
					alert('본인의 게시물만 삭제할 수 있습니다!')
				} else { // 게시물 등록 성공한 경우
					location.href=`/momopet/boardlist`;
					alert('게시물 삭제 완료!');
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
    //--삭제버튼 클릭 END--
    
    
    //--수정페이지이동 버튼 클릭 START--
	updatePageBtn.click((e)=>{
		//alert("e의 값은 : "+ e)
		//alert("e.CurrentTarget의 값은 : "+ e.currentTarget)
		$.ajax({
			url: `/momopet/boardeditpage`,
			method: 'get',
            data: `boardNo=${boardNo}`,
            success: (responseData)=>{
                $('div.board_wrap').empty()
                $('div.board_wrap').html(responseData)

            },
            error: (xhr)=>{
				alert("에러" + xhr.status)
			}
        })
		// return false;
			
		})
    
    
})