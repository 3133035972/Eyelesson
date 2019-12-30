package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import java.util.Map;


/* 课程表 */
@Entity
@Table(name = "mk_course")
public class mk_course {

    @Id
    private Integer mkcsid;
    private String mkctitle;
    private String mkcontent;
    private Integer mkcid;
    private Integer mkdfid;
    private Integer mkuid;
    private Integer mksid;
    private String mkcimg;
    private Integer mkctime;
    private Double mkcmoney;
    private Integer mkclearned;
    private String mkcnote;
    private Integer mkcscore;
    private Integer mkcstate;
    private String mkcourseknow;
    private String mkteacherlearwhat;

    /* 忽略 课程难度表 多对一  */
    @Transient
    private Mk_difficulty mk_difficultys;
    @Transient
    private Integer asktopic;
    @Transient
    private Integer answtop;
    @Transient
    private List<Mk_asktopic> topchildren;
    @Transient
    private List<Mk_answertopic> answerchildren;


    public Integer getAsktopic() {
        return asktopic;
    }

    public void setAsktopic(Integer asktopic) {
        this.asktopic = asktopic;
    }

    public Integer getAnswtop() {
        return answtop;
    }

    public void setAnswtop(Integer answtop) {
        this.answtop = answtop;
    }

    public List<Mk_asktopic> getTopchildren() {
        return topchildren;
    }

    public void setTopchildren(List<Mk_asktopic> topchildren) {
        this.topchildren = topchildren;
    }

    public List<Mk_answertopic> getAnswerchildren() {
        return answerchildren;
    }

    public void setAnswerchildren(List<Mk_answertopic> answerchildren) {
        this.answerchildren = answerchildren;
    }

    @Override
    public String toString() {
        return "mk_course{" +
                "mkcsid=" + mkcsid +
                ", mkctitle='" + mkctitle + '\'' +
                ", mkcontent='" + mkcontent + '\'' +
                ", mkcid=" + mkcid +
                ", mkdfid=" + mkdfid +
                ", mkuid=" + mkuid +
                ", mksid=" + mksid +
                ", mkcimg='" + mkcimg + '\'' +
                ", mkctime=" + mkctime +
                ", mkcmoney=" + mkcmoney +
                ", mkclearned=" + mkclearned +
                ", mkcnote='" + mkcnote + '\'' +
                ", mkcscore=" + mkcscore +
                ", mkcstate=" + mkcstate +
                ", mkcourseknow='" + mkcourseknow + '\'' +
                ", mkteacherlearwhat='" + mkteacherlearwhat + '\'' +
                ", mk_difficultys=" + mk_difficultys +
                ", asktopic=" + asktopic +
                ", answtop=" + answtop +
                ", topchildren=" + topchildren +
                ", answerchildren=" + answerchildren +
                '}';
    }

    public Integer getMkcsid() {
        return mkcsid;
    }

    public void setMkcsid(Integer mkcsid) {
        this.mkcsid = mkcsid;
    }

    public String getMkctitle() {
        return mkctitle;
    }

    public void setMkctitle(String mkctitle) {
        this.mkctitle = mkctitle;
    }

    public String getMkcontent() {
        return mkcontent;
    }

    public void setMkcontent(String mkcontent) {
        this.mkcontent = mkcontent;
    }

    public Integer getMkcid() {
        return mkcid;
    }

    public void setMkcid(Integer mkcid) {
        this.mkcid = mkcid;
    }

    public Integer getMkdfid() {
        return mkdfid;
    }

    public void setMkdfid(Integer mkdfid) {
        this.mkdfid = mkdfid;
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public Integer getMksid() {
        return mksid;
    }

    public void setMksid(Integer mksid) {
        this.mksid = mksid;
    }

    public String getMkcimg() {
        return mkcimg;
    }

    public void setMkcimg(String mkcimg) {
        this.mkcimg = mkcimg;
    }

    public Integer getMkctime() {
        return mkctime;
    }

    public void setMkctime(Integer mkctime) {
        this.mkctime = mkctime;
    }

    public Double getMkcmoney() {
        return mkcmoney;
    }

    public void setMkcmoney(Double mkcmoney) {
        this.mkcmoney = mkcmoney;
    }

    public Integer getMkclearned() {
        return mkclearned;
    }

    public void setMkclearned(Integer mkclearned) {
        this.mkclearned = mkclearned;
    }

    public String getMkcnote() {
        return mkcnote;
    }

    public void setMkcnote(String mkcnote) {
        this.mkcnote = mkcnote;
    }

    public Integer getMkcscore() {
        return mkcscore;
    }

    public void setMkcscore(Integer mkcscore) {
        this.mkcscore = mkcscore;
    }

    public Integer getMkcstate() {
        return mkcstate;
    }

    public void setMkcstate(Integer mkcstate) {
        this.mkcstate = mkcstate;
    }

    public String getMkcourseknow() {
        return mkcourseknow;
    }

    public void setMkcourseknow(String mkcourseknow) {
        this.mkcourseknow = mkcourseknow;
    }

    public String getMkteacherlearwhat() {
        return mkteacherlearwhat;
    }

    public void setMkteacherlearwhat(String mkteacherlearwhat) {
        this.mkteacherlearwhat = mkteacherlearwhat;
    }

    public Mk_difficulty getMk_difficultys() {
        return mk_difficultys;
    }

    public void setMk_difficultys(Mk_difficulty mk_difficultys) {
        this.mk_difficultys = mk_difficultys;
    }
}
