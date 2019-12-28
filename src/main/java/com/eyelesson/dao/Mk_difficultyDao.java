package com.eyelesson.dao;

import com.eyelesson.entity.Mk_difficulty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mk_difficultyDao extends tk.mybatis.mapper.common.Mapper<Mk_difficulty> {

    @Select("select * from mk_difficulty where mkdfid=#{mkdfid}")
    List<Mk_difficulty> findmkdfid(Integer mkdfid);

}
