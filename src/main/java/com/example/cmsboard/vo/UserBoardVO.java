package com.example.cmsboard.vo;

import java.util.Date;

public class UserBoardVO {
    private int telCode;
    private int cNo;
    private String cId;
    private String cName;
    private String cPhone;
    private Date cDate;

    public int getTelCode() {
        return telCode;
    }

    public void setTelCode(int telCode) {
        this.telCode = telCode;
    }

    public int getcNo() {
        return cNo;
    }

    public void setcNo(int cNo) {
        this.cNo = cNo;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }
}
