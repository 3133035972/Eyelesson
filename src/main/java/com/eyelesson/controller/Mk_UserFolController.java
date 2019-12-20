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
@RequestMapping("Mk_UserFol")
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


    //显示个人中心页面
    //根据当前登录的人跳转他的个人中心
    @RequestMapping("Useshow")
    public String useshow(Integer mkuid, Model model)
    {
        Map<String, Object> users = mkUserFllowService.users(mkuid);
        model.addAttribute("users",users);
        return "personal";
    }
}
