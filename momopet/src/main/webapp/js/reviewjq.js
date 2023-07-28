$(() => {
  $(".star-rating img").click(function () {
    const ratingValue = $(this).data("rating");
    $("#writeForm input[name=starRating]").val(ratingValue);
    $(".star-rating img").removeClass("selected");
    $(this).addClass("selected");
  });

  $("#writeForm").submit(function (event) {
    event.preventDefault();
    const userName = this.userName.value;
    const reviewText = this.review.value;
    const starRating = this.starRating.value; 

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
  });
});
