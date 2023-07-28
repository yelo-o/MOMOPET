const backURL = '/momopet'
const formObj = $('form.my')

$(() => {

	$(function() {

		$(".button").bind('click', function() {
			window.location.href = '/momopet/jsp/personal_information.jsp';
			alert("작동되네?");

		});
	});
});

