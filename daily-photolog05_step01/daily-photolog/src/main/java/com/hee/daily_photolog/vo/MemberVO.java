package com.hee.daily_photolog.vo;

import java.io.Serializable;

public class MemberVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected int no;
    protected String email;
    protected String name;
    protected String password;
    
    
    @Override
    public String toString() {
        return "MemberVO [no=" + no + ", email=" + email + ", name=" + name + ", password=" + password + "]";
    }


    public int getNo() {
        return no;
    }


    public void setNo(int no) {
        this.no = no;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
