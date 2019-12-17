package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mk_soncourse_section")
public class Mk_soncourse_section {

    @Id
    private Integer mkcstid;
    private Integer mkcsid;
    private Integer mkfcsid;
    private String mkcsname;
    private String mkcsurl;
    private Integer mkcstime;
    private Integer mkonsale;
    private String mkssimg;
    private Integer mkcid;

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

    @Override
    public String toString() {
        return "Mk_soncourse_section{" +
                "mkcstid=" + mkcstid +
                ", mkcsid=" + mkcsid +
                ", mkfcsid=" + mkfcsid +
                ", mkcsname='" + mkcsname + '\'' +
                ", mkcsurl='" + mkcsurl + '\'' +
                ", mkcstime=" + mkcstime +
                ", mkonsale=" + mkonsale +
                ", mkcid=" + mkcid +
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

    public Integer getMkcstime() {
        return mkcstime;
    }

    public void setMkcstime(Integer mkcstime) {
        this.mkcstime = mkcstime;
    }

    public Integer getMkonsale() {
        return mkonsale;
    }

    public void setMkonsale(Integer mkonsale) {
        this.mkonsale = mkonsale;
    }
}
