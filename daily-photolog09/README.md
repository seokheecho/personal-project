# daily-photolog09

**카카오 계정 로그인 연동 TEST
1) JSP 연동 TEST
 - HelloController - KakaoAuthToken
 - pom.xml
 ~~~html
    <!-- httpcore(카카오) -->
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpcore</artifactId>
        <version>4.4.6</version>
    </dependency>

    <!-- httpclient(카카오) -->
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpclient</artifactId>
        <version>4.5.2</version>
    </dependency>
~~~
 - hello.jsp - logininfo.jsp

2) SignIn.html - SignIn.js
 - 로그인 화면 "카카오 계정 로그인" 버튼 생성 및 연동 TEST
 
 
**Bootstrap 템플릿 활용
 1) 템플릿 넣기 : html/resources/** 
 2) 기존 index.html 변경 - starter.html -> photolog/index.html
 
 
### 참고
**[카카오 계정 로그인 연동]
 - https://alpreah.tistory.com/121?category=844976
 - https://winterandsnow.tistory.com/16
 
 **[Bootstrap 템플릿 활용]
  - https://doublesprogramming.tistory.com/178?category=667155