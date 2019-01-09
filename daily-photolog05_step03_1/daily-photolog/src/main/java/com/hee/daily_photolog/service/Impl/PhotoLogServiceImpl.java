package com.hee.daily_photolog.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hee.daily_photolog.dao.PhotoLogDAO;
import com.hee.daily_photolog.service.PhotoLogService;
import com.hee.daily_photolog.vo.PhotoLogVO;

@Service
public class PhotoLogServiceImpl implements PhotoLogService {

    @Autowired
    private PhotoLogDAO photoLogDAO;
    
    // 포토로그 등록
    @Override
    public Map<String, Object> insertPhotoLog(PhotoLogVO vo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int insertResult = 0;
        
        System.out.println("PhotoLogServiceImpl-------------");
        System.out.println(vo);
        
        try {
            insertResult = photoLogDAO.insertPhotoLog(vo);
            System.out.println(insertResult);
            resultMap.put("result", insertResult);
        } catch (Exception e){
           e.printStackTrace();
        }
        
        return resultMap;
    }
}
