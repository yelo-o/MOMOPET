$(()=>{
	//** 수정 버튼 클릭하여 업데이트하는 제이쿼리**
	//const updatePageBtn = $('.updatepage')
	const updateObj = $('#f1')

	const boardNo = $('div.info > dl:first-child() dd').html() //게시판번호 가져옴
	//const boardId = $('.info > dl:nth-child(2) dd').html() //게시판 작성자 가져옴
	//const boardTitle =$('.board_view > .title').html() //게시판 제목 가져옴
	//const boardContent =$('.board_view > .cont').html() //게시판 제목 가져옴
	
	/*
	updateBtn.click((e)=>{
		console.log(e.currentTarget)
		console.log(boardTitle)
		console.log(boardContent)
	})
	*/
	//--수정 버튼 클릭 START--
    updateObj.submit((e)=>{
		let boardData = updateObj.serialize()
		boardData += "&boardNo="+$("#btNo").html();
		/*let boardData2 = "boardNo="+$("#btNo").html()+"&boardTitle="+boardTitle+"&boardContent="+boardContent
		const boardTitle = $('#boardTitle').html();
		const boardContent = $('#boardContent').html();
		alert(boardTitle)
		alert(boardContent)*/
		//alert(boardData2)
		//alert("e의 값은 : "+ e)
		//alert("e.CurrentTarget의 값은 : "+ e.currentTarget)
		$.ajax({
			url: '/momopet/updateboard',
			method: 'post',
            //data: updateObj.serialize(),
            //data: boardData,
            data: boardData,
			//data: `boardNo=${boardNo}&boardTitle=${boardTitle}&boardContent=${boardContent}`,
            //data: `boardTitle=${boardTitle}&boardContent=${boardContent}`,
            success: (responseData)=>{
				//alert(responseData);
				if(responseData == 0){
					location.href=`/momopet/boardlist`;
					alert('본인의 게시물만 수정할 수 있습니다!')
				} else { // 게시물 수정 성공한 경우
					location.href=`/momopet/boardlist`;
					alert('게시물 수정 완료!');
				}
            },
            error: (xhr)=>{
				alert("에러" + xhr.status)
			}
        })
			
		})
    //--수정 버튼 클릭 END--

    
})