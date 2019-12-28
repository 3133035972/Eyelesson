package com.eyelesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("hou")
public class Ht_UserInfoController {

    //显示登录页面
    @RequestMapping("login")
    public String login()
    {
        return "hts/login";
    }
    //显示登录成功页面
    @RequestMapping("loginSuccess")
    public String loginSuccess()
    {
        return "hts/index";
    }
    //显示登录失败页面
    @RequestMapping("loginError")
    public String loginError(Model model)
    {
        model.addAttribute("msg","用户名密码错误");
        return "hts/login";
    }
    //用户注销 直接写地址
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session)
    {
        session.removeAttribute("infos");
        System.out.println("\"123123212\" = " + "123123212");
        return "hts/login";
    }

}
