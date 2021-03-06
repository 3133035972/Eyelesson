package com.eyelesson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
public class Mk_UserInfo {

    private Integer mksid;
    private String mksnum;
    private String mksname;
    private String mksex;
    private Date mksbirthday;
    private String mksidcard;
    private Date mksctime;
    private String mksphone;
    private String mksaddress;
    private String mkschool;
    private String mkskill;
    private String mksimg;
    private Integer mkstate;
    private Date mksquit;
    private Integer mksposid;
    private Integer mkuserid;
    private String mkusername;
    private String mkupassword;

    @Override
    public String toString() {
        return "Mk_UserInfo{" +
                "mksid=" + mksid +
                ", mksnum='" + mksnum + '\'' +
                ", mksname='" + mksname + '\'' +
                ", mksex='" + mksex + '\'' +
                ", mksbirthday=" + mksbirthday +
                ", mksidcard='" + mksidcard + '\'' +
                ", mksctime=" + mksctime +
                ", mksphone='" + mksphone + '\'' +
                ", mksaddress='" + mksaddress + '\'' +
                ", mkschool='" + mkschool + '\'' +
                ", mkskill='" + mkskill + '\'' +
                ", mksimg='" + mksimg + '\'' +
                ", mkstate=" + mkstate +
                ", mksquit=" + mksquit +
                ", mksposid=" + mksposid +
                ", mkuserid=" + mkuserid +
                ", mkusername='" + mkusername + '\'' +
                ", mkupassword='" + mkupassword + '\'' +
                '}';
    }

    public Integer getMksid() {
        return mksid;
    }

    public void setMksid(Integer mksid) {
        this.mksid = mksid;
    }

    public String getMksnum() {
        return mksnum;
    }

    public void setMksnum(String mksnum) {
        this.mksnum = mksnum;
    }

    public String getMksname() {
        return mksname;
    }

    public void setMksname(String mksname) {
        this.mksname = mksname;
    }

    public String getMksex() {
        return mksex;
    }

    public void setMksex(String mksex) {
        this.mksex = mksex;
    }

    public Date getMksbirthday() {
        return mksbirthday;
    }

    public void setMksbirthday(Date mksbirthday) {
        this.mksbirthday = mksbirthday;
    }

    public String getMksidcard() {
        return mksidcard;
    }

    public void setMksidcard(String mksidcard) {
        this.mksidcard = mksidcard;
    }

    public Date getMksctime() {
        return mksctime;
    }

    public void setMksctime(Date mksctime) {
        this.mksctime = mksctime;
    }

    public String getMksphone() {
        return mksphone;
    }

    public void setMksphone(String mksphone) {
        this.mksphone = mksphone;
    }

    public String getMksaddress() {
        return mksaddress;
    }

    public void setMksaddress(String mksaddress) {
        this.mksaddress = mksaddress;
    }

    public String getMkschool() {
        return mkschool;
    }

    public void setMkschool(String mkschool) {
        this.mkschool = mkschool;
    }

    public String getMkskill() {
        return mkskill;
    }

    public void setMkskill(String mkskill) {
        this.mkskill = mkskill;
    }

    public String getMksimg() {
        return mksimg;
    }

    public void setMksimg(String mksimg) {
        this.mksimg = mksimg;
    }

    public Integer getMkstate() {
        return mkstate;
    }

    public void setMkstate(Integer mkstate) {
        this.mkstate = mkstate;
    }

    public Date getMksquit() {
        return mksquit;
    }

    public void setMksquit(Date mksquit) {
        this.mksquit = mksquit;
    }

    public Integer getMksposid() {
        return mksposid;
    }

    public void setMksposid(Integer mksposid) {
        this.mksposid = mksposid;
    }

    public Integer getMkuserid() {
        return mkuserid;
    }

    public void setMkuserid(Integer mkuserid) {
        this.mkuserid = mkuserid;
    }

    public String getMkusername() {
        return mkusername;
    }

    public void setMkusername(String mkusername) {
        this.mkusername = mkusername;
    }

    public String getMkupassword() {
        return mkupassword;
    }

    public void setMkupassword(String mkupassword) {
        this.mkupassword = mkupassword;
    }
}
