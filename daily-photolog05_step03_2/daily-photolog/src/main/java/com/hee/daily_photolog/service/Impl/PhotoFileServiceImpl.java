package com.hee.daily_photolog.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hee.daily_photolog.dao.PhotoFileDAO;
import com.hee.daily_photolog.service.PhotoFileService;
import com.hee.daily_photolog.vo.PhotoFileVO;

@Service
public class PhotoFileServiceImpl implements PhotoFileService {

    @Autowired
    private PhotoFileDAO photoFileDAO;

    // 포토파일 등록
    @Override
    public Map<String, Object> insertPhotoFile(PhotoFileVO photoFileVO) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int insertResult = 0;
        
        System.out.println("PhotoFileServiceImpl-------------");
        System.out.println(photoFileVO);
        
        
        try {
            insertResult = photoFileDAO.insertPhotoFile(photoFileVO);
            System.out.println(insertResult);
            resultMap.put("result", insertResult);
        } catch (Exception e){
           e.printStackTrace();
        }
        
        return resultMap;
    }
    
}
