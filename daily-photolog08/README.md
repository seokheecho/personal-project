# daily-photolog08

**SignIn.html - SignIn.js
 - 로그인 화면 "회원가입" 버튼 생성 및 회원가입 페이지 이동
~~~javascript
$('#signinBtn').click(function() {
    location.href = "signUp.html"
});
~~~


**SignUp.html - SignUp.js
 - 이메일 중복체크 기능(/member/emailcheck) : 이미 등록된 이메일을 체크(get 요청 - DB 확인)
~~~html
<span id="emailresult"></span>
~~~ 

 - 패스워드 입력 확인 : "입력한 패스워드와 일치합니다." (keyup - blur)
~~~javascript
$("#fPassCheck").keyup(function() { ... 
}
~~~

~~~javascript
$("#fPassCheck").blur(function() { ... 
}
~~~

 - 회원가입 화면 "초기화" 버튼 생성 : 1) html - "type=reset", 2)"type=button" + "jQuery reload()"
~~~html
     <button id="restBtn" type="reset" class="btn btn-warning">초기화</button>
~~~
~~~html
     <button id="restBtn" type="button" class="btn btn-warning">초기화</button>
~~~
~~~javascript
$("#restBtn").click(function() {
    location.reload();
})
~~~

### 참고
**[jQuery]
 - jQuery : 제이쿼리를 이용하여 비밀번호 값 비교하기 (키보드 눌렀을때 비교)
https://hongku.tistory.com/249

 - keyup 이벤트는 사용자가 키보드의 키를 놓았을 때 발생, 즉 키 하나 입력 시 마다 이벤트가 발생되고
blur 이벤트는 input에 값을 다 입력하고 커서가 사라질 경우 발생한다.
비밀번호와 비밀번호 확인을 할 경우에는 keyup으로 비교하고 비멀번호를 다 쓴 후 정규식으로 체크할 경우 blur을 사용