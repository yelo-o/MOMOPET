$(() => {
	const infoChkBtn = $('.customerInfoChk') //내정보 확인 버튼 변수선언
	const sectionObj = $('section#mypagenav>div') //ajax로 바뀌어질 섹션 선언
	
	infoChkBtn.click(()=>{
		$.ajax({
			url:'/momopet/customerinfocheck',
			method:'post',
			//data:infoChkBtn.serialize(),
			success:(responseData)=>{
				//customerinfo.jsp 파일의 내용을 sectionObj에 넣음
				sectionObj.empty()
				sectionObj.html(responseData)  
			},
			error:(xhr)=>{
				alert("에러" + xhr.status)
			}
		})
		return false //a 태그의 기본동작인 주소 이동 막음(ajax로 sectionObj에 내용을 넣을 것이기 때문에)
	})
})