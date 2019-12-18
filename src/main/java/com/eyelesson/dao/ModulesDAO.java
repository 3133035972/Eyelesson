package com.eyelesson.dao;


import com.eyelesson.entity.Modules;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ModulesDAO extends Mapper<Modules> {


   //根据对应的职位(角色)来获取不同的权限
   List<Modules> findByParcode(String parentcode, Integer posid);


}
