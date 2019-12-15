package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mk_userconcerns")
public class Mk_Userconcerns {

    private Integer mkusid;
    private Integer mkucid;

    public Integer getMkusid() {
        return mkusid;
    }

    public void setMkusid(Integer mkusid) {
        this.mkusid = mkusid;
    }

    public Integer getMkucid() {
        return mkucid;
    }

    public void setMkucid(Integer mkucid) {
        this.mkucid = mkucid;
    }
}
