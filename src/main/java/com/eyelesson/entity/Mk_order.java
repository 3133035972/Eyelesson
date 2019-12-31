package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name = "mk_order")
public class Mk_order {

    private Integer mkoid;
    private String mkoctime;
    private Integer mkcsid;
    private Integer mkuid;
    private Double mkomoney;
    private Integer mkostate;

    @Transient
    private Integer count;
    @Transient
    private Double totalMoney;
    @Transient
    private String mkcimg;
    @Transient
    private String mkctitle;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getMkcimg() {
        return mkcimg;
    }

    public void setMkcimg(String mkcimg) {
        this.mkcimg = mkcimg;
    }

    public String getMkctitle() {
        return mkctitle;
    }

    public void setMkctitle(String mkctitle) {
        this.mkctitle = mkctitle;
    }

    @Override
    public String toString() {
        return "Mk_order{" +
                "mkoid='" + mkoid + '\'' +
                ", mkoctime=" + mkoctime +
                ", mkcsid=" + mkcsid +
                ", mkuid=" + mkuid +
                ", mkomoney=" + mkomoney +
                ", mkostate=" + mkostate +
                '}';
    }

    public Integer getMkoid() {
        return mkoid;
    }

    public void setMkoid(Integer mkoid) {
        this.mkoid = mkoid;
    }

    public String getMkoctime() {
        return mkoctime;
    }

    public void setMkoctime(String mkoctime) {
        this.mkoctime = mkoctime;
    }

    public Integer getMkcsid() {
        return mkcsid;
    }

    public void setMkcsid(Integer mkcsid) {
        this.mkcsid = mkcsid;
    }

    public Integer getMkuid() {
        return mkuid;
    }

    public void setMkuid(Integer mkuid) {
        this.mkuid = mkuid;
    }

    public Double getMkomoney() {
        return mkomoney;
    }

    public void setMkomoney(Double mkomoney) {
        this.mkomoney = mkomoney;
    }

    public Integer getMkostate() {
        return mkostate;
    }

    public void setMkostate(Integer mkostate) {
        this.mkostate = mkostate;
    }
}
