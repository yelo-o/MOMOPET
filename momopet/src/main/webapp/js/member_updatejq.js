$(() => {
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
})