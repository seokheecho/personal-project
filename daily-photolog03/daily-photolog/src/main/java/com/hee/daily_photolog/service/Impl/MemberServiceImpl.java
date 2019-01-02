package com.hee.daily_photolog.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hee.daily_photolog.dao.MemberDAO;
import com.hee.daily_photolog.service.MemberService;
import com.hee.daily_photolog.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberDAO memberDAO;
    
    // 회원정보 등록
    @Override
    public Map<String, Object> insertMemInfo(MemberVO vo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int insertResult = 0;
        
        try {
            insertResult = memberDAO.insertMemInfo(vo);
            System.out.println(insertResult);
            resultMap.put("result", insertResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultMap;
    }

}
