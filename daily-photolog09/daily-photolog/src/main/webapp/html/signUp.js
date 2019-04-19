'use strict'


$('#addBtn').click(() => {
    var cnt = 1;
        if (cnt != 0) {
            alert("이메일 중복 확인!!!");
            return;
        } else if($('#fEmail').val() == "") {
            alert("이메일 입력!");
            return;
        } else if($('#fName').val() == "") {
            alert("이름 입력!");
            return;
        } else if($('#fPassword').val() == "") {
            alert("패스워드 입력!");
            return;
        } else if(('#fPassword').val() != ('#fPassCheck').val()) {
            alert("패스워드 입력 확인!");
            return;
        } else {
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
                                    location.href = "signIn.html"
//                    window.opener.location.reload();
//                    window.close();
                                }else{
                                    alert('정상적으로 처리되지 않았습니다');
                                }
                            }
            
            });
            
        }
});

$("#restBtn").click(function() {
    location.reload();
})


$("#fEmail").keyup(function() {
    var cnt = 0;
    var email = $("#fEmail").val();
//    if(id.length < 5 || id.length > 16) {
//        $("#idresult").css("color", "black");
//        $("#idresult").text("이메일은 5자이상 16자이하입니다.");
//    } else {
        $.ajax({
            type : "GET",
            url : `${serverApiAddr}/json/member/emailcheck`,
            dataType : "json",
            data : {"email" : email},
            success : function(data) {
                var obj = JSON.parse(data);
                console.log(obj);
                cnt = parseInt(obj.emailcount);
                console.log(cnt);
                if(cnt == 0) { 
                    if ($('#fEmail').val() == "") {
                        $("#emailresult").css("color", "black");
                        $("#emailresult").text("이메일을 입력해 주세요.");
                    } else {
                        $("#emailresult").css("color", "blue");
                        $("#emailresult").text(email + "는 사용가능합니다.");
                    }
                } else {
                    $("#emailresult").css("color", "red");
                    $("#emailresult").text(email + "는 사용중입니다.");
                }
            },
            error : function(e) {
                
            }
        });
//    }
});

$("#fPassCheck").keyup(function() {
    if($('#fPassword').val() == $('#fPassCheck').val()) { 
        $("#pwcheckresult").css("color", "blue");
        $("#pwcheckresult").text("입력한 패스워드와 일치합니다.");
    } else if($('#fPassCheck').val() == "") {
        $("#pwcheckresult").css("color", "black");
        $("#pwcheckresult").text("패스워드 확인 입력을 해주세요.");
    } else {
        $("#pwcheckresult").css("color", "red");
        $("#pwcheckresult").text("입력한 패스워드와 일치하지 않습니다.");
    }
});




//**참고 : 회원정보 등록(bitcamp-assignment-04)
//$('#addBtn').click(() => {
//$.post(`${serverApiAddr}/json/member/signUp`, {
//   'email': $('#fEmail').val(),
//   'name': $('#fName').val(),
//   'password': $('#fPassword').val()
//}, (result) => {
//   console.log(result);
//}, 'json')
//.fail(() => {
//   alert('회원 가입 중에 오류 발생!')
//});
//});

//**참고  : id 글자수 제한 안내
//if(id.length < 5 || id.length > 16) {
//$("#idresult").css("color", "black");
//$("#idresult").text("이메일은 5자이상 16자이하입니다.");
//} else {
//
//}

