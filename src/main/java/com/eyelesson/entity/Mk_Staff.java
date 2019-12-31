package com.eyelesson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mk_staff")
public class Mk_Staff {

    @Id
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
    private Integer mksfollowcount;

    public Integer getMksfollowcount() {
        return mksfollowcount;
    }

    public void setMksfollowcount(Integer mksfollowcount) {
        this.mksfollowcount = mksfollowcount;
    }

    //角色的名称
    @Transient
    private String mksrname;
    @Transient
    private Integer notmoney;
    @Transient
    private Integer yesmoney;

    //实战的课程
    @Transient
    private List<mk_course> Shizhan;
    //免费的课程
    @Transient
    private List<mk_course> Mianfei;

    @Override
    public String toString() {
        return "Mk_Staff{" +
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
                ", mksfollowcount=" + mksfollowcount +
                ", mksrname='" + mksrname + '\'' +
                ", notmoney=" + notmoney +
                ", yesmoney=" + yesmoney +
                ", Shizhan=" + Shizhan +
                ", Mianfei=" + Mianfei +
                '}';
    }

    public List<mk_course> getShizhan() {
        return Shizhan;
    }

    public void setShizhan(List<mk_course> shizhan) {
        Shizhan = shizhan;
    }

    public List<mk_course> getMianfei() {
        return Mianfei;
    }

    public void setMianfei(List<mk_course> mianfei) {
        Mianfei = mianfei;
    }

    public Integer getNotmoney() {
        return notmoney;
    }

    public void setNotmoney(Integer notmoney) {
        this.notmoney = notmoney;
    }

    public Integer getYesmoney() {
        return yesmoney;
    }

    public void setYesmoney(Integer yesmoney) {
        this.yesmoney = yesmoney;
    }

    public String getMksrname() {
        return mksrname;
    }

    public void setMksrname(String mksrname) {
        this.mksrname = mksrname;
    }



    public String getMksimg() {
        return mksimg;
    }

    public void setMksimg(String mksimg) {
        this.mksimg = mksimg;
    }

    public String getMkskill() {
        return mkskill;
    }

    public void setMkskill(String mkskill) {
        this.mkskill = mkskill;
    }

    public String getMkschool() {
        return mkschool;
    }

    public void setMkschool(String mkschool) {
        this.mkschool = mkschool;
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
}
