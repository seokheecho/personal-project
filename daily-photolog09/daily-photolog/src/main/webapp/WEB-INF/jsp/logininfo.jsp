<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인인포</title>
</head>
<body>
    <!-- 세션에서 token을 가져와서 출력한다. -->
    ${sessionScope.token}
    <a href = "logout">로그아웃</a><br>
    <!-- 로그아웃 클릭 시 session? cookie? 삭제 필요 -->
    
<!-- 
      <h6>카카오톡 로그인 성공 화면</h6>
  <hr />
  <div id="k_image" style="text-align:center"><img></img</div>
  <div id="k_id" style="text-align:center"></div>
  <div id="k_email" style="text-align:center"></div>
  <div id="k_nickname" style="text-align:center"></div>

  <script>      
  if ('${k_userInfo}') {

    $("#k_id").text("아이디 : " + '${id}');
    $("#k_email").text("이메일 : " + '${email}');
    $("#k_nickname").text("이름 : " + '${nickname}');

    imageURL = ${image};

    $("#k_image").children("img").attr("src", imageURL);
  }
  </script>
    
-->
    
    
</body>
</html>


