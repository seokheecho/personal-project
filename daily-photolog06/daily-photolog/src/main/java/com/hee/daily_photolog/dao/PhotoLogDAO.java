package com.hee.daily_photolog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hee.daily_photolog.vo.PhotoLogVO;

@Repository("photoLogDAO")
public interface PhotoLogDAO {
    // PhotoLog 등록
    public abstract int insertPhotoLog(PhotoLogVO photoLogVO);
    
    // PhotoLog 목록
    public abstract List<PhotoLogVO> findByMemberNo(int no);
        
    
    
    
}
