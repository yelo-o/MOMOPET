$(() => {
	const sectionObj = $('section#mypagenav>div')
	
	
	//--페이지 이동 버튼 클릭할 때 할일 START--
	$('div.pagegroup>span').click((e) => {
		//alert("클릭")
		//$(e.target).css("background-color", "#000")
		const classValue = $(e.target).attr('class') //page 3, page 4, page 7
		//alert("클래스 value : " + classValue)
		const pageNo = classValue.substring(5) //공백포함 5자리 자르기
		//alert("페이지를 요청 : " + pageNo)
		//location.href = `reviewlist2?cp=${pageNo}`
		$.ajax({
			url:'/momopet/customerreviewlist', // ★ 맵핑에 숫자 들어가면 cp 인식 안됨
			method:'post',
			data: 'cp='+ pageNo, 
			success:(responseData) => {
				sectionObj.empty()
				sectionObj.html(responseData) 
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
		return false
	})
	//--페이지 이동 버튼 클릭할 때 할일 END--

	//--페이지 이동 hover START--
	$('div.pagegroup>span').hover((e) => {
		$(e.target).css("background-color", "#000")
		$(e.target).css("color", "white")
	}, (e) => {
		$(e.target).css("background-color", "white")
		$(e.target).css("color", "black")
	})
	//--페이지 이동 hover END--
	
	//--삭제 버튼을 클릭할 때 할 일 START--
	/*$('button').click((e) => {
		const btnObj = $(e.currentTarget).attr('class')
		alert('클릭 확인')
		alert(btnObj)
		
		$.ajax({
			url:'/momopet/deletereview', 
			method:'post',
			data:'reviewNo='+ btnObj,
			success:(responseData) => {
				alert(responseData)
				location.href='momopet/reviewrecheck' //성공 시에, reviewrecheck주소로 이동
				alert('조회성공')
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
	}) */
	
/*	const deleteBtn = $('.delete')
	const updateBtn = $('.update')
	const reviewNo = $('#reviewNo').html()*/
	
	
	$('button').click((e)=>{
		const btnObj = $(e.currentTarget).attr('class')
		/*alert(btnObj)*/
	
		$.ajax({
			url: '/momopet/deletereview',
			method: 'post',
			data: `reviewNo=${btnObj}`,
			success: ()=>{
				location.href=`/momopet/jsp/mypage.jsp`
				alert('리뷰 삭제 완료!')
			},
			
			error: (xhr)=>{
				alert("에러" + xhr.status)
			}
		})
	})
})