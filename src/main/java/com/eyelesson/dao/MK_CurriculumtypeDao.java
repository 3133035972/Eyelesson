package com.eyelesson.dao;


import com.eyelesson.entity.MK_Curriculumtype;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/* 课程一级分类表 */
@Mapper
public interface MK_CurriculumtypeDao extends tk.mybatis.mapper.common.Mapper<MK_Curriculumtype> {

    /* 查询全部 */
    @Results({
            @Result(id=true,column = "mkctid",property = "mkctid"),
            @Result(column = "mkctname",property = "mkctname"),
            @Result(property = "mk_curriculums",column = "mkctid",
                    many = @Many(select = "com.eyelesson.dao.Mk_CurriculumDao.findAll",
                            fetchType = FetchType.EAGER))
    })
    @Select("select * from mk_curriculumtype")
    List<MK_Curriculumtype> findAll();

}
