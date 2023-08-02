$(() => {
    const searhpwdObj = $('form.searchpwd')

    searhpwdObj.submit((e) => {

        const backURL = '/momopet'
        const userId=$('input[name=userid]').val()
        const name=$('input[name=name]').val()
        const email=$('input[name=email]').val()

        $.ajax({
            url: `${backURL}/searchpwd`,
            method: 'get',
            //data: findidObj.serialize(),
            data: `userId=${userId}&name=${name}&email=${email}`,
            success: (responseData) => {
				if(responseData==0){
					alert('정보가 없습니다')
				}else{ //비밀번호찾기 정보가 일치한 경우
				location.href=`${backURL}/resultpwd`
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