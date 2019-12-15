package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mk_favorites")
public class Mk_Favorites {

    @Id
    private Integer mkcsid;
    private Integer mkuid;

    @Override
    public String toString() {
        return "Mk_Favorites{" +
                "mkcsid=" + mkcsid +
                ", mkuid=" + mkuid +
                '}';
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
}
