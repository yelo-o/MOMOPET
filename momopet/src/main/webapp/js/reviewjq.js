$(() => {
  let selectedRating = 0; // 선택한 별점을 저장할 변수

  $(".star-rating img").mouseover(function () {
    if (selectedRating === 0) {
      const ratingValue = $(this).data("rating");
      $(".star-rating img").removeClass("full");
      $(".star-rating img").each(function () {
        if ($(this).data("rating") <= ratingValue) {
          $(this).addClass("full");
        }
      });
    }
  });

  $(".star-rating img").click(function () {
    selectedRating = $(this).data("rating"); // 클릭한 별에 해당하는 별점을 변수에 저장
    $(".star-rating img").removeClass("full");
    $(".star-rating img").each(function () {
      if ($(this).data("rating") <= selectedRating) {
        $(this).addClass("full");
      }
    });
    $("#writeForm input[name=reviewRating]").val(selectedRating);
  });

/*  $("#writeForm").submit((e) => {
    e.preventDefault();
    const userName = this.loginedId.value;
    const reviewText = this.reviewContent.value; // 수정된 부분: review -> reviewContent
    const starRating = selectedRating; // 변수에서 선택한 별점을 가져옴

    const reviewContainer = $("<div>").addClass("review-container");
    const reviewUser = $("<div>").addClass("review-user").text(userName);
    const reviewContent = $("<div>").addClass("review-content").text(reviewText);
    const reviewRating = $("<div>").addClass("review-rating").text(`별점: ${starRating}점`);
    const deleteButton = $("<button>").text("리뷰 삭제").on("click", function () {
      reviewContainer.remove();
    });

    reviewContainer.append(reviewUser, reviewContent, reviewRating, deleteButton);
    $("#reviewList").append(reviewContainer);

    this.reset();
    selectedRating = 0; // 폼 제출 후 선택한 별점을 0으로 초기화하여 준비
  });
});*/

  $("#writeForm").submit((e) => {
	   const backURL = '/momopet'
	   const frontURL = '/momopet'
	$(e.target)
        .attr('action',`${backURL}/review`)
        .attr('method','post')
        
         alert(formObj.serialize())
        $.ajax({
            url: $(e.target).attr('action'), //`${backURL}/signup`
            method: $(e.target).attr('method'), //post
            data: 
                formObj.serialize(), //자료형 자동화
                success: (responseData) =>{
				if(responseData.trim() == '0'){ //jsp status 값을 기준으로 0, 1 나뉨
                    alert('리뷰등록 실패')
                }else{
                   location.href=`${frontURL}/jsp/layout.jsp`
                }
            },
            error:(xhr)=>{
                alert("에러:" + xhr.status)
            }
        })
        return false //e.preventDefault() e.stopPropagation()
    })
  })