package com.eyelesson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* 课程难度表 */
@Entity
@Table(name = "mk_difficulty")
public class Mk_difficulty {
    @Id
    @Column
    private Integer mkdfid;
    @Column
    private String mkdfname;



    @Override
    public String toString() {
        return "Mk_difficulty{" +
                "mkdfid=" + mkdfid +
                ", mkdfname='" + mkdfname + '\'' +
                '}';
    }

    public Integer getMkdfid() {
        return mkdfid;
    }

    public void setMkdfid(Integer mkdfid) {
        this.mkdfid = mkdfid;
    }

    public String getMkdfname() {
        return mkdfname;
    }

    public void setMkdfname(String mkdfname) {
        this.mkdfname = mkdfname;
    }


}
