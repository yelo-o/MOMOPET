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
    $("#writeForm input[name=starRating]").val(selectedRating);
  });

  $("#writeForm").submit(function (e) {
    e.preventDefault();
    const userName = this.userName.value;
    const reviewText = this.review.value;
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
});
