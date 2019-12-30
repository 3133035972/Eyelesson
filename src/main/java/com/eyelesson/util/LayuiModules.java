package com.eyelesson.util;

import java.util.List;

public class LayuiModules {
    private String  value;//绑定节点的标识值。
    private String title;//显示的节点文本标题
    private boolean checked;    //节点状态，true / false 是否选择多选框
    private boolean disabled = false; // 不能
    // 一对多
    private List<LayuiModules> data;// 子节点

    public LayuiModules() {
    }


    public LayuiModules(String value, String title, boolean checked, boolean disabled, List<LayuiModules> data) {
        this.value = value;
        this.title = title;
        this.checked = checked;
        this.disabled = disabled;
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiModules{" +
                "value='" + value + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                ", disabled=" + disabled +
                ", data=" + data +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<LayuiModules> getData() {
        return data;
    }

    public void setData(List<LayuiModules> data) {
        this.data = data;
    }
}
