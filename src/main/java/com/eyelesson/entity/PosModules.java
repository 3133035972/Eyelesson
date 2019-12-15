package com.eyelesson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/* 职位菜单表 */
@Entity
@Table(name = "posModules")
public class PosModules {
    @Column
    private Integer posId;//职务编号
    @Column
    private String moduleCode;//菜单编号
    @Column
    private Integer operationUid;//操作人 当前是谁登录操作的
    @Column
    private Date operationTime;//操作时间

    public PosModules() {
    }

    public PosModules(Integer posId, String moduleCode, Integer operationUid, Date operationTime) {
        this.posId = posId;
        this.moduleCode = moduleCode;
        this.operationUid = operationUid;
        this.operationTime = operationTime;
    }


    @Override
    public String toString() {
        return "PosModules{" +
                "posId=" + posId +
                ", moduleCode='" + moduleCode + '\'' +
                ", operationUid=" + operationUid +
                ", operationTime=" + operationTime +
                '}';
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Integer getOperationUid() {
        return operationUid;
    }

    public void setOperationUid(Integer operationUid) {
        this.operationUid = operationUid;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}
