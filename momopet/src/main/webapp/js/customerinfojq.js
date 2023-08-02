$(() => {

    $(function() {
 
       $(".button").bind('click', function() {
          window.location.href = '../momopet/jsp/infoupdate.jsp';
          alert("수정페이지로 이동합니다.");
 
       });
    });
 });