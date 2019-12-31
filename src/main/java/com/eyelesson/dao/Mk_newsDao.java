package com.eyelesson.dao;

import com.eyelesson.entity.Mk_news;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface Mk_newsDao  extends Mapper<Mk_news> {

    //这个用户已经读了的信息
    @Select("select * from mk_news where mkcollectuid=#{param1} and mknstatus=1")
    List<Mk_news> listnews(int mkuid);
    //这个用户没有读的信息
    @Select("select * from mk_news where mkcollectuid=#{param1} and mknstatus=0")
    List<Mk_news> Unreadnews(int mkuid);
    //全部修改为已读状态
    @Update("update  mk_news set mknstatus=1 where mkcollectuid=#{param1}")
    int Newstatus(int mkuid);
}
