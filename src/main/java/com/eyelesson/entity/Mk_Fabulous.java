package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mk_Fabulous")
public class Mk_Fabulous {

    private Integer mkuid;
    private Integer mkcmid;
    private Integer mkfcount;
    private Integer mknid;

    @Override
    public String toString() {
        return "Mk_Fabulous{" +
                "mkuid=" + mkuid +
                ", mkcmid=" + mkcmid +
                ", mkfcount=" + mkfcount +
                ", mknid=" + mknid +
                '}';
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public Integer getMkcmid() {
        return mkcmid;
    }

    public void setMkcmid(Integer mkcmid) {
        this.mkcmid = mkcmid;
    }

    public Integer getMkfcount() {
        return mkfcount;
    }

    public void setMkfcount(Integer mkfcount) {
        this.mkfcount = mkfcount;
    }

    public Integer getMknid() {
        return mknid;
    }

    public void setMknid(Integer mknid) {
        this.mknid = mknid;
    }
}
