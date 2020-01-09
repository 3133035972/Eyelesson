package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Curriculum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mk_CurriculumDao extends tk.mybatis.mapper.common.Mapper<Mk_Curriculum> {

    @Select("select * from mk_curriculum where mkctid=#{mkctid} ")
    List<Mk_Curriculum> findAll();

    @Select("select * from mk_curriculum where mkctid=#{param1} ")
    List<Mk_Curriculum> findct(Integer mkctid);

}
