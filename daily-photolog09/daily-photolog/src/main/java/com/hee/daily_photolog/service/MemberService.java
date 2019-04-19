package com.hee.daily_photolog.service;

import java.util.Map;

import com.hee.daily_photolog.vo.MemberVO;

public interface MemberService {
    // 회원 email 중복체크
    public abstract int emailCheck(String email);
    // 회원정보 등록
    public abstract Map<String, Object> insertMemInfo(MemberVO memberVO);
    // 회원 로그인
    public abstract MemberVO getMemberVO(String email, String password);
    
    
}
