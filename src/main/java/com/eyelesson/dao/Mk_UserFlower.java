package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Userconcerns;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface Mk_UserFlower {

    //查询是否关注了作者
    @Select("select *from mk_userconcerns where mkusid=#{param1} and mkucid=#{param2}")
    Mk_Userconcerns findAuth(String mkusid, int mkucid);
    //关注作者
    @Insert("insert into mk_userconcerns values(#{param1},#{param2})")
    int Insertuserconcerns(String mkusid, int mkucid);
    //取消关注作者
    @Delete("delete from mk_userconcerns where mkusid=#{param1} and mkucid=#{param2}")
    int DeleteAuth(String mkusid, int mkucid);
    //取消收藏
    @Delete("delete from mk_favorites where mkcsid=#{param1} and mkuid=#{param2}")
    int DeleteMkcsid(int mkcsid, int mkuid);
}
