$(() => {
	const updateBtn = $('.button') //회원수정하기 버튼 선언
	const sectionObj = $('section#mypagenav>div') //ajax로 바뀌어질 섹션 선언
	
	updateBtn.click(() => {
		$.ajax({
			url:`/momopet/csinfoupdatepage`,
			method :'post',
			//data: updateBtn.serialize(),
			success:(responseData) => {
				sectionObj.empty()
				sectionObj.html(responseData)  
			},
			error:(xhr) => {
				alert("에러" + xhr.status)
			}
		})
		return false;
		/*location.href('momopet/jsp/infoupdate.jsp')
        alert("수정페이지로 이동합니다.");*/
	})
 });