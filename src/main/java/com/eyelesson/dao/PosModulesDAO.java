package com.eyelesson.dao;


import com.eyelesson.entity.PosModules;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface PosModulesDAO extends tk.mybatis.mapper.common.Mapper<PosModules> {
    //根据职务编号查询对应的菜单执行路径
    @Select("select moduleUrl from  posmodules  pm \n" +
            "join modules m  \n" +
            "on pm.moduleCode = m.moduleCode  \n" +
            " join mk_position p  on p.mkpid = pm.posid\n" +
            " where p.mkpid = #{param1} and  moduleUrl  is not null")
    List<String> findUrlByPosId(Integer posId);
}
