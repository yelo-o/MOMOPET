//dom트리가 완성되고
//렌더링준비가 완료되었을 때 window객체의 load이벤트가 발생한다

$(()=>{
    //DOM트리에서 form객체찾기
    const formObj = $('form.signup')
    
    //아이디입력란 객체찾기
    // const inputIdObj = document.querySelector('form.signup>input[type=text]')
    const inputIdObj = $('#id')
    
    //아이디중복확인버튼 객체찾기
    /*const btIdDupchk = document.getElementById('btIdDupchk');*/
    const btIdDupchk = $('#btIdDupchk')

    //가입버튼 객체찾기
    const btSignup = $('#signup')
    
    //펫등록버튼 객체찾기
    const btPetSignup = $('#petsignup')
    
    //펫정보 입력 부분 객체찾기
    const divPetInfo = $('#petInfo')
    
    //약관동의서 객체찾기
    const divTerms = $('#terms')
    
    //약관동의서 동의체크박스 객체찾기
    const chkbxTerms = $('#termscheck')

	const backURL = '/momopet'
	
	//--아이디중복확인 클릭시 할 일 START--
    btIdDupchk.click(()=>{
	    $.ajax({
			url: 'http://localhost:8888/momopet/iddupchk',
			method: 'get',
			data: `id=${inputIdObj.val()}`,
			success: (responseData)=>{
				if(responseData.trim() == '0'){
					alert('이미 사용중인 아이디입니다')
				}else{
					alert('사용가능한 아이디입니다')
				}
			},
			error: (xhr)=>{
				alert("에러:" +xhr.status)
			}
		})  
    })
    //--아이디중복확인 클릭시 할 일 END--

 
	//--역할 선택시 할 일 START--
	$(function() {
	    $('#userType').change(function(){
	        if($('#userType').val() == '0') {
	            divPetInfo.hide()	
	            divTerms.show()
	            btSignup.show()
	        } else if($('#userType').val() == '1') {
	            divTerms.hide()
	            divPetInfo.show()
	            btSignup.show()
	        } else {
				divTerms.hide()
				divPetInfo.hide()
				btSignup.hide()
			}
	    })		
	})
	//--역할 선택시 할 일 END--
	
	//--펫등록 클릭시 할 일 START--
	btPetSignup.click(()=>{
	    $.ajax({
			url: 'http://localhost:8888/momopet/petsignup',
			method: 'post',
			data: formObj.serialize(),
			success: (responseData)=>{
				if(responseData.trim() == '0'){
					alert('펫등록 실패')
				}else{
					alert('펫등록 성공')
				}
			},
			error: (xhr)=>{
				alert("에러:" +xhr.status)
			}
		})  
    })
	//--펫등록 클릭시 할 일 END--
	
    //가입버튼-전송버튼 클릭->폼의 서브밋이벤트발생 
    //--폼 서브밋이벤트발생시 할 일 START--
    formObj.submit((e)=>{
        //비밀번호1,2가 일치 확인
        const pwdObj = $('#pwd')
        const pwd1Obj = $('#pwd1')
        
        if(pwdObj.val() != pwd1Obj.val()) {
            alert('비밀번호가 일치하지 않습니다')
            pwdObj.focus()
            return false
        } 

        if($('#role').val() == '0' && chkbxTerms.prop('checked') == false) {
	        alert('필수약관 동의는 필수입니다')
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
                    alert("회원가입 실패")
                } else {
                    //성공경우 할 일
                    location.href='login.jsp'
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

/*    //--아이디입력란에 focus이벤트발생시 할 일 START--
    inputIdObj.focus(()=>{
        btSignup.css('display', 'none');
    })
    //--아이디입력란에 focus이벤트발생시 할 일 END--*/
})
