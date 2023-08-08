$(()=>{
	//URL 맵핑
	const backURL = '/momopet'
	
	$('button').click((e) => { //버튼 클릭
		const btnObj = $(e.currentTarget).attr('class') //클릭한 버튼의 class값 가져옴
		//alert(btnObj)
	    
		$.ajax({
			url:`${backURL}/confirmrequest`,
			method:'post',
			data:'sitterId='+ btnObj, //sitterId=id7 <= 이런식으로 보내줌
			//dataType:"text",
			success:(responseData) =>{
				if (responseData == 0) {
					alert('조회된 시터가 없습니다.')
				} else { 
				location.href=`${backURL}/recheck` //성공 시에, recheck로 주소 이동
				alert('조회성공')
				}
			},
			error: (xhr)=>{
				alert("에러 :" +xhr.status)
			}
		})
		return false
	})
})
