'use strict'

$('#loginBtn').click(() => {
    if($('#fEmail').val() == "") {
        alert("이메일을 입력해주세요!");
        return;
    } else if ($('#fPassword').val() == "") {
        alert("비밀번호를 입력해주세요!");
        return;
    } else {
            $.post(`${serverApiAddr}/json/auth/signIn`, {
                'email': $('#fEmail').val(),
                'password': $('#fPassword').val(),
                'saveEmail': $('#fSaveEmail').prop('checked')
            }, (result) => {
                if (result.status === 'success') {
                    location.href = 'photolog/index.html'
                } else {
                    console.log(result.status)
                    console.log(result.message)
                    alert('이메일 또는 비밀번호 확인 후 다시 로그인해 주세요!')
                }
            }, 'json')
            .fail(() => {
                alert('서버 요청 중 오류 발생!')
            });
    }
});

$('#signinBtn').click(function() {
    location.href = "signUp.html"
});
