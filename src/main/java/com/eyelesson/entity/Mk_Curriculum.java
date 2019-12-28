package com.eyelesson.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* 课程二级分类表 */
@Entity
@Table(name = "mk_curriculum")
public class Mk_Curriculum {

    @Id
    @Column
    private Integer mkcid;
    @Column
    private String mkcname;
    @Column
    private Integer mkctid;


    @Override
    public String toString() {
        return "Mk_Curriculum{" +
                "mkcid=" + mkcid +
                ", mkcname='" + mkcname + '\'' +
                ", mkctid=" + mkctid +
                '}';
    }

    public Integer getMkcid() {
        return mkcid;
    }

    public void setMkcid(Integer mkcid) {
        this.mkcid = mkcid;
    }

    public String getMkcname() {
        return mkcname;
    }

    public void setMkcname(String mkcname) {
        this.mkcname = mkcname;
    }

    public Integer getMkctid() {
        return mkctid;
    }

    public void setMkctid(Integer mkctid) {
        this.mkctid = mkctid;
    }
}
