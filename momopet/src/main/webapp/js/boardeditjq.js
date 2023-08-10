$(()=>{
	//** 수정버튼 눌렀을 때의 formObj **
	const updateObj = $('#f1') //id 값이 "f1"
	
	//--수정 버튼 클릭 START--
    updateObj.submit(()=>{
		// post 방식으로 보낼 때 불러온 boardNo 값은 name 값으로 가져올 수 없어서 직접 serialize()에 붙여줌
		let boardData = updateObj.serialize()
		boardData += "&boardNo="+$("#btNo").html(); //서블릿 통해 불러온 boardNo 같이 붙여서 보냄
		//alert("e의 값은 : "+ e)
		//alert("e.CurrentTarget의 값은 : "+ e.currentTarget)
		$.ajax({
			url: '/momopet/updateboard',
			method: 'post',
            //data: updateObj.serialize(),
            data: boardData, 
            success: (responseData)=>{
				//alert(responseData);
				if(responseData == 0){
					location.href=`/momopet/boardlist`; //게시판 목록 페이지로 이동
					alert('본인의 게시물만 수정할 수 있습니다!')
				} else { // 게시물 수정 성공한 경우
					location.href=`/momopet/boardlist`; //게시판 목록 페이지로 이동
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