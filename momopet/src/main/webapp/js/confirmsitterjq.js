$(()=>{
	const btyes=$('form>button.yes')
	const btno=$('form>button.no')
	const backURL='/momopet'
	
	btyes.click(()=>{
		alert('돌봄신청합니다')
		$.ajax({
			url:`${backURL}/requestsitter`,
			success:(responseData)=>{
				if(responseData==1){
				alert('돌봄신청이 완료되었습니다.')
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
		window.location.href=`${backURL}/jsp/searchsitter.jsp`
		
	});
});