package com.eyelesson.service;

import com.eyelesson.dao.Mk_UseDAO;
import com.eyelesson.dao.Mk_UserFlower;
import com.eyelesson.entity.Mk_Userconcerns;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class Mk_UserFllowService {

    @Resource
    Mk_UserFlower mkUserFlower;

    @Resource
    Mk_UseDAO mkUseDAO;

    //关注用户
    public int InsertAuth(String mkusid,int mkucid)
    {
        Mk_Userconcerns mks=mkUserFlower.findAuth(mkusid,mkucid);
        if(mks==null)
        {
            return mkUserFlower.Insertuserconcerns(mkusid, mkucid);
        }
        int i=mkUserFlower.DeleteAuth(mkusid,mkucid);
        return i=2;
    }
    //显示个人中心
    public Map<String,Object> users(int mkuid)
    {
        return mkUseDAO.users(mkuid);
    }

    //取消收藏
    public int DeleteMkcsid(int mkcsid,int mkuid)
    {
        return mkUserFlower.DeleteMkcsid(mkcsid,mkuid);
    }

}
