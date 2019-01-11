package com.hee.daily_photolog.service;

import java.util.Map;

import com.hee.daily_photolog.vo.PhotoLogVO;

public interface PhotoLogService {

    public abstract Map<String, Object> insertPhotoLog(PhotoLogVO photoLogVO);
    
}
