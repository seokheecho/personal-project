package com.hee.daily_photolog.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hee.daily_photolog.service.MemberService;
import com.hee.daily_photolog.vo.MemberVO;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired MemberService memberService;
    
    @PostMapping("signIn")
    public Object signIn(
            String email, 
            String password, 
            boolean saveEmail, 
            HttpSession session) {
        
        HashMap<String, Object> result = new HashMap<>();
        try {
            MemberVO loginUser = memberService.getMemberVO(email, password);
            
            if (loginUser == null)
                throw new Exception("로그인 실패!");
            
            session.setAttribute("loginUser", loginUser);
            result.put("status", "success");
            
        } catch (Exception e){
            result.put("status", "fail");
            result.put("message", e.getMessage());
            
        }
        
        return result;
        
    }
    
}



/*
    @RequestMapping(value = "/kakaologin", method = RequestMethod.GET)
    public String kakoLogin(String accessToken, String type, HttpSession session) {
        try {
            MemberVO loginUser = authService.getKakaoMember(accessToken, type);
            
            // 회원 정보를 세션에 보관한다.
            session.setAttribute("loginUser", loginUser);
            String redirectUrl = null;
            
            switch (type) {
                case "member" :
                    redirectUrl = "../photolog/list";
                break;
            }
            return "redirect:" + redirectUrl;
        } catch (Exception e) {
            e.printStackTrace();
            session.invalidate();
            return "redirect:auth/signIn";
        }
    }
    
    
    

    @RequestMapping(value = "/kakaologin", produces = "application/json", method = RequestMethod.GET)
    public String kakaoLogin(@RequestParam("code") String code, RedirectAttributes ra, 
                            HttpSession session, HttpServletResponse response) throws IOException {
            
            System.out.println("kakao code : " + code);
            
            
         // JsonNode트리형태로 토큰받아온다
            JsonNode jsonToken = KakaoAccessToken.getKakaoAccessToken(code);
            // 여러 json객체 중 access_token을 가져온다
            accessToken = jsonToken.get("access_token");
     
            System.out.println("access_token : " + accessToken);
            
            
                                return code;
        
    }
    
    
    // access_token을 통해 사용자 정보 요청
    JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(accessToken);

    // Get id
    String id = userInfo.path("id").asText();
    String name = null;
    String email = null;

    // 유저정보 카카오에서 가져오기 Get properties
    JsonNode properties = userInfo.path("properties");
    JsonNode kakao_account = userInfo.path("kakao_account");

    name = properties.path("nickname").asText();
    email = kakao_account.path("email").asText();

    System.out.println("id : " + id);
    System.out.println("name : " + name);
    System.out.println("email : " + email);

*/
    
    
    

