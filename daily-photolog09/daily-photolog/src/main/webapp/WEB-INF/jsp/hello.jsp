<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST - hello!</title>
</head>
<body>
<h1>${name} 님 환영합니다!</h1>
<h1>Hello!</h1>

    <a href = "https://kauth.kakao.com/oauth/authorize?client_id=나의 앱 키 입력&redirect_uri=http://localhost:8080/daily-photolog/app/oauth&response_type=code">
        로그인
    </a>
    
    

</body>
</html>