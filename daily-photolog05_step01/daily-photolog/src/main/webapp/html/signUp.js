'use strict'

$('#addBtn').click(() => {

        var formData = new Object();
         formData.email = $('#fEmail').val();
         formData.name = $('#fName').val();
         formData.password = $('#fPassword').val();
         console.log(formData);
            $.ajax({
                type : "post"
                ,contentType : "application/json;charset=UTF-8"
                ,url : `${serverApiAddr}/json/member/signUp`
                ,data : JSON.stringify(formData)
                ,success : function(data){
                var result = data.result;
                console.log(data);
                console.log("result=",result);
                if(result != "0"){
                    alert('정상적으로 처리되었습니다.');
                    window.opener.location.reload();
                    window.close();
                    }else{
                        alert('정상적으로 처리되지 않았습니다');
                    }
                }
                
            });
            
});


//**참고 : 회원정보 등록(bitcamp-assignment-04)
//$('#addBtn').click(() => {
// $.post(`${serverApiAddr}/json/member/signUp`, {
//     'email': $('#fEmail').val(),
//     'name': $('#fName').val(),
//     'password': $('#fPassword').val()
// }, (result) => {
//     console.log(result);
// }, 'json')
// .fail(() => {
//     alert('회원 가입 중에 오류 발생!')
// });
//});


