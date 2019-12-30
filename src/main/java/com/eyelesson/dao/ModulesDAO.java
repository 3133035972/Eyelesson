package com.eyelesson.dao;


import com.eyelesson.entity.Modules;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ModulesDAO extends Mapper<Modules> {


   //根据对应的职位(角色)来获取不同的权限
   List<Modules> findByParcode(String parentcode, Integer posid);



  /* List<Modules> findByParentCode(String parentCode,Integer posId);*/


   // 权限分配
   @Select("select * from modules  where parentCode = #{param1}  order by moduleNo")
   List<Modules> showModules(String parentCode);


   // 根据角色查询已有的权限   让复选框选中状态
   @Select("SELECT moduleCode FROM posmodules where posId = #{param1}" )
   List<String> findByPosId(Integer posId);


   // 根据角色清空所属的权限
   @Delete("DELETE from  posmodules  where posId = #{param1}" )
   int delByPosIdModules(Integer posId);


   // 根据角色添加所属的权限
   @Insert("insert into posmodules(posId,moduleCode) \n" +
           "        values(#{param1},#{param2})" )
   int addByPosIdModules(Integer posId, String modules);



}
