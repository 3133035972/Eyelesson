package com.eyelesson.controller;

import com.eyelesson.dao.Mk_UserFlower;
import com.eyelesson.entity.Mk_Userconcerns;
import com.eyelesson.service.Mk_UserFllowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Mk_UserFolController {

    @Autowired
    Mk_UserFllowService mkUserFllowService;

    //判断是否已经关注
    //关注作者
    @RequestMapping("InsertAuth")
    @ResponseBody
    public int InsertAuth(Integer mkusid,Integer mkuid)
    {
        return mkUserFllowService.InsertAuth(mkusid, mkuid);
    }
}
