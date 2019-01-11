package com.hee.daily_photolog.service;

import java.util.Map;

import com.hee.daily_photolog.vo.MemberVO;

public interface MemberService {
    
    public abstract Map<String, Object> insertMemInfo(MemberVO memberVO);

    public abstract MemberVO getMemberVO(String email, String password);
    
    
}
