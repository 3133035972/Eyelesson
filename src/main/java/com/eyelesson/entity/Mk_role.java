package com.eyelesson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/* 角色表 */
@Entity
@Table(name = "mk_role")
public class Mk_role {
    @Id
    @Column
    private Integer mkrid;
    @Column
    private String mkrname;

    @Override
    public String toString() {
        return "Mk_role{" +
                "mkrid=" + mkrid +
                ", mkrname='" + mkrname + '\'' +
                '}';
    }

    public Integer getMkrid() {
        return mkrid;
    }

    public void setMkrid(Integer mkrid) {
        this.mkrid = mkrid;
    }

    public String getMkrname() {
        return mkrname;
    }

    public void setMkrname(String mkrname) {
        this.mkrname = mkrname;
    }
}
