package com.eyelesson.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mk_fathercourse_section")
public class Mk_fathercourse_section {
    @Id
    @Column
    private Integer mkfcsid;
    @Column
    private Integer mkcourseid;
    @Column
    private String mkfstitle;
    @Column
    private String mkfscontent;

    //一对多个子级节点
    @Transient
    private List<Mk_soncourse_section> childrens;

    public List<Mk_soncourse_section> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Mk_soncourse_section> childrens) {
        this.childrens = childrens;
    }

    @Override
    public String toString() {
        return "Mk_fathercourse_section{" +
                "mkfcsid=" + mkfcsid +
                ", mkcourseid=" + mkcourseid +
                ", mkfstitle='" + mkfstitle + '\'' +
                ", mkfscontent='" + mkfscontent + '\'' +
                ", childrens=" + childrens +
                '}';
    }

    public Integer getMkfcsid() {
        return mkfcsid;
    }

    public void setMkfcsid(Integer mkfcsid) {
        this.mkfcsid = mkfcsid;
    }

    public Integer getMkcourseid() {
        return mkcourseid;
    }

    public void setMkcourseid(Integer mkcourseid) {
        this.mkcourseid = mkcourseid;
    }

    public String getMkfstitle() {
        return mkfstitle;
    }

    public void setMkfstitle(String mkfstitle) {
        this.mkfstitle = mkfstitle;
    }

    public String getMkfscontent() {
        return mkfscontent;
    }

    public void setMkfscontent(String mkfscontent) {
        this.mkfscontent = mkfscontent;
    }
}
