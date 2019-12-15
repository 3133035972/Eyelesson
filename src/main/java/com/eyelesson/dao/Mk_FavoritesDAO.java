package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Favorites;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface Mk_FavoritesDAO  extends Mapper<Mk_Favorites> {

    //判断这个用户有没有点了用户发的笔记的赞
    @Select("select *from mk_Fabulous where mknid=#{param1} and mkuid=#{param2}")
    Mk_Favorites mkfav(Integer mknid,Integer mkuid);

    //判断这个用户是否有没有没有点赞过的
    @Select("select *from mk_Fabulous where mknid=0 and mkuid=#{param1} limit 1")
    Mk_Favorites mkfas(Integer mkuid);

    //如果没有的话就点赞笔记
    @Update("insert into mk_fabulous(mknid,mkuid) values(#{param1},#{param2})")
    int InsertFav(Integer mknid,Integer mkuid);

    //点了赞就取消点赞
    @Update("update mk_Fabulous set mknid=0 where mknid=#{param1}")
    int CencalFav(Integer mknid);

    //修改取消点赞
    @Update("update  mk_Fabulous set mknid=#{param1} where mkuid=#{param2}")
    int Updatemknid(int mknid,int mkuid);
    //判断评论是否点赞
    @Select("select *from mk_fabulous where mkuid=#{param1} and mkcmid=#{param2}")
    Mk_Favorites findPFav(int mkuid,int mkcmid);
    //已经点赞了 取消点赞
    @Update("update  mk_fabulous set mkcmid=0 where  mkuid=#{param1} and mkcmid=#{param2}")
    int UpdatePFav(int mkuid,int mkcmid);
    //判断是否有取消点赞的评论
    @Select("select *from mk_fabulous where mkuid=#{param1} and mkcmid=0")
    Mk_Favorites findUpdateFav(int mkuid);
    //有就修改
    @Update("update mk_fabulous set mkcmid=#{param1} where mkuid=#{param2} and mkcmid=0")
    int Ufav(int mkcmid,int mkuid);
    //没有就添加
    @Insert("insert into mk_fabulous (mkuid,mkcmid)values(#{param1},#{param2})")
    int insertFav(int mkuid,int mkcmid);



}
