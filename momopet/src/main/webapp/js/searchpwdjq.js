$(() => {
    const findidObj = $('form.findpwd')

    findidObj.submit((e) => {

        const backURL = '/momopet'

        $.ajax({
            url: `${backURL}/findpwd`,
            method: 'post',
            data: findidObj.serialize(),
            success: (responseData) => {
				if(responseData==0){
					alert('정보가 없습니다')
				}else{ //비밀번호찾기 정보가 일치한 경우
				location.href='afterfindpwd.jsp'
				console.log("비밀번호정보찾기 성공")
				}
			},
			error:(xhr)=>{
				alert("에러 : "+xhr.status)
			}
			})
			return false;
		})
	})