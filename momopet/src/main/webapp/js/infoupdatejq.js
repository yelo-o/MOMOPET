$(() => {
	const infoupdateObj = $('form.infoupdate')
	const sectionObj = $('section#mypagenav>div') //ajax로 바뀌어질 섹션 선언
	const backBtn = $('.buttonback')

	//--수정 버튼 클릭 START--
	infoupdateObj.submit(() => {
		$.ajax({
			url: '/momopet/infoupdate',
			method: 'post',
			data: infoupdateObj.serialize(),
			//data: Data, 
			success: (responseData) => {
				//alert(responseData);
				if (responseData == 0) {
					location.href = `/momopet/jsp/layout.jsp`;
					alert('회원정보 수정실패!')
				} else { // 게시물 수정 성공한 경우
				
				    sectionObj.html()
				    sectionObj.html(responseData)
					//location.href = `../jsp/layout.jsp`;
					alert('회원정보 수정완료!');
				}
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})

	})
	//--수정 버튼 클릭 END--

	//--뒤로가기 버튼 클릭 START--
	backBtn.click(() => {
		$.ajax({
			url: '/momopet/customerinfocheck',
			method: 'post',
			success: (responseData) => {
				sectionObj.html()
				sectionObj.html(responseData)
				alert("내 정보확인으로 이동합니다.");
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
		//--뒤로가기 버튼 클릭 END--

	});
})
