$(()=>{
	//버튼맵핑
	const btyes=$('form>button.yes')
	const btno=$('form>button.no')
	//url 맵핑
	const backURL='/momopet'
	
	//내용맵핑
	const sitterName = $(".sitterName")
	const sitterId = $(".sitterId")
	const sitterGender = $(".sitterGender")
	
	
	btyes.click(()=>{
		alert('돌봄신청합니다')
		$.ajax({
			url:`${backURL}/addtohistory`,
			data: `sitterName=${sitterName}&sitterId=${sitterId}&sitterGender=${sitterGender}`,
			success:(responseData)=>{
				if(responseData==0){
				alert('로그인하세요')
				}else{ //성공한 경우
				location.href=`${backURL}/jsp/completedrequest.jsp`
				}
			},
			error:(xhr)=>{
				alert("에러 : "+xhr.status)
				}
		});
	})
	btno.click(()=>{
		alert('돌보미찾기로 돌아갑니다')
		location.href=`${backURL}/jsp/searchsitter.jsp`
		
	});
});