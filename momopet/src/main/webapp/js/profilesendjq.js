$(document).ready(function() {
  $("#dataForm").submit(function(event) {
    event.preventDefault();

    const recipientUserId = $("input[name='senduser']").val();
    const message = $("#message").val();

    // 데이터를 다른 ID를 가진 사람에게 보내는 AJAX 요청을 보냅니다.
    $.ajax({
      url: "send_message.php", // 서버 측 데이터 전송 처리를 위한 URL
      method: "POST",
      data: {
        recipientUserId: recipientUserId,
        message: message
      },
      success: function(response) {
        alert("메시지가 성공적으로 전송되었습니다!");
      },
      error: function() {
        alert("메시지 전송 중 오류가 발생했습니다.");
      }
    });
  });
});