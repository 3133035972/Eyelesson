package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mk_noteimg")
public class Mk_NoteImg {

    private Integer mknid;
    private String mknurl;

    @Override
    public String toString() {
        return "Mk_NoteImg{" +
                "mknid=" + mknid +
                ", mknurl='" + mknurl + '\'' +
                '}';
    }

    public Integer getMknid() {
        return mknid;
    }

    public void setMknid(Integer mknid) {
        this.mknid = mknid;
    }

    public String getMknurl() {
        return mknurl;
    }

    public void setMknurl(String mknurl) {
        this.mknurl = mknurl;
    }
}
