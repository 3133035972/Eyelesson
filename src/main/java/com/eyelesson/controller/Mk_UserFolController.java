package com.eyelesson.controller;

import com.eyelesson.dao.Mk_UserFlower;
import com.eyelesson.entity.Mk_Userconcerns;
import com.eyelesson.service.Mk_UserFllowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class Mk_UserFolController {

    @Autowired
    Mk_UserFllowService mkUserFllowService;

    //判断是否已经关注
    //关注作者
    @RequestMapping("InsertAuth")
    @ResponseBody
    public int InsertAuth(String mkusid,Integer mkuid)
    {
        return mkUserFllowService.InsertAuth(mkusid, mkuid);
    }
    //取消收藏
    @RequestMapping("DeleteMkcsid")
    @ResponseBody
    public int DeleteMkcsid(int mkcsid,int mkuid)
    {
        return mkUserFllowService.DeleteMkcsid(mkcsid,mkuid);
    }

}
