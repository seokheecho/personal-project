package com.hee.daily_photolog.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.hee.daily_photolog.web.json.KakaoAuthToken;

// http://localhost:8080/daily-photolog/app/hello
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public void hello(Model model, HttpSession session) {
        model.addAttribute("name", "홍길동");
    }

    @RequestMapping(value = "/oauth", produces = "application/json")
    public String kakaoLogin(@RequestParam("code") String code, Model model, HttpSession session) {
        System.out.println("로그인 할때 임시 코드값");
        //카카오 홈페이지에서 받은 결과 코드
        System.out.println(code);
        System.out.println("로그인 후 결과값");
        
        //카카오 rest api 객체 선언
        KakaoAuthToken kr = new KakaoAuthToken();
        //결과값을 node에 담아줌
        JsonNode node = kr.getAccessToken(code);
        //결과값 출력
        System.out.println(node);
        //노드 안에 있는 access_token값을 꺼내 문자열로 변환
        String token = node.get("access_token").toString();
        //세션에 담아준다.
        session.setAttribute("token", token);
        

        
//        JsonNode userInfo = kr.getKakaoUserInfo(code);
//        
//        System.out.println(userInfo);
//
//        String id = userInfo.get("id").toString();
//        String email = userInfo.get("kaccount_email").toString();
//        String image = userInfo.get("properties").get("profile_image").toString();
//        String nickname = userInfo.get("properties").get("nickname").toString();
//
//        System.out.println(id + email);
//
//
//        model.addAttribute("k_userInfo", userInfo);
//        model.addAttribute("id", id);
//        model.addAttribute("email", email);
//        model.addAttribute("nickname", nickname);
//        model.addAttribute("image", image);
        
        
        return "logininfo";
    }


    @RequestMapping(value = "/logout", produces = "application/json")
    public String Logout(HttpSession session) {
        //kakao restapi 객체 선언
        KakaoAuthToken kr = new KakaoAuthToken();
        //노드에 로그아웃한 결과값음 담아줌 매개변수는 세션에 잇는 token을 가져와 문자열로 변환
        JsonNode node = kr.Logout(session.getAttribute("token").toString());
        //결과 값 출력
        System.out.println("로그인 후 반환되는 아이디 : " + node.get("id"));
        return "redirect:/html/signIn.html";
    }    
}
    
    
    
    
    