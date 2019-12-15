package com.eyelesson.dao;

import com.eyelesson.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface mk_coursedao  extends Mapper<mk_course> {

    //根据cid和uid查询
    Map<String,Object> findByCouridUid(int courseid, String uid);
    //如果没有学习这个课程就让他学习
    Map<String,Object> findCourid(int courseid,String uid);
    //获取章节的评论
    List<Map<String,Object>> findPingAll(int courseid);
    //获取作者是谁
    @Select("select *from mk_use where mkuid=#{param1}")
    Mk_Use findById(int mkuid);
    //获取员工作者是谁
    @Select("select *from mk_staff where mksid=#{param1}")
    Mk_Staff findstaffId(int mksid);
    //判断是否收藏了
    @Select("select *from mk_favorites where mkcsid=#{param1} and mkuid=#{param2}")
    Mk_Favorites findByCouseiduserid(int mkcsid,int mkuid);
    //插入收藏
    @Insert("insert into  mk_favorites values(#{param1},#{param2})")
    int InsertFavorites(int mkcsid,int mkuid);
    //删除收藏
    @Delete("delete  from mk_favorites where mkcsid=#{param1} and mkuid=#{param2}")
    int DeleteFavorites(int mkcsid,int mkuid);
    //再消息表插入这条关注的消息
    //显示章节级联的关系
    //先查询这个课程所有的父级菜单
    @Select("select *from mk_fathercourse_section \n" +
            "where mkcourseid=#{param1}")
    List<Mk_fathercourse_section> listfu(int courseid);
    //查询子级中的所有父节点
    @Select("select *from mk_soncourse_section where mkfcsid=#{param1} ")
    List<Mk_soncourse_section> listzi(int mkfcsid);
    //查询要播放的这个视频
    @Select("select *from mk_soncourse_section mkss inner join \n" +
            "mk_course mkc on mkss.mkcsid=mkc.mkcsid\n" +
            "where mkcstid=#{param1}")
    Mk_soncourse_section findBySon(int mkcstid);
    //查询这个章节所有的评论
    List<Map<String,Object>> findZhangAll(int mkcstid);
    //显示某个章节下面的所有视频
    @Select("select *from mk_soncourse_section\n" +
            "where mkfcsid=#{param1} and  mkcsid=#{param2}")
    List<Mk_soncourse_section> listson(int mkcstid,int couseid);
    //查询出这个科目下面的所有问答的东西
    List<Map<String,Object>> findaskAll(int couseid);
    //查询出这个类型的图书
    List<Map<String,Object>> findTypeAll(int typeid);
    //查询所有的笔记对应的图片
    @Select("select *from mk_noteimg where mknid=#{param1}")
    List<Mk_NoteImg> findNoteImg(int mknid);
    //查询这个课程1个笔记和图片
    Mk_Note findTimedesc(int couseid);
    //查询这个课程所有的笔记和图片
    List<Mk_Note> findAllNode(int couseid);
    //删除笔记
    @Delete("delete from mk_note where mknid=#{parma1}")
    int DeleteNote(int mknid);
    //删除笔记后图片也删除掉
    @Delete("delete from mk_noteimg where mknid=#{param1}")
    int DeleteImg(int mknid);
    //查询这个章节下面的所有问答
    List<Map<String,Object>> findZWen(int mkcstid);


}
