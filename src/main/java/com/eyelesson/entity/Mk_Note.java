package com.eyelesson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mk_note")
public class Mk_Note {

    private Integer mknid;
    private String mknotecontent;
    private Integer mkcstid;
    private Integer mkuid;
    private String mknlink;
    private Date mknctime;

    //用户的图片
    @Transient
    private String mkuimg;
    @Transient
    private String mkuname;
    @Transient
    private Integer mkcsid;
    @Transient
    private Integer count;

    //1个笔记下面有多个图片
    @Transient
    private List<Mk_NoteImg> childrens;

    public Integer getMkcsid() {
        return mkcsid;
    }

    public void setMkcsid(Integer mkcsid) {
        this.mkcsid = mkcsid;
    }

    public String getMkuname() {
        return mkuname;
    }

    public void setMkuname(String mkuname) {
        this.mkuname = mkuname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Mk_Note{" +
                "mknid=" + mknid +
                ", mknotecontent='" + mknotecontent + '\'' +
                ", mkcstid=" + mkcstid +
                ", mkuid=" + mkuid +
                ", mknlink='" + mknlink + '\'' +
                ", mknctime=" + mknctime +
                ", mkuimg='" + mkuimg + '\'' +
                ", mkuname='" + mkuname + '\'' +
                ", mkcsid=" + mkcsid +
                ", count=" + count +
                ", childrens=" + childrens +
                '}';
    }

    public Integer getMknid() {
        return mknid;
    }

    public void setMknid(Integer mknid) {
        this.mknid = mknid;
    }

    public String getMknotecontent() {
        return mknotecontent;
    }

    public void setMknotecontent(String mknotecontent) {
        this.mknotecontent = mknotecontent;
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

    public String getMknlink() {
        return mknlink;
    }

    public void setMknlink(String mknlink) {
        this.mknlink = mknlink;
    }

    public Date getMknctime() {
        return mknctime;
    }

    public void setMknctime(Date mknctime) {
        this.mknctime = mknctime;
    }

    public String getMkuimg() {
        return mkuimg;
    }

    public void setMkuimg(String mkuimg) {
        this.mkuimg = mkuimg;
    }

    public List<Mk_NoteImg> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Mk_NoteImg> childrens) {
        this.childrens = childrens;
    }
}
