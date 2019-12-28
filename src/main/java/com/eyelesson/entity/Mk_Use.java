package com.eyelesson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mk_use")
public class Mk_Use {

    @Id
    private Integer mkuid;
    private String mkunum;
    private String mkuname;
    private String mkuphone;
    private String mkupassword;
    private Date mkucreatetime;
    private Integer mkubalance;
    private String mkusex;
    private String mkuintroduce;
    private String mkurealname;
    private String mkuidcard;
    private Date mkubirthday;
    private String mkusign;
    private String mkuemail;
    private String mkuweibo;
    private String mkuqq;
    private String mkuimg;
    private Integer mkustate;
    private Integer mkfollowcount;
    private Integer mkuintegral;

    private Integer mkposid;

    @Override
    public String toString() {
        return "Mk_Use{" +
                "mkuid=" + mkuid +
                ", mkunum='" + mkunum + '\'' +
                ", mkuname='" + mkuname + '\'' +
                ", mkuphone='" + mkuphone + '\'' +
                ", mkupassword='" + mkupassword + '\'' +
                ", mkucreatetime=" + mkucreatetime +
                ", mkubalance=" + mkubalance +
                ", mkusex='" + mkusex + '\'' +
                ", mkuintroduce='" + mkuintroduce + '\'' +
                ", mkurealname='" + mkurealname + '\'' +
                ", mkuidcard='" + mkuidcard + '\'' +
                ", mkubirthday=" + mkubirthday +
                ", mkusign='" + mkusign + '\'' +
                ", mkuemail='" + mkuemail + '\'' +
                ", mkuweibo='" + mkuweibo + '\'' +
                ", mkuqq='" + mkuqq + '\'' +
                ", mkuimg='" + mkuimg + '\'' +
                ", mkustate=" + mkustate +
                ", mkfollowcount=" + mkfollowcount +
                ", mkuintegral=" + mkuintegral +
                ", mkposid=" + mkposid +
                '}';
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public String getMkunum() {
        return mkunum;
    }

    public void setMkunum(String mkunum) {
        this.mkunum = mkunum;
    }

    public String getMkuname() {
        return mkuname;
    }

    public void setMkuname(String mkuname) {
        this.mkuname = mkuname;
    }

    public String getMkuphone() {
        return mkuphone;
    }

    public void setMkuphone(String mkuphone) {
        this.mkuphone = mkuphone;
    }

    public String getMkupassword() {
        return mkupassword;
    }

    public void setMkupassword(String mkupassword) {
        this.mkupassword = mkupassword;
    }

    public Date getMkucreatetime() {
        return mkucreatetime;
    }

    public void setMkucreatetime(Date mkucreatetime) {
        this.mkucreatetime = mkucreatetime;
    }

    public Integer getMkubalance() {
        return mkubalance;
    }

    public void setMkubalance(Integer mkubalance) {
        this.mkubalance = mkubalance;
    }

    public String getMkusex() {
        return mkusex;
    }

    public void setMkusex(String mkusex) {
        this.mkusex = mkusex;
    }

    public String getMkuintroduce() {
        return mkuintroduce;
    }

    public void setMkuintroduce(String mkuintroduce) {
        this.mkuintroduce = mkuintroduce;
    }

    public String getMkurealname() {
        return mkurealname;
    }

    public void setMkurealname(String mkurealname) {
        this.mkurealname = mkurealname;
    }

    public String getMkuidcard() {
        return mkuidcard;
    }

    public void setMkuidcard(String mkuidcard) {
        this.mkuidcard = mkuidcard;
    }

    public Date getMkubirthday() {
        return mkubirthday;
    }

    public void setMkubirthday(Date mkubirthday) {
        this.mkubirthday = mkubirthday;
    }

    public String getMkusign() {
        return mkusign;
    }

    public void setMkusign(String mkusign) {
        this.mkusign = mkusign;
    }

    public String getMkuemail() {
        return mkuemail;
    }

    public void setMkuemail(String mkuemail) {
        this.mkuemail = mkuemail;
    }

    public String getMkuweibo() {
        return mkuweibo;
    }

    public void setMkuweibo(String mkuweibo) {
        this.mkuweibo = mkuweibo;
    }

    public String getMkuqq() {
        return mkuqq;
    }

    public void setMkuqq(String mkuqq) {
        this.mkuqq = mkuqq;
    }

    public String getMkuimg() {
        return mkuimg;
    }

    public void setMkuimg(String mkuimg) {
        this.mkuimg = mkuimg;
    }

    public Integer getMkustate() {
        return mkustate;
    }

    public void setMkustate(Integer mkustate) {
        this.mkustate = mkustate;
    }

    public Integer getMkfollowcount() {
        return mkfollowcount;
    }

    public void setMkfollowcount(Integer mkfollowcount) {
        this.mkfollowcount = mkfollowcount;
    }

    public Integer getMkuintegral() {
        return mkuintegral;
    }

    public void setMkuintegral(Integer mkuintegral) {
        this.mkuintegral = mkuintegral;
    }

    public Integer getMkposid() {
        return mkposid;
    }

    public void setMkposid(Integer mkposid) {
        this.mkposid = mkposid;
    }
}
