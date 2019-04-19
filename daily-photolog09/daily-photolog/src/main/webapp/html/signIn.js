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



$('#kakaologinBtn').click(() => {
    window.open('https://kauth.kakao.com/oauth/authorize?client_id=나의 앱 키 입력&redirect_uri=http://localhost:8080/daily-photolog/app/oauth&response_type=code', '카카오로그인새창',
            'top=150,left=100,width=550,height=650')
            
            
});

/*
$('#kakaologinBtn').click(() => {
    window.open('${serverApiAddr}/json/auth/signIn', '카카오로그인새창',
            'top=150,left=100,width=550,height=650')
            
            
});
*/



/*
//<![CDATA[
// // 사용할 앱의 JavaScript 키를 설정해 주세요.
Kakao.init('88e2d367c5272b7961c97d30a3aab7ad');
// // 카카오톡 링크 버튼을 생성합니다. 처음 한번만 호출하면 됩니다.
Kakao.Link.createTalkLinkButton({
  container: '#kakao-link-btn',
  label: '테스트 웹 개발',
  image: {
    src: 'http://dn.api1.kage.kakao.co.kr/14/dn/btqaWmFftyx/tBbQPH764Maw2R6IBhXd6K/o.jpg',
    width: '300',
    height: '200'
  },
  webButton: {
    text: '테스트 링크 GoGo',
    url: 'http://www.testapp.com' // 앱 설정의 웹 플랫폼에 등록한 도메인의 URL이어야 합니다.
  }
});
//]]>

*/









