package com.eyelesson.service;

import com.eyelesson.dao.Ht_mk_UserinfoDao;
import com.eyelesson.entity.Mk_UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Ht_UserInfoService {

    @Resource
    Ht_mk_UserinfoDao htMkUserinfodao;

    //根据用户查找这个用户
    public Mk_UserInfo findByUname(String uname)
    {
        return htMkUserinfodao.findUserName(uname);
    }
    //根据用户的名称去查询职位的编号(角色)
    public int PosId(String uname)
    {
        return htMkUserinfodao.findPosIdByUserName(uname);
    }

}
