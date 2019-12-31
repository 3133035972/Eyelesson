package com.eyelesson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String mkantptime;
    private Integer mkanum;

    @Transient
    //这里是存储父级节点下面的自己点的id
    private String str;
    @Transient
    private Integer mkcstid;
    @Transient
    private String mkcsname;
    //发帖人的id
    @Transient
    private Integer nodeuid;
    @Transient
    private String mkatitle;

    @Transient
    private Integer tanswer;

    public Integer getNodeuid() {
        return nodeuid;
    }

    public void setNodeuid(Integer nodeuid) {
        this.nodeuid = nodeuid;
    }

    public Integer getTanswer() {
        return tanswer;
    }

    public void setTanswer(Integer tanswer) {
        this.tanswer = tanswer;
    }

    public String getMkatitle() {
        return mkatitle;
    }

    public void setMkatitle(String mkatitle) {
        this.mkatitle = mkatitle;
    }

    public Integer getMkcstid() {
        return mkcstid;
    }

    public void setMkcstid(Integer mkcstid) {
        this.mkcstid = mkcstid;
    }

    public String getMkcsname() {
        return mkcsname;
    }

    public void setMkcsname(String mkcsname) {
        this.mkcsname = mkcsname;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getMkanum() {
        return mkanum;
    }

    public void setMkanum(Integer mkanum) {
        this.mkanum = mkanum;
    }

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
    private Integer fab;
    @Transient
    private String uname;
    @Transient
    private String uimg;

    public Integer getFab() {
        return fab;
    }

    public void setFab(Integer fab) {
        this.fab = fab;
    }

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

    public String getMkantptime() {
        return mkantptime;
    }

    public void setMkantptime(String mkantptime) {
        this.mkantptime = mkantptime;
    }
}
