package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mk_news")
public class Mk_news {

    @Id
    private Integer mknid;
    private String mknecontent;
    private Integer mkatpid;
    private Integer mkhairuid;
    private Integer mkcollectuid;
    private Integer mknstatus;

    @Override
    public String toString() {
        return "Mk_news{" +
                "mknid=" + mknid +
                ", mknecontent='" + mknecontent + '\'' +
                ", mkatpid=" + mkatpid +
                ", mkhairuid=" + mkhairuid +
                ", mkcollectuid=" + mkcollectuid +
                ", mknstatus=" + mknstatus +
                '}';
    }

    public Integer getMknid() {
        return mknid;
    }

    public void setMknid(Integer mknid) {
        this.mknid = mknid;
    }

    public String getMknecontent() {
        return mknecontent;
    }

    public void setMknecontent(String mknecontent) {
        this.mknecontent = mknecontent;
    }

    public Integer getMkatpid() {
        return mkatpid;
    }

    public void setMkatpid(Integer mkatpid) {
        this.mkatpid = mkatpid;
    }

    public Integer getMkhairuid() {
        return mkhairuid;
    }

    public void setMkhairuid(Integer mkhairuid) {
        this.mkhairuid = mkhairuid;
    }

    public Integer getMkcollectuid() {
        return mkcollectuid;
    }

    public void setMkcollectuid(Integer mkcollectuid) {
        this.mkcollectuid = mkcollectuid;
    }

    public Integer getMknstatus() {
        return mknstatus;
    }

    public void setMknstatus(Integer mknstatus) {
        this.mknstatus = mknstatus;
    }
}
