package com.hee.daily_photolog.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hee.daily_photolog.service.MemberService;
import com.hee.daily_photolog.vo.MemberVO;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
    
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