package com.eyelesson.service;

import com.eyelesson.dao.Mk_UserFlower;
import com.eyelesson.entity.Mk_Userconcerns;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Mk_UserFllowService {

    @Resource
    Mk_UserFlower mkUserFlower;


    //关注用户
    public int InsertAuth(int mkusid,int mkucid)
    {
        Mk_Userconcerns mks=mkUserFlower.findAuth(mkusid,mkucid);
        if(mks==null)
        {
            return mkUserFlower.Insertuserconcerns(mkusid, mkucid);
        }
        int i=mkUserFlower.DeleteAuth(mkusid,mkucid);
        return i=2;
    }

}
