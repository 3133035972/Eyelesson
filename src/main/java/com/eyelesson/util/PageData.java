package com.eyelesson.util;

import java.util.List;
import java.util.Map;

public class PageData<T> {
    //当前是第几页
    private Integer curPage;
    //每页显示的数据数
    private Integer pageSize;
    //总共的数据
    private Integer count;
    //总页数
    private Integer totalPage;
    //展现在页面的数据
    List<T> data;
    //状态码
    private Integer code=0;


	public PageData() {

    }



	public PageData(Integer curPage, Integer pageSize, Integer count, Integer totalPage, List<T> data) {
		super();
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.count = count;
		this.totalPage = totalPage;
		this.data = data;

	}



	@Override
	public String toString() {
		return "PageData [curPage=" + curPage + ", pageSize=" + pageSize + ", count=" + count + ", totalPage="
				+ totalPage + ", data=" + data + ", code=" + code + "]";
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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }



    public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}


	public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
