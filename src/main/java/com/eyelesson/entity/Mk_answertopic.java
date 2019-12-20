package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mk_answertopic")
public class Mk_answertopic {

    @Id
    private Integer mkantid;
    private Integer mkatpid;
    private String mkatpcontent;
    private Integer mkuid;
    private Integer mkaid;
    private Date mkantptime;

    @Override
    public String toString() {
        return "Mk_answertopic{" +
                "mkantid=" + mkantid +
                ", mkatpid=" + mkatpid +
                ", mkatpcontent='" + mkatpcontent + '\'' +
                ", mkuid=" + mkuid +
                ", mkaid=" + mkaid +
                ", mkantptime=" + mkantptime +
                ", mkuname='" + mkuname + '\'' +
                ", mkuimg='" + mkuimg + '\'' +
                ", uname='" + uname + '\'' +
                ", uimg='" + uimg + '\'' +
                ", children=" + children +
                '}';
    }

    @Transient
    private String mkuname;
    @Transient
    private String mkuimg;

    @Transient
    private String uname;
    @Transient
    private String uimg;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public String getMkuname() {
        return mkuname;
    }

    public void setMkuname(String mkuname) {
        this.mkuname = mkuname;
    }

    public String getMkuimg() {
        return mkuimg;
    }

    public void setMkuimg(String mkuimg) {
        this.mkuimg = mkuimg;
    }

    List<Mk_answertopic> children;

    public List<Mk_answertopic> getChildren() {
        return children;
    }

    public void setChildren(List<Mk_answertopic> children) {
        this.children = children;
    }

    public Integer getMkantid() {
        return mkantid;
    }

    public void setMkantid(Integer mkantid) {
        this.mkantid = mkantid;
    }

    public Integer getMkatpid() {
        return mkatpid;
    }

    public void setMkatpid(Integer mkatpid) {
        this.mkatpid = mkatpid;
    }

    public String getMkatpcontent() {
        return mkatpcontent;
    }

    public void setMkatpcontent(String mkatpcontent) {
        this.mkatpcontent = mkatpcontent;
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public Integer getMkaid() {
        return mkaid;
    }

    public void setMkaid(Integer mkaid) {
        this.mkaid = mkaid;
    }

    public Date getMkantptime() {
        return mkantptime;
    }

    public void setMkantptime(Date mkantptime) {
        this.mkantptime = mkantptime;
    }
}
