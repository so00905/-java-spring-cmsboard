package com.example.cmsboard.vo;

import javax.xml.crypto.Data;
import java.util.Date;

public class BoardVO {
    private String telNameDetail;

    public String getTelNameDetail() {
        return telNameDetail;
    }

    public void setTelNameDetail(String telNameDetail) {
        this.telNameDetail = telNameDetail;
    }

    private int telCode;
    private int mNo;
    private int bNo;
    private String bTitle;
    private String bContent;
    private Date bDate;
    private int bHit;

    //통신사이름 셀렉트박스
    private String TelName;

    public String getTelName() {
        return TelName;
    }

    public void setTelName(String telName) {
        TelName = telName;
    }



    public int getTelCode() {
        return telCode;
    }

    public void setTelCode(int telCode) {
        this.telCode = telCode;
    }

    public int getmNo() {
        return mNo;
    }

    public void setmNo(int mNo) {
        this.mNo = mNo;
    }

    public int getbNo() {
        return bNo;
    }

    public void setbNo(int bNo) {
        this.bNo = bNo;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public int getbHit() {
        return bHit;
    }

    public void setbHit(int bHit) {
        this.bHit = bHit;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "telCode=" + telCode +
                ", mNo=" + mNo +
                ", bNo=" + bNo +
                ", bTitle='" + bTitle + '\'' +
                ", bContent='" + bContent + '\'' +
                ", bDate=" + bDate +
                ", bHit=" + bHit +
                '}';
    }
}
