package com.eyelesson.service;

import com.eyelesson.dao.Ht_mk_UserinfoDao;
import com.eyelesson.entity.Mk_UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

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

    //后台首页根据用户名显示对应的职位和员工名称
    public Map<String,Object> findPosAndEmpNameByUserName(String mkusername){
        return htMkUserinfodao.findPosAndEmpNameByUserName(mkusername);
    }
}
