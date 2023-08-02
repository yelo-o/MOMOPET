$(() => {
    const searchidObj = $('form.searchid')

    searchidObj.submit((e) => {

        const backURL = '/momopet'
        const name=$('input[name=name]').val()
        const email=$('input[name=email]').val()

        $.ajax({
            url: `${backURL}/searchid`,
            method: 'get',
            /*data: searchidObj.serialize(),*/
            data: `name=${name}&email=${email}`,
            success: (responseData) => {
				if(responseData==0){
					alert('아이디가 없습니다')
				}else{ //아이디정보찾기가 성공한 경우
				location.href=`${backURL}/resultid`
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