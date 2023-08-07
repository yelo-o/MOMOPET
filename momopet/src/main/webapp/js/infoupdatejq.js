$(() => {
	const infoupdateObj = $('form.infoupdate')

//--수정 버튼 클릭 START--
	infoupdateObj.submit(() => {
		// post 방식으로 보낼 때 불러온 boardNo 값은 name 값으로 가져올 수 없어서 직접 serialize()에 붙여줌
		//let infoData = updateObj.serialize()
		//infoData += "&boardNo="+$("#btNo").html(); //서블릿 통해 불러온 boardNo 같이 붙여서 보냄
		//alert("e의 값은 : "+ e)
		//alert("e.CurrentTarget의 값은 : "+ e.currentTarget)
		$.ajax({
			url: '/momopet/infoupdate',
			method: 'post',
			data: infoupdateObj.serialize(),
			//data: Data, 
			success: (responseData) => {
				//alert(responseData);
				if (responseData == 0) {
					location.href = `/momopet/jsp/layout.jsp`; //게시판 목록 페이지로 이동
					alert('회원정보 수정실패!')
				} else { // 게시물 수정 성공한 경우
					location.href = `/momopet/customerinfocheck`; //게시판 목록 페이지로 이동
					alert('회원정보 수정완료!');
				}
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})

	})
    //--수정 버튼 클릭 END--
    
    
     $(function() {
 
       $(".buttonback").bind('click', function() {
          window.location.href = '../customerinfocheck';
          alert("내 정보확인으로 이동합니다.");
 
       });
    });
    
    
    
 });