$(()=>{
	//버튼맵핑
	const btyes=$('form>button.yes')
	const btno=$('form>button.no')
	//url 맵핑
	const backURL='/momopet'
	
	//내용맵핑
	//(c:set에서 가져온)sitterName, sitterId, sitterGender 보낼 수 있는 방법
	
		
	btyes.click(()=>{
	const sitterId = $(".sitterId").html()
	const startDate =$('#startDate').val()
	const endDate =$('#endDate').val()
	
		
	if(startDate > endDate || startDate == "" || endDate == ""){
		alert('날짜 확인해주세요')
		location.reload()
	}
	else {
		
		alert('돌봄신청합니다')
		
		$.ajax({
			url:`${backURL}/addtohistory`,
			/*data: `sitterId=${sitterId}`,*/
			data: `sitterId=${sitterId}&startDate=${startDate}&endDate=${endDate}`,
			success:(responseData)=>{
				if(responseData==0){	
				alert('로그인하세요')
				} else { //성공한 경우
			alert('돌봄신청이 완료되었습니다')
				location.href=`${backURL}/jsp/completedrequest.jsp`
				}
			},
			error:(xhr)=>{
				alert("에러 : "+xhr.status)
			}
		});
	}
	});
})