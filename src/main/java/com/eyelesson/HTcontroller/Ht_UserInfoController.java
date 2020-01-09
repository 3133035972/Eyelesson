package com.eyelesson.HTcontroller;

import com.sun.xml.internal.ws.client.sei.SEIStub;
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
    public String loginError(Model model,HttpSession session)
    {
        // 要用 System.out.println("posId======:"+ session.getAttribute("posid"));
        model.addAttribute("msg","用户名密码错误");
        return "hts/login";
    }

    //用户注销 直接写地址
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session)
    {
        System.out.println("posId======:"+ session.getAttribute("posId"));
        System.out.println("posId======:"+ session.getAttribute("posid"));
        session.removeAttribute("infos");

        return "hts/login";
    }


}
