package com.hee.daily_photolog.dao;

import org.springframework.stereotype.Repository;

import com.hee.daily_photolog.vo.PhotoFileVO;

@Repository("photoFileDAO")
public interface PhotoFileDAO {
    // PhotoFile 등록
    public abstract int insertPhotoFile(PhotoFileVO photoFileVO);
    
}
