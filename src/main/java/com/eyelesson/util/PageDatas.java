package com.eyelesson.util;

import java.util.List;

public class PageDatas<T> {
    //总页数 count
    private Integer count;
    //当前页的数据
    private List<T> data;
    //状态码
    private Integer code=0;
    //当前第几页
    private Integer curPage;
    //总记录数
    private Integer totalCount;

    private Integer totalPage;
    //每页记录数
    private Integer pageSize;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    @Override
    public String toString() {
        return "PageDatas{" +
                "count=" + count +
                ", data=" + data +
                ", code=" + code +
                ", curPage=" + curPage +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
