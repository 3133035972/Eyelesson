package com.eyelesson.dao;


import com.eyelesson.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionDAO extends tk.mybatis.mapper.common.Mapper<Permission> {

    //获取权限

    //根据职务编号查询对应的权限
    @Select("select optname from permission where posId = #{param1}")
    List<String> findPermissionByPosId(Integer posId);
}
