package com.eyelesson.controller;


import com.eyelesson.entity.Mk_Use;
import com.eyelesson.service.Mk_UseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("Mk_Use")
public class Mk_UseController {


    @Resource
    Mk_UseService mk_useService;


    //用户登录
    @RequestMapping("selectOne")
    @ResponseBody
    public Mk_Use selectOne(Mk_Use mkUse, HttpSession session){
        System.out.println("账号:"+ mkUse.getMkuphone());
        System.out.println("密码:"+ mkUse.getMkupassword());
        Mk_Use m = mk_useService.selectOne(mkUse);
        System.out.println(m);
        session.setAttribute("msgss",m);
        return m;
    }

    //用户注册
    @RequestMapping("insertUser")
    @ResponseBody
    public String insertUser(Mk_Use mkUse){
        System.out.println("账号:"+ mkUse.getMkuphone());
        Mk_Use m = mk_useService.selectOnes(mkUse);
        System.out.println(m);
        if (m!=null){
            return "1";
        }else{
            Mk_Use c = new Mk_Use();
            int i = mk_useService.selectMkuid();
            System.out.println("userId:"+i);
            /* 注册用户名称 */
            c.setMkuname("目课网_"+i);
            /* 注册用户手机号 */
            c.setMkuphone(mkUse.getMkuphone());
            /* 注册用户密码 */
            c.setMkupassword(mkUse.getMkupassword());
            /* 注册创建时间 */
            c.setMkucreatetime(new Date());
            /* 注册用户头像 */
            c.setMkuimg("/res/source/0.jpg");
            /* 注册用户角色 */
            c.setMkurole(1);
            mk_useService.insert(c);
            return "0";
        }

    }


    //首页
    @RequestMapping("index")
    public String index(){
        return "index";

    }


    /* 用户安全退出 */
    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.getAttribute("msgss");
        session.removeAttribute("msgss");
        return "redirect:index";
    }

}
