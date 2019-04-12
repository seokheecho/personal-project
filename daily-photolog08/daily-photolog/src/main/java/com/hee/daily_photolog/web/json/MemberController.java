package com.hee.daily_photolog.web.json;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hee.daily_photolog.service.MemberService;
import com.hee.daily_photolog.vo.MemberVO;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
    
    // 회원 email 중복체크
    @RequestMapping(value="/emailcheck", method = RequestMethod.GET)
    public @ResponseBody String emailCheck(@RequestParam("email") String email) {
        int cnt = memberService.emailCheck(email);
        System.out.println("===========");
        System.out.println(cnt);
        JSONObject json = new JSONObject();//{}
        json.put("emailcount", cnt);//{"emailcount" : 1}
        System.out.println(json.toString());
        return json.toString();
    }
    
    
    // 회원정보 등록
    @RequestMapping(value="/signUp", method = RequestMethod.POST)
    public @ResponseBody Object signUp(@RequestBody MemberVO memberVO) {
        
        HashMap<String,Object> result = new HashMap<>();
        try {
            memberService.insertMemInfo(memberVO);
            System.out.println(memberVO);
            result.put("status", "success");
        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    

}