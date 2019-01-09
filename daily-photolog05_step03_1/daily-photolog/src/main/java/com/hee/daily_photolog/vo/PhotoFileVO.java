package com.hee.daily_photolog.vo;

import java.io.Serializable;

public class PhotoFileVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected int no;
    protected int photoLogNo;
    protected String photo;
    
    
    @Override
    public String toString() {
        return "PhotoFileVO [no=" + no + ", photoLogNo=" + photoLogNo + ", photo=" + photo + "]";
    }
    
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public int getPhotoLogNo() {
        return photoLogNo;
    }
    public void setPhotoLogNo(int photoLogNo) {
        this.photoLogNo = photoLogNo;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    

}
