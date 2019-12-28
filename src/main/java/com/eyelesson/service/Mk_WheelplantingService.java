package com.eyelesson.service;


import com.eyelesson.dao.Mk_WheelplantingDao;
import com.eyelesson.entity.Mk_Wheelplanting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Mk_WheelplantingService {

    @Resource
    Mk_WheelplantingDao mk_wheelplantingDao;
    /* 查询轮播图 */
    public List<Mk_Wheelplanting> findAll(){
        return mk_wheelplantingDao.selectAll();
    }

}
