package com.eyelesson.dao;

import com.eyelesson.entity.Mk_position;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface Ht_Mk_positionDao extends Mapper<Mk_position> {

    @Select("select * from mk_position")
    List<Mk_position>  queryAll();

    @Select("select * from mk_position where mkpid = #{mkpid}")
    Mk_position selectmkpid();


}
