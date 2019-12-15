package com.eyelesson.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * 模块表 菜单
 */
@Entity
@Table(name = "modules")
public class Modules {
    private String moduleCode;//模块编号
    private String moduleText;//模块文本
    private String moduleIconCls;//模块图标
    private String moduleUrl;//模块地址
    private String parentCode;//父级  上级模块编号
    private Date operationTime;//操作时间
    private Integer modelNo; //模块编号  主要用来排序

    private List<Modules> children;//子节点



    public List<Modules> getChildren() {
        return children;
    }

    public void setChildren(List<Modules> children) {
        this.children = children;
    }

    public Modules() {
    }

    public Modules(String moduleCode, String moduleText, String moduleIconCls, String moduleUrl, String parentCode, Integer operationUid, Date operationTime, Integer modelNo) {
        this.moduleCode = moduleCode;
        this.moduleText = moduleText;
        this.moduleIconCls = moduleIconCls;
        this.moduleUrl = moduleUrl;
        this.parentCode = parentCode;
        this.operationTime = operationTime;
        this.modelNo = modelNo;
    }


    @Override
    public String toString() {
        return "Models{" +
                "moduleCode='" + moduleCode + '\'' +
                ", moduleText='" + moduleText + '\'' +
                ", moduleIconCls='" + moduleIconCls + '\'' +
                ", moduleUrl='" + moduleUrl + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", operationTime=" + operationTime +
                ", modelNo=" + modelNo +
                '}';
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleText() {
        return moduleText;
    }

    public void setModuleText(String moduleText) {
        this.moduleText = moduleText;
    }

    public String getModuleIconCls() {
        return moduleIconCls;
    }

    public void setModuleIconCls(String moduleIconCls) {
        this.moduleIconCls = moduleIconCls;
    }

    public String getModuleUrl() {
        return moduleUrl;
    }

    public void setModuleUrl(String moduleUrl) {
        this.moduleUrl = moduleUrl;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }


    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getModelNo() {
        return modelNo;
    }

    public void setModelNo(Integer modelNo) {
        this.modelNo = modelNo;
    }
}
