package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "mk_process")
public class Mk_process {
    @Id
    private Integer mkprid;
    private Integer mkuid;
    private Integer mkcstid;
    private Integer mkprduration;
    private Date mkdate;
    private Integer mkpsrarus;

    @Transient
    private Integer mkcsid;

    public Integer getMkcsid() {
        return mkcsid;
    }

    public void setMkcsid(Integer mkcsid) {
        this.mkcsid = mkcsid;
    }


    @Override
    public String toString() {
        return "Mk_process{" +
                "mkprid=" + mkprid +
                ", mkuid=" + mkuid +
                ", mkcstid=" + mkcstid +
                ", mkprduration=" + mkprduration +
                ", mkdate=" + mkdate +
                ", mkpsrarus=" + mkpsrarus +
                '}';
    }

    public Integer getMkprid() {
        return mkprid;
    }

    public void setMkprid(Integer mkprid) {
        this.mkprid = mkprid;
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public Integer getMkcstid() {
        return mkcstid;
    }

    public void setMkcstid(Integer mkcstid) {
        this.mkcstid = mkcstid;
    }

    public Integer getMkprduration() {
        return mkprduration;
    }

    public void setMkprduration(Integer mkprduration) {
        this.mkprduration = mkprduration;
    }

    public Date getMkdate() {
        return mkdate;
    }

    public void setMkdate(Date mkdate) {
        this.mkdate = mkdate;
    }

    public Integer getMkpsrarus() {
        return mkpsrarus;
    }

    public void setMkpsrarus(Integer mkpsrarus) {
        this.mkpsrarus = mkpsrarus;
    }
}
