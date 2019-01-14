package com.hee.daily_photolog.service;

import java.util.Map;

import com.hee.daily_photolog.vo.PhotoFileVO;

public interface PhotoFileService {
    // PhotoFile 등록
    public abstract Map<String, Object> insertPhotoFile(PhotoFileVO photoFileVO);
    
}
