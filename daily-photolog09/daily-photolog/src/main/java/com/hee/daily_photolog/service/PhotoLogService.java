package com.hee.daily_photolog.service;

import java.util.List;
import java.util.Map;

import com.hee.daily_photolog.vo.PhotoLogVO;

public interface PhotoLogService {
    // PhotoLog 등록
    public abstract Map<String, Object> insertPhotoLog(PhotoLogVO photoLogVO);
    // PhotoLog 목록
    List<PhotoLogVO> listPhotoLog(int no);
 // public abstract Map<String, Object> listPhotoLog(int memberNo);

}
