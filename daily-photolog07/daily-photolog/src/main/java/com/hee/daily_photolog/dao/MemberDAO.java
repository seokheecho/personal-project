package com.hee.daily_photolog.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.hee.daily_photolog.vo.MemberVO;

@Repository("memberDAO")
public interface MemberDAO {
    // 회원정보 등록
    public abstract int insertMemInfo(MemberVO memberVO);
    // 회원로그인
    public abstract MemberVO findByEmailAndPassword(HashMap<String, Object> params);
    
    
}
