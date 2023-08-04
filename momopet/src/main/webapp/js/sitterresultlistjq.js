$(()=>{
	//버튼맵핑
	const btRequest = $('.request')
	
	//URL 맵핑
	const backURL = '/momopet'
	
	//내용맵핑
	const sitterId = $('.sitterId').html()
	const name = $('.name').html()
	const gender = $('.gender').html()
	
	
	
	
	//요청하기버튼 누르면 요청했던 시터의 정보들이 히스토리로 간다.
	
	$("form").submit((e)=>{
        $.ajax({
			url:`${backURL}/confirmrequest`,
			method:'get',
			data:`sitterId=${sitterId}&name=${name}&gender=${gender}`,
			success:(responseDate) =>{
				if(responseDate==0){
					alert('조회된 시터가 없습니다.')
				}else{
				location.href=`${backURL}/recheck`,
				alert('조회성공')
				}
			},
			error: (xhr)=>{
				alert("에러 :" +xhr.status)
			}
			
		})
	})
})