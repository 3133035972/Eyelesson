package com.eyelesson.service;


import com.eyelesson.dao.Mk_UseDAO;
import com.eyelesson.entity.Mk_Use;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Mk_UseService {
    @Resource
    Mk_UseDAO mk_useDAO;

    //添加
    public int insert(Mk_Use mkUse){
        return mk_useDAO.insert(mkUse);
    }
    //删除
    public int delete(Integer mkuid){
        return mk_useDAO.deleteByPrimaryKey(mkuid);
    }
    //修改
    public int update(Mk_Use mkUse){
        return mk_useDAO.updateByPrimaryKey(mkUse);
    }
    //查询
    public List<Mk_Use> selectAll(){
        return mk_useDAO.selectAll();
    }

    //登录查询
    public Mk_Use selectOne(Mk_Use mkUse){
        return mk_useDAO.findOne(mkUse);
    }

    //登录注册
    public Mk_Use selectOnes(Mk_Use mkUse){
        return mk_useDAO.selectOnes(mkUse);
    }


    //目课注册册名称
    public int selectMkuid(){
        return mk_useDAO.selectMkuid();
    }


}
