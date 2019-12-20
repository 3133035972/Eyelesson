package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mk_ip")
public class Mk_Ip {

    private Integer mkatpid;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getMkatpid() {
        return mkatpid;
    }

    public void setMkatpid(Integer mkatpid) {
        this.mkatpid = mkatpid;
    }
}
