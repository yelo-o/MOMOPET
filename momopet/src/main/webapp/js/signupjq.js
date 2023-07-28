//dom트리가 완성되고
//렌더링준비가 완료되었을 때 window객체의 load이벤트가 발생한다

$(()=>{
    //DOM트리에서 form객체찾기
    const formObj = $('form.signup')
    
    //아이디중복확인버튼 객체찾기
    /*const btIdDupchk = document.getElementById('btIdDupchk');*/
    const btIdDupchk = $('#btIdDupchk')

    //가입버튼 객체찾기
    const btSignup = $('#signup')

	const backURL = '/momopet'
    //아이디중복확인버튼 - 일반버튼,
        //아이디입력값이 'id1'인 경우
        //'이미사용중인 아이디입니다'경고창
        
        //아이디입력값이 'id1'이 아닌 경우
        //가입버튼 보여주기
    // btIdDupchk.addEventListener('click', (e)=>{
    btIdDupchk.click(()=>{
/*	    $.ajax({
			url: 'http://localhost:8888/momopet/iddupchk',
			method: 'get',
			data: `id=${inputIdObj.val()}`,
			success: (responseData)=>{
				if(responseData.trim() == '0'){
					alert('이미 사용중인 아이디입니다')
				}else{
					btSignup.show()
				}
			},
			error: (xhr)=>{
				alert("에러:" +xhr.status)
			}
		})  */
/*		alert(btSignup)
		btSignup.css('display', 'block')*/
		btSignup.show()
    })
    //가입버튼-전송버튼 클릭->
    //폼의 서브밋이벤트발생 



    //--폼 서브밋이벤트발생시 할 일 START--
    formObj.submit((e)=>{
        //비밀번호1,2가 일치 확인
        const pwdObj = $('form.signup>input[name=pwd]')
        const pwd1Obj = $('#pwd1')
        if(pwdObj.val() != pwd1Obj.val()) {
            alert('비밀번호가 일치하지 않습니다')
            pwdObj.focus()
            return false
        } 
        $(e.target)
        .attr('action', 'http://localhost:8888/momopet/signup')
        .attr('method', 'post')

        $.ajax({
            url: $(e.target).attr('action'),
            method: $(e.target).attr('method'),
            data: formObj.serialize(),
            success: (responseObj)=>{
                if(responseObj.trim() == '0'){
                    //실패경우 할 일
                    /*alert("실패:" + responseObj.msg)*/
                    alert("회원가입 실패: ID는 최대 5자까지 가능합니다")
                } else {
                    //성공경우 할 일
                    location.href='layout.jsp'
                    alert("회원가입 성공!")
                }               
            },
            error: (xhr)=>{
				alert("에러:" + xhr.status)
		
            }
        })

        return false //e.preventDefault() e.stopPropagation()

    })
    //--폼 서브밋이벤트발생시 할 일 END--

    //--아이디입력란에 focus이벤트발생시 할 일 START--
    inputIdObj.focus(()=>{
        btSignup.css('display', 'none');
    })
    //--아이디입력란에 focus이벤트발생시 할 일 END--



})
