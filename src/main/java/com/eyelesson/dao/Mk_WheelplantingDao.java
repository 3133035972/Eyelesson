package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Wheelplanting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/* 首页轮播图 */
@Mapper
public interface Mk_WheelplantingDao extends tk.mybatis.mapper.common.Mapper<Mk_Wheelplanting> {


    @Select("select w.mkwpid,c.mkctitle,w.mkwpurl from mk_wheelplanting  w join mk_course c on w.mkcsid =c.mkcsid ")
    List<Map<String,Object>> queryAll();

    @Select("select * from mk_course")
    List<Map<String,Object>> findA();


}
