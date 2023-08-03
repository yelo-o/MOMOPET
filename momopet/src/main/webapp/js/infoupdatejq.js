$(() => {

    $(function() {
 
       $(".buttonupdate").bind('click', function() {
          window.location.href = '../customerinfocheck';
          alert("수정완료");
 
       });
    });
    
    
     $(function() {
 
       $(".buttonback").bind('click', function() {
          window.location.href = '../customerinfocheck';
          alert("내 정보확인으로 이동합니다.");
 
       });
    });
    
    
    
 });