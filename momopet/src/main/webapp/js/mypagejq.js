$(() => {
	const infoChkBtn = $('.customerInfoChk') //내정보 확인 버튼 변수선언
	const sectionObj = $('section#mypagenav>div') //ajax로 바뀌어질 섹션 선언
	const histChkBtn = $('.historylistChk')  //history 누르면 섹션변경
	const cusReviewListBtn = $('#sitterReviewList')
	const sitReviewListBtn = $('#customerReviewList')
	const cusReviewBtn = $('#customerReview')


	infoChkBtn.click(() => {
		$.ajax({
			url: '/momopet/customerinfocheck',
			method: 'post',
			//data:infoChkBtn.serialize(),
			success: (responseData) => {
				//customerinfo.jsp 파일의 내용을 sectionObj에 넣음
				sectionObj.empty()
				sectionObj.html(responseData)
			},
			error: (xhr) => {

				alert("에러" + xhr.status)
			}
		})
		return false //a 태그의 기본동작인 주소 이동 막음(ajax로 sectionObj에 내용을 넣을 것이기 때문에)
	})

	// 내가 받은 리뷰 보기(시터 입장)
	/*	const checkReviewsBtn = $("#checkReviewsLink")
		checkReviewsBtn.click((e) => {
			e.preventDefault() // 링크 기본 동작(페이지 이동) 막기
			$.ajax({
				url: '/momopet/reviewlist', 
				type: "GET",
				success: (responseData) => { //"/jsp/checkreview.jsp" 파일 내용을 responseData에 저장
					sectionObj.empty()
					sectionObj.html(responseData) //section에 출력
				},
				error: (xhr) => {
					alert("에러" + xhr.status)
				}
			})
		})*/
	// 내가 쓴 리뷰 보기(이용자 입장)
	/*	const checkReviewsBtn2 = $("#checkReviewsLink2")
		checkReviewsBtn2.click((e) => {
	
			e.preventDefault() // 링크 기본 동작(페이지 이동) 막기
			$.ajax({
				url: '/momopet/reviewlist2', 
				type: "GET",
				success: (responseData) => { //"/jsp/checkreview2.jsp" 파일 내용을 responseData에 저장
					sectionObj.empty()
					sectionObj.html(responseData) //section에 출력
				},
				error: (xhr) => {
					alert("에러" + xhr.status)
				}
			})
	
		})*/

	histChkBtn.click(() => {
		$.ajax({
			url: '/momopet/historylist',
			method: 'post',
			//data:infoChkBtn.serialize(),
			success: (responseData) => {
				//customerinfo.jsp 파일의 내용을 sectionObj에 넣음
				sectionObj.empty()
				sectionObj.html(responseData)  
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
		return false //a 태그의 기본동작인 주소 이동 막음(ajax로 sectionObj에 내용을 넣을 것이기 때문에)
	})

	cusReviewListBtn.click(() => {
		$.ajax({
			url: '/momopet/sitterreviewlist',
			method: 'post',
			//data:infoChkBtn.serialize(),
			success: (responseData) => {
				//alert(responseData)
				sectionObj.empty()
				sectionObj.html(responseData)
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
		return false //<a> 기본 동작인 주소 이동 막음(ajax로 section에 전달받은 responseData 넣기 위해)
	})

	sitReviewListBtn.click(() => {
		$.ajax({
			url: '/momopet/customerreviewlist',
			method: 'post',
			//data:infoChkBtn.serialize(),
			success: (responseData) => {
				//alert(responseData)
				sectionObj.empty()
				sectionObj.html(responseData)
			},
			error: (xhr) => {
				alert("에러" + xhr.status)
			}
		})
		return false //a 태그의 기본동작인 주소 이동 막음(ajax로 sectionObj에 내용을 넣을 것이기 때문에)
	})


	cusReviewBtn.click(() => {
		$.ajax({
			url: '/momopet/jsp/review.jsp', // JSP 파일을 로드할 URL을 설정
			method: 'get',
			success: (responseData) => {
				sectionObj.empty();
				sectionObj.html(responseData); // 로드된 JSP 파일의 내용을 삽입
			},
			error: (xhr) => {
				alert("에러 " + xhr.status);
			}
		});
		return false; //<a> 기본 동작인 주소 이동 막음(ajax로 section에 전달받은 responseData 넣기 위해)
	});

})




