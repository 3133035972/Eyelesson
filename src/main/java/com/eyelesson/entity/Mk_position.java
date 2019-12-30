package com.eyelesson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mk_position")
public class Mk_position {
    @Id
    @Column
    private Integer mkpid;
    @Column
    private String mkpname;



    public Mk_position() {
    }


    public Mk_position(Integer mkpid, String mkpname) {
        this.mkpid = mkpid;
        this.mkpname = mkpname;
    }

    public Integer getMkpid() {
        return mkpid;
    }

    public void setMkpid(Integer mkpid) {
        this.mkpid = mkpid;
    }

    public String getMkpname() {
        return mkpname;
    }

    public void setMkpname(String mkpname) {
        this.mkpname = mkpname;
    }

    @Override
    public String toString() {
        return "Mk_position{" +
                "mkpid=" + mkpid +
                ", mkpname='" + mkpname + '\'' +
                '}';
    }

}
