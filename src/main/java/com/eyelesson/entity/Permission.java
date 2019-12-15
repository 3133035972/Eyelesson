package com.eyelesson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 主要用来增删改查分页操作
 * 根据当前登录人查询对应的职务
 * 对应职务所进行的操作
 */
@Entity
@Table(name = "permission")
public class Permission {
    @Column(name = "posId")
    private Integer posId; //职务编号
    @Column(name = "optName")
    private String optName;//进行的操作 增删改查等

    public Permission() {
    }

    public Permission(Integer posId, String optName) {
        this.posId = posId;
        this.optName = optName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "posId=" + posId +
                ", optName='" + optName + '\'' +
                '}';
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getOptName() {
        return optName;
    }

    public void setOptName(String optName) {
        this.optName = optName;
    }
}
