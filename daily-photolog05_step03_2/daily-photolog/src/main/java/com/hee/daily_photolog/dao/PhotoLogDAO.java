package com.hee.daily_photolog.dao;

import org.springframework.stereotype.Repository;

import com.hee.daily_photolog.vo.PhotoLogVO;

@Repository("photoLogDAO")
public interface PhotoLogDAO {
    // PhotoLog 등록
    public abstract int insertPhotoLog(PhotoLogVO vo);
}
