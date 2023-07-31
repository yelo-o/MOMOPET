const backURL = '/momopet'
const formObj = $('form.modify')

$(() => {

	$(function() {

		$(".buttonupdate").bind('click', function() {
			window.location.href = '/momopet/jsp/member_update.jsp';
			alert("진짜작동되네?");

		});
	});
	
	
	$(function() {

		$(".buttonback").bind('click', function() {
			window.location.href = '/momopet/jsp/informationcheck.jsp';
			alert("이게작동되네?");

		});
	});
});



/*$(() => {
	$(document).ready(function() {
		$("button").on("click", function(event) {
			event.preventDefault();

			var formData = $(".my").serialize();

			$.ajax({
				type: "POST",
				url: "personal_information", // Replace this with the actual endpoint URL
				data: formData,
				success: function(response) {
					console.log("Successfully updated user information.");
				},
				error: function(error) {
					console.error("Error updating user information:", error);
				}
			});
		});
	});
})*/