package com.eyelesson.entity;

import javax.persistence.*;
import java.util.List;

/* 课程一级分类表 */
@Entity
@Table(name = "mk_curriculumtype")
public class MK_Curriculumtype {
    @Id
    @Column
    private  Integer mkctid;
    @Column
    private String mkctname;

    /* 忽略 课程二级分类表 */
    @Transient
    private List<Mk_Curriculum> mk_curriculums;


    @Override
    public String toString() {
        return "MK_Curriculumtype{" +
                "mkctid=" + mkctid +
                ", mkctname='" + mkctname + '\'' +
                ", mk_curriculums=" + mk_curriculums +
                '}';
    }

    public Integer getMkctid() {
        return mkctid;
    }

    public void setMkctid(Integer mkctid) {
        this.mkctid = mkctid;
    }

    public String getMkctname() {
        return mkctname;
    }

    public void setMkctname(String mkctname) {
        this.mkctname = mkctname;
    }

    public List<Mk_Curriculum> getMk_curriculums() {
        return mk_curriculums;
    }

    public void setMk_curriculums(List<Mk_Curriculum> mk_curriculums) {
        this.mk_curriculums = mk_curriculums;
    }
}
