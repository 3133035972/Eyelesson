package com.eyelesson.service;


import com.eyelesson.dao.Mk_WheelplantingDao;
import com.eyelesson.entity.Mk_Wheelplanting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Mk_WheelplantingService {

    @Resource
    Mk_WheelplantingDao mk_wheelplantingDao;
    /* 查询轮播图 */
    public List<Mk_Wheelplanting> findAll(){
        return mk_wheelplantingDao.selectAll();
    }

    public int add(Mk_Wheelplanting mk_wheelplanting){

        return mk_wheelplantingDao.insert(mk_wheelplanting);
    }
    public int del(int mkwpid){
        return mk_wheelplantingDao.deleteByPrimaryKey(mkwpid);
    }
    public int upd(Mk_Wheelplanting emp){
        return mk_wheelplantingDao.updateByPrimaryKey(emp);
    }

    public Mk_Wheelplanting selectOne(int mkwpid){return  mk_wheelplantingDao.selectByPrimaryKey(mkwpid);}

    public List<Map<String,Object>> queryAll() { return  mk_wheelplantingDao.queryAll(); }

    public List<Map<String,Object>> findA(){
        return mk_wheelplantingDao.findA();
    }

}
