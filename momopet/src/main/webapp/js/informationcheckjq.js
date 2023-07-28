const backURL = '/momopet'
const formObj = $('form.my')

$(() => {

	$(function() {

		$(".button").bind('click', function() {
			window.location.href = '/momopet/jsp/member_update.jsp';
			alert("작동되네?");

		});
	});
});

