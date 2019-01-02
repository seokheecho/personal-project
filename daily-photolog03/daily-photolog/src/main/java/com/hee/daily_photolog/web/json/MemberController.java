package com.hee.daily_photolog.web.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    public @ResponseBody Object signUp(@RequestBody MemberVO vo) {
        
        HashMap<String,Object> result = new HashMap<>();
        try {
            memberService.insertMemInfo(vo);
            System.out.println(vo);
            result.put("status", "success");
        } catch (Exception e) {
            result.put("status", "fail");
            result.put("message", e.getMessage());
        }
        
        return result;
    }
    
    // 회원정보 등록
//  @RequestMapping(value="/signUp", method = RequestMethod.POST)
//  public @ResponseBody Map<String, Object> signUp(@RequestBody MemberVO vo) {
//      Map<String, Object> result = memberService.insertMemInfo(vo);
//      return result;
//  }
    
    // 회원정보 등록
//  @PostMapping("signUp")
//  public @ResponseBody Object signUp(@RequestBody MemberVO vo) {
//      
//      HashMap<String,Object> result = new HashMap<>();
//      try {
//          memberService.insertMemInfo(vo);
//          result.put("status", "success");
//      } catch (Exception e) {
//          result.put("status", "fail");
//          result.put("message", e.getMessage());
//      }
//      
//      return result;
//  }

    
//  //**참고 : 회원정보 등록(bitcamp-assignment-04)
//  @PostMapping("signUp")
//  public Object signUp(MemberVO vo) {
//      
//      HashMap<String,Object> result = new HashMap<>();
//      try {
//          memberService.insertMemInfo(vo);
//          result.put("status", "success");
//      } catch (Exception e) {
//          result.put("status", "fail");
//          result.put("message", e.getMessage());
//      }
//      
//      return result;
//  }

}