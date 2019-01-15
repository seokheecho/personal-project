package com.hee.daily_photolog.service.Impl;

import java.util.HashMap;
import java.util.List;
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
    
    // PhotoLog 등록
    @Override
    public Map<String, Object> insertPhotoLog(PhotoLogVO photoLogVO) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        int insertResult = 0;
        
        System.out.println("PhotoLogServiceImpl-------------");
        System.out.println(photoLogVO);
        
        try {
            insertResult = photoLogDAO.insertPhotoLog(photoLogVO);
            System.out.println(insertResult);
            resultMap.put("result", insertResult);
        } catch (Exception e){
           e.printStackTrace();
        }
        
        return resultMap;
    }

    // PhotoLog 목록
    @Override
    public List<PhotoLogVO> listPhotoLog(int no) {
        
        return photoLogDAO.findByMemberNo(no);
    }

    
    
//    @Override
//    public Map<String, Object> listPhotoLog(int memberNo) {
//        List<PhotoLogVO> photoLogList = null;
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        
//        try {
//            photoLogList = photoLogDAO.findByMemberNo(memberNo);
//            resultMap.put("photologlist", photoLogList);
//            resultMap.put("result", "success");
//            
//        } catch (Exception e) {
//            resultMap.put("result", "fail");
//            e.printStackTrace();
//        }
//        
//        return resultMap;
//    }
    
    
    
    
    
    
    
    
}
