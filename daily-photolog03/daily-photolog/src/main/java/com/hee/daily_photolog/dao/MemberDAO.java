package com.hee.daily_photolog.dao;

import org.springframework.stereotype.Repository;

import com.hee.daily_photolog.vo.MemberVO;

@Repository("memberDAO")
public interface MemberDAO {

    // 회원정보 등록
    public abstract int insertMemInfo(MemberVO vo);
    
    
}
