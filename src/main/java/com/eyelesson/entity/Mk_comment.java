package com.eyelesson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mk_comment")
public class Mk_comment {

    private Integer mkcmid;
    private String mkcmcontent;
    private String mkcmcreatetime;
    private Integer mkcstid;
    private Integer mkuid;



    @Override
    public String toString() {
        return "Mk_comment{" +
                "mkcmid=" + mkcmid +
                ", mkcmcontent='" + mkcmcontent + '\'' +
                ", mkcmcreatetime=" + mkcmcreatetime +
                ", mkcstid=" + mkcstid +
                ", mkuid=" + mkuid +
                '}';
    }

    public Integer getMkcmid() {
        return mkcmid;
    }

    public void setMkcmid(Integer mkcmid) {
        this.mkcmid = mkcmid;
    }

    public String getMkcmcontent() {
        return mkcmcontent;
    }

    public void setMkcmcontent(String mkcmcontent) {
        this.mkcmcontent = mkcmcontent;
    }

    public String getMkcmcreatetime() {
        return mkcmcreatetime;
    }

    public void setMkcmcreatetime(String mkcmcreatetime) {
        this.mkcmcreatetime = mkcmcreatetime;
    }

    public Integer getMkcstid() {
        return mkcstid;
    }

    public void setMkcstid(Integer mkcstid) {
        this.mkcstid = mkcstid;
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }
}
