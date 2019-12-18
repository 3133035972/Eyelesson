package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Use;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface Mk_UseDAO extends Mapper<Mk_Use> {
    //通过账号密码查询(登录)
    Mk_Use findOne(Mk_Use m);
    //目课网名称
    int selectMkuid();
    //查询账号
    Mk_Use selectOnes(Mk_Use m);


}
