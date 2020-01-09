package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mk_soncourse_section")
public class Mk_soncourse_section {

    @Id
    private Integer mkcstid;
    private Integer mkcsid;
    private Integer mkfcsid;
    private String mkcsname;
    private String mkcsurl;
    private String mkcstime;
    private Integer mkonsale;
    private String mkssimg;

    @Transient
    private Integer mkcid;

    @Transient
    private Integer mksid;
    @Transient
    private String mksimg;
    @Transient
    private String mkskill;
    @Transient
    private Integer mkuid;
    @Transient
    private String mkuimg;
    @Transient
    private String mkuintroduce;


    @Override
    public String toString() {
        return "Mk_soncourse_section{" +
                "mkcstid=" + mkcstid +
                ", mkcsid=" + mkcsid +
                ", mkfcsid=" + mkfcsid +
                ", mkcsname='" + mkcsname + '\'' +
                ", mkcsurl='" + mkcsurl + '\'' +
                ", mkcstime='" + mkcstime + '\'' +
                ", mkonsale=" + mkonsale +
                ", mkssimg='" + mkssimg + '\'' +
                ", mkcid=" + mkcid +
                ", mksid=" + mksid +
                ", mksimg='" + mksimg + '\'' +
                ", mkskill='" + mkskill + '\'' +
                ", mkuid=" + mkuid +
                ", mkuimg='" + mkuimg + '\'' +
                ", mkuintroduce='" + mkuintroduce + '\'' +
                '}';
    }

    public Integer getMkcstid() {
        return mkcstid;
    }

    public void setMkcstid(Integer mkcstid) {
        this.mkcstid = mkcstid;
    }

    public Integer getMkcsid() {
        return mkcsid;
    }

    public void setMkcsid(Integer mkcsid) {
        this.mkcsid = mkcsid;
    }

    public Integer getMkfcsid() {
        return mkfcsid;
    }

    public void setMkfcsid(Integer mkfcsid) {
        this.mkfcsid = mkfcsid;
    }

    public String getMkcsname() {
        return mkcsname;
    }

    public void setMkcsname(String mkcsname) {
        this.mkcsname = mkcsname;
    }

    public String getMkcsurl() {
        return mkcsurl;
    }

    public void setMkcsurl(String mkcsurl) {
        this.mkcsurl = mkcsurl;
    }

    public String getMkcstime() {
        return mkcstime;
    }

    public void setMkcstime(String mkcstime) {
        this.mkcstime = mkcstime;
    }

    public Integer getMkonsale() {
        return mkonsale;
    }

    public void setMkonsale(Integer mkonsale) {
        this.mkonsale = mkonsale;
    }

    public String getMkssimg() {
        return mkssimg;
    }

    public void setMkssimg(String mkssimg) {
        this.mkssimg = mkssimg;
    }

    public Integer getMkcid() {
        return mkcid;
    }

    public void setMkcid(Integer mkcid) {
        this.mkcid = mkcid;
    }

    public Integer getMksid() {
        return mksid;
    }

    public void setMksid(Integer mksid) {
        this.mksid = mksid;
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

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public String getMkuimg() {
        return mkuimg;
    }

    public void setMkuimg(String mkuimg) {
        this.mkuimg = mkuimg;
    }

    public String getMkuintroduce() {
        return mkuintroduce;
    }

    public void setMkuintroduce(String mkuintroduce) {
        this.mkuintroduce = mkuintroduce;
    }
}
