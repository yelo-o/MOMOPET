$(() => {
    const findidObj = $('form.findid')

    findidObj.submit((e) => {

        const backURL = '/momopet'

        $.ajax({
            url: `${backURL}/findid`,
            method: 'post',
            data: findidObj.serialize(),
            success: (responseData) => {
				if(responseData==0){
					alert('아이디가 없습니다')
				}else{ //아이디정보찾기가 성공한 경우
				location.href='afterfindid.jsp'
				console.log("아이디찾기 성공")
				}
			},
			error:(xhr)=>{
				alert("에러 : "+xhr.status)
			}
			})
			return false;
		})
	})