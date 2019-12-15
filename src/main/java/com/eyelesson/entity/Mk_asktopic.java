package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mk_asktopic")
public class Mk_asktopic {
    @Id
    private Integer mkatpid;
    private String mkatitle;
    private String mkatpcontent;
    private Integer mkcstid;
    private Date mkatptime;
    private Integer mkuid;
    private Integer mkapreview;

    @Override
    public String toString() {
        return "Mk_asktopic{" +
                "mkatpid=" + mkatpid +
                ", mkatitle='" + mkatitle + '\'' +
                ", mkatpcontent='" + mkatpcontent + '\'' +
                ", mkcstid=" + mkcstid +
                ", mkatptime=" + mkatptime +
                ", mkuid=" + mkuid +
                ", mkapreview=" + mkapreview +
                '}';
    }

    public Integer getMkatpid() {
        return mkatpid;
    }

    public void setMkatpid(Integer mkatpid) {
        this.mkatpid = mkatpid;
    }

    public String getMkatitle() {
        return mkatitle;
    }

    public void setMkatitle(String mkatitle) {
        this.mkatitle = mkatitle;
    }

    public String getMkatpcontent() {
        return mkatpcontent;
    }

    public void setMkatpcontent(String mkatpcontent) {
        this.mkatpcontent = mkatpcontent;
    }

    public Integer getMkcstid() {
        return mkcstid;
    }

    public void setMkcstid(Integer mkcstid) {
        this.mkcstid = mkcstid;
    }

    public Date getMkatptime() {
        return mkatptime;
    }

    public void setMkatptime(Date mkatptime) {
        this.mkatptime = mkatptime;
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public Integer getMkapreview() {
        return mkapreview;
    }

    public void setMkapreview(Integer mkapreview) {
        this.mkapreview = mkapreview;
    }
}
