$(() => {
	let selectedRating = 0; // 선택한 별점을 저장할 변수
	$(".star-rating img").mouseover(function() {
		if (selectedRating === 0) {
			const ratingValue = $(this).data("rating");
			$(".star-rating img").removeClass("full");
			$(".star-rating img").each(function() {
				if ($(this).data("rating") <= ratingValue) {
					$(this).addClass("full");
				}
			});
		}
	});

	$(".star-rating img").click(function() {
		selectedRating = $(this).data("rating"); // 클릭한 별에 해당하는 별점을 변수에 저장
		$(".star-rating img").removeClass("full");
		$(".star-rating img").each(function() {
			if ($(this).data("rating") <= selectedRating) {
				$(this).addClass("full");
			}
		});
		$("input[name='reviewRating']").val(selectedRating); // 선택한 별점을 숨겨진 입력 필드에 저장
	});

	$("#writeForm").submit((e) => {
		const backURL = '/momopet';
		const frontURL = '/momopet';
		if (selectedRating === 0) {
			alert("별점을 선택해주세요.");
			return false; // 폼 전송 막기
		}
		$(e.target)
			.attr('action', `${backURL}/review`)
			.attr('method', 'post');
		alert("작성하신 리뷰가 등록되었습니다.");

		$.ajax({
			url: $(e.target).attr('action'), //`${backURL}/review`
			method: $(e.target).attr('method'), //post
			data: $(e.target).serialize(), //자료형 자동화
			success: (responseData) => {
				if (responseData.trim() == '0') { //jsp status 값을 기준으로 0, 1 나뉨
					alert('리뷰등록 실패');
				} else {
					location.href = `${frontURL}/jsp/review.jsp`;
				}
			},
			error: (xhr) => {
				alert("에러:" + xhr.status);
			}
		});
		return false; //e.preventDefault() e.stopPropagation()
	});
});
