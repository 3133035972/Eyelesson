package com.eyelesson.controller;


import com.eyelesson.entity.Mk_Staff;
import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.mk_course;
import com.eyelesson.service.*;
import com.eyelesson.util.GetMessageCode;
import com.eyelesson.util.PageDatas;
import com.eyelesson.weibo.weibo4j.Oauth;
import com.eyelesson.weibo.weibo4j.Users;
import com.eyelesson.weibo.weibo4j.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Mk_Use")
public class Mk_UseController {

    @Resource
    Mk_UseService mk_useService;

    @Resource
    Mk_UserFllowService fllowService;

    @Resource
    Mk_WheelplantingService mk_wheelplantingService;

    @Resource
    MK_CurriculumtypeService mk_curriculumtypeService;

    @Resource
    mk_courseservice courseservice;

    @Resource
    Mk_StaffService mk_staffService;

    @Resource
    Mk_CurriculumService mk_curriculumService;

    @Resource
    Mk_difficultyService mk_difficultyService;

    @Resource
    HttpSession session;
    //用户登录
    @RequestMapping("selectOne")
    @ResponseBody
    public Mk_Use selectOne(Mk_Use mkUse){
        System.out.println("账号:"+ mkUse.getMkuphone());
        System.out.println("密码:"+ mkUse.getMkupassword());
        Mk_Use m = mk_useService.selectOne(mkUse);
        System.out.println(m);
        //未读消息
        int news = mk_useService.UserNews(m.getMkuid());
        System.out.println(news);
        session.setAttribute("news",news);
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
            /* 注册编号 */
            c.setMkunum(""+i);
            /* 注册用户名称 */
            c.setMkuname("目课网_"+i);
            /* 注册用户手机号 */
            c.setMkuphone(mkUse.getMkuphone());
            /* 注册用户密码 */
            c.setMkupassword(mkUse.getMkupassword());
            /* 注册创建时间 */
            c.setMkucreatetime(new Date());
            /* 注册用户头像 */
            c.setMkuimg("/img/ming.jpg");
            /* 注册用户状态 */
            c.setMkustate(0);
            /* 注册用户粉丝 */
            c.setMkfollowcount(0);
            /* 注册用户积分 */
            c.setMkuintegral(0);
            /* 注册用户角色 */
            c.setMkposid(1);
            mk_useService.insert(c);
            return "0";
        }


    }


    //首页
    //首页
    @RequestMapping("index")
    public String index(HttpSession session) {
        /* 轮播图 */
        session.setAttribute("qtlbt", mk_wheelplantingService.findAll());
        //System.out.println(session.getAttribute("qtlbt"));
        /*一级二级分类*/
        session.setAttribute("vefl", mk_curriculumtypeService.findAll());
        //System.out.println("123:" + session.getAttribute("vefl"));
        /*首页免费课程显示*/
        session.setAttribute("qtmfkc",courseservice.qtmfFour());
        //System.out.println(session.getAttribute("qtmfkc"));
        /*首页实战课程显示*/
        session.setAttribute("qtszkc",courseservice.qtszFour());
        //System.out.println(session.getAttribute("qtszkc"));
        /* 首页显示员工讲师关注量最多的5位 */
        session.setAttribute("ygjsfive",mk_staffService.findfive());
        System.out.println("session = " + session.getAttribute("ygjsfive"));
        return "index";
    }


    /*获取验证码*/
    @RequestMapping("phone")
    @ResponseBody
    public String phone(String phone){
        Mk_Use mk_use = new Mk_Use();
        mk_use.setMkuphone(phone);
        Mk_Use mkUse = mk_useService.selectOnes(mk_use);
        System.out.println("mkUse:"+mkUse);

        if(mkUse!=null){
            return "0";
        }else{
            String code = GetMessageCode.getCode(phone);
            return code;
        }
    }


    /* 用户安全退出 */
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.getAttribute("msgss");
        session.removeAttribute("msgss");
        return "redirect:index";
    }

    //显示头部
    @RequestMapping("head")
    public String head()
    {
        return "head";
    }

    //取消收藏


    //显示个人中心页面
    //根据当前登录的人跳转他的个人中心
    @RequestMapping("useshow")
    public String useshow(Integer mkuid, Model model,Integer pagenum,Integer pageSize)
    {
        if (pagenum==null)
        {
            pagenum=1;
        }
        //显示用户的信息
        Map<String, Object> users = fllowService.users(mkuid);
        model.addAttribute("users",users);
        //显示用户学习过的全部课程
        PageInfo<Map<String,Object>> usercouseall=mk_useService.usercouseAll(mkuid,pagenum,10);
        model.addAttribute("usercouall",usercouseall);
        //显示用户学习过的免费课程
        PageInfo<Map<String,Object>> usernotpay=mk_useService.usernotpay(mkuid,pagenum,10);
        model.addAttribute("usernotpay",usernotpay);
        //显示用户学习过的实习课程
        PageInfo<Map<String,Object>> userpay=mk_useService.userpay(mkuid,pagenum,10);
        model.addAttribute("userpay",userpay);
        //显示用户免费课程的笔记
        List<Map<String,Object>> usernodes=mk_useService.usernode(mkuid);
        model.addAttribute("usernodes",usernodes);
        //显示用户实战课程的笔记
        List<Map<String,Object>> usermoney=mk_useService.usermoney(mkuid);
        model.addAttribute("usermoney",usermoney);
        //显示这个用户的所有的收藏的课程
        PageInfo<Map<String,Object>> usercoll=mk_useService.usercoll(mkuid,pagenum,10);
        model.addAttribute("pageinfo",usercoll);
        //显示4个实战课程
        List<Map<String,Object>> usershizhan=mk_useService.usershizhan();
        model.addAttribute("shizhan",usershizhan);
        //显示用户最近编辑过的笔记
        List<Map<String,Object>> nownoteall=mk_useService.nownoteall(mkuid);
        model.addAttribute("nownoteall",nownoteall);
        //显示当前用户关注的人
        List<Map<String,Object>> folweruse = mk_useService.folweruse(mkuid);
        model.addAttribute("folweruse",folweruse);
        //我的粉丝
        List<Map<String,Object>> myfans = mk_useService.myfans(mkuid);
        model.addAttribute("myfans",myfans);
        return "personal";
    }

    //显示作者页面
    @RequestMapping("authshow")
    public String authshow(Integer mksid,Model model)
    {
        Mk_Staff staff = mk_useService.mkStaff(mksid);
        model.addAttribute("staff",staff);
        return "lecturer";
    }

    //删除笔记
    @RequestMapping("DelMnid")
    @ResponseBody
    public int DelMnid(int mknid){
        return mk_useService.DelMnid(mknid);
    }
    //修改笔记
    @RequestMapping("UpdMnid")
    @ResponseBody
    public int UpdateMnid(String content,int mknid)
    {
        return mk_useService.UpdateMnid(content, mknid);
    }
    //显示问答
    @RequestMapping("answtopall")
    @ResponseBody
    public mk_course answtopall(int mkcsid, int mkuid)
    {
        return mk_useService.usercourseall(mkcsid,mkuid);
    }

    //跳转到个人设置页面
    @RequestMapping("userSetup")
    public String userSetup(int mkuid,Model model)
    {
        //根据这个用户的信息跳转到个人设置页面
        Mk_Use usersetup = mk_useService.usersetup(mkuid);
        model.addAttribute("usersetup",usersetup);
        return "collect";
    }
    //修改用户的密码
    @RequestMapping("UpdatePwd")
    @ResponseBody
    public int UpdatePwd(int mkuid,String newpwd)
    {
        return mk_useService.UpdatePwd(mkuid, newpwd);
    }
    //修改用户的信息
    @RequestMapping("UpdateUseInfo")
    @ResponseBody
    public int UpdateUseInfo(Mk_Use mkUse)
    {
        return mk_useService.UpdateUseInfo(mkUse);
    }

    /**
     * 点击界面的微博登录按钮 * @param request * @param response
     */
    @RequestMapping("/app/sinaLogin")
    public void sinaLogin(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("123");
        try {
            System.out.println("321");
            response.sendRedirect(new Oauth().authorize("code", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回调地址 * @param request * @param response * @return
     */
    @RequestMapping("/app/sinaRedirect")
    public String sinaLoginRedirect(HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        String code = request.getParameter("code");
        System.out.println("code------"+code);
        try {
            Oauth oauth = new Oauth();
            String token = oauth.getAccessTokenByCode(code).toString();
            String str[] = token.split(",");
            String accessToken = str[0].split("=")[1];
            String str1[] = str[3].split("]");
            String uid = str1[0].split("=")[1];
            Users um = new Users(accessToken);
            User user = um.showUserById(uid);
            System.out.println(user.toString());
            System.out.println("id:"+user.getId());
            Mk_Use mk_use = mk_useService.selectWeibo(user.getId());
            System.out.println("mk_use:"+mk_use);

            if (mk_use!=null){
                session.setAttribute("msgss", mk_use);
            }else{
                Mk_Use c = new Mk_Use();
                int i = mk_useService.selectMkuid();
                System.out.println("userId:" + i);
                /* 注册编号 */
                c.setMkunum("U" + i);
                /* 注册用户名称 */
                c.setMkuname("目课网_" + i);
                /* 注册用户微博账号 */
                c.setMkuweibo(user.getId());
                /* 注册创建时间 */
                c.setMkucreatetime(new Date());
                /* 注册用户头像 */
                c.setMkuimg("/img/ming.jpg");
                /* 注册用户状态 */
                c.setMkustate(0);
                /* 注册用户粉丝 */
                c.setMkfollowcount(0);
                /* 注册用户积分 */
                c.setMkuintegral(0);
                /* 注册用户角色 */
                c.setMkposid(1);

                mk_useService.insert(c);

                Mk_Use mk_use2 = mk_useService.selectWeibo(user.getId());

                session.setAttribute("msgss",mk_use2);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/Mk_Use/index";
    }
    //根据id来查询出密码
    @RequestMapping("findpwd")
    @ResponseBody
    public String findpwd(int mkuid)
    {
        return mk_useService.findpassword(mkuid);
    }
    //根据id来修改微博
    @RequestMapping("UpdateWeibo")
    @ResponseBody
    public int UpdateWeibo(int mkuid)
    {
        return mk_useService.UpdateWeibo(mkuid);
    }

    /* 显示免费课程 */
    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "24") int limit, Integer mkdfid, Integer mkcid, Integer mkctid){
        System.out.println("page = " + page);
        System.out.println("mkdfid = " + mkdfid);
        System.out.println("mkcid = " + mkcid);
        System.out.println("mkctid = " + mkctid);
        /* 免费课程分类 方向 */
        session.setAttribute("qtflfx",mk_curriculumtypeService.selectAll());
        //System.out.println("======:"+session.getAttribute("qtflfx"));
        /* 免费课程分类 分类 */
        session.setAttribute("qtflfls",mk_curriculumService.selectAll());
        //System.out.println("=======:"+session.getAttribute("qtflfls"));
        /* 免费课程分类 难度 */
        session.setAttribute("qtflnd",mk_difficultyService.selectAll());
        //System.out.println("======:"+session.getAttribute("qtflnd"));
        /* 免费课程显示信息 */
        session.setAttribute("flselect", courseservice.flselect(page,25,mkdfid,mkcid,mkctid));
        System.out.println(session.getAttribute("flselect"));
        return "list";
    }

    @RequestMapping("lists")
    @ResponseBody
    public PageDatas<Map<String, Object>>  lists(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "24") int limit,Integer mkdfid,Integer mkcid,Integer mkctid){
        System.out.println("page = " + page);
        System.out.println("mkdfid = " + mkdfid);
        System.out.println("mkcid = " + mkcid);
        System.out.println("mkctid = " + mkctid);
        /* 免费课程分类 方向 */
        session.setAttribute("qtflfx",mk_curriculumtypeService.selectAll());
        //System.out.println("======:"+session.getAttribute("qtflfx"));
        /* 免费课程分类 分类 */
        session.setAttribute("qtflfls",mk_curriculumService.selectAll());
        //System.out.println("=======:"+session.getAttribute("qtflfls"));
        /* 免费课程分类 难度 */
        session.setAttribute("qtflnd",mk_difficultyService.selectAll());
        //System.out.println("======:"+session.getAttribute("qtflnd"));
        /* 免费课程显示信息 */
        /*session.setAttribute("flselect", courseservice.flselect(page,25,mkdfid,mkcid,mkctid));
        System.out.println(session.getAttribute("flselect"));*/
        PageDatas<Map<String, Object>> datas = courseservice.flselect(page, 25, mkdfid, mkcid, mkctid);
        System.out.println("datas = " + datas);
        return datas;
    }

    /* 显示实战课程 */
    @RequestMapping("szlist")
    public String szlist(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "25") int limit, Integer mkcid, Integer mkctid) {
        System.out.println("page = " + page);
        System.out.println("mkcid = " + mkcid);
        System.out.println("mkctid = " + mkctid);
        /* 实战课程分类 方向 */
        session.setAttribute("qtszflfx", mk_curriculumtypeService.selectAll());
        //System.out.println("======:"+session.getAttribute("qtflfx"));
        /* 实战课程分类 分类 */
        session.setAttribute("qtszflfls", mk_curriculumService.selectAll());
        //System.out.println("=======:"+session.getAttribute("qtflfls"));
        /* 实战课程显示信息 */
        session.setAttribute("flszselect", courseservice.szflselect(page, 25, mkcid, mkctid));
        System.out.println(session.getAttribute("flszselect"));
        return "szlist";
    }


    @RequestMapping("szlists")
    @ResponseBody
    public PageDatas<Map<String, Object>> szlists(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "25") int limit, Integer mkcid, Integer mkctid) {
        System.out.println("page = " + page);
        System.out.println("mkcid = " + mkcid);
        System.out.println("mkctid = " + mkctid);
        /* 实战课程分类 方向 */
        session.setAttribute("qtszflfx", mk_curriculumtypeService.selectAll());
        //System.out.println("======:"+session.getAttribute("qtflfx"));
        /* 实战课程分类 分类 */
        session.setAttribute("qtszflfls", mk_curriculumService.selectAll());
        //System.out.println("=======:"+session.getAttribute("qtflfls"));
        /* 实战课程显示信息 */
        PageDatas<Map<String, Object>> datas = courseservice.szflselect(page, 25, mkcid, mkctid);
        System.out.println("datas = " + datas);
        return datas;
    }

}
