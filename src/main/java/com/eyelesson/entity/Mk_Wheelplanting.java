package com.eyelesson.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* 首页轮播图 */
@Entity
@Table(name = "mk_wheelplanting")
public class Mk_Wheelplanting {

    @Id
    @Column
    private Integer mkwpid;
    @Column
    private Integer mkcsid;
    @Column
    private String mkwpurl;



    @Override
    public String toString() {
        return "Mk_Wheelplanting{" +
                "mkwpid=" + mkwpid +
                ", mkcsid=" + mkcsid +
                ", mkwpurl='" + mkwpurl + '\'' +
                '}';
    }

    public Integer getMkwpid() {
        return mkwpid;
    }

    public void setMkwpid(Integer mkwpid) {
        this.mkwpid = mkwpid;
    }

    public Integer getMkcsid() {
        return mkcsid;
    }

    public void setMkcsid(Integer mkcsid) {
        this.mkcsid = mkcsid;
    }

    public String getMkwpurl() {
        return mkwpurl;
    }

    public void setMkwpurl(String mkwpurl) {
        this.mkwpurl = mkwpurl;
    }
}
