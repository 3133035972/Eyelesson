package com.eyelesson.controller;


import com.alibaba.fastjson.JSONArray;
import com.eyelesson.entity.Mk_Staff;
import com.eyelesson.service.Ht_UserInfoService;
import com.eyelesson.service.Mk_StaffService;
import com.eyelesson.util.PageData;
import com.eyelesson.util.PageT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Mk_Staff")
public class Mk_StaffController {

    @Resource
    Mk_StaffService mk_staffService;

    /*@Resource
    PosService posService;*/

    @Resource
    Ht_UserInfoService ht_userInfoService;

    @Autowired
    HttpSession session;



    //员工分页显示
    @RequestMapping("pageQuery")
    @ResponseBody
    //当前是第page页  每一页limit数据
    public String pageQuery(int page, int limit, String param,Integer mkpid, String startTime,String endTime){
        System.out.println("本次查询的参数是："+param);
        PageData pageData = mk_staffService.pageQuery(page,limit,param,mkpid,startTime,endTime);
        //转换成json类型
        String jsonStr = JSONArray.toJSONStringWithDateFormat(pageData,"yyyy-MM-dd HH:mm:ss");
        return jsonStr;
    }

    //添加员工显示
    /*@RequestMapping("addShow")
    public String addShow(Model model){
        PageT pageT = posService.queryPos();
        List posInfo = pageT.getData();
        System.out.println("添加员工的时候显示的职务是："+posInfo);
        model.addAttribute("posInfo", posInfo);
        return "base/empAdd";
    }*/


    // 添加员工  的同时应该给一个默认的账号
    /*@RequestMapping("addEmp")
    @ResponseBody
    public int  addEmp(String mksname, String mksex, String mksidcard, String mksphone, int mkpid){
        System.out.println(mksname+" "+mksex+" "+mksidcard+" "+mksphone+" "+mkpid);

        Map<String,Object> infos = (Map<String, Object>) session.getAttribute("infos");;

        Integer userId = (Integer) infos.get("userId");

        System.out.println("执行员工添加的时候获取到的当前操作人是："+userId);

        Mk_Staff emp = new Mk_Staff();

        emp.setEmpId(empId);
        emp.setEmpName(empName);
        emp.setSex(sex);
        emp.setIdcard(idcard);
        emp.setPhone(phone);
        emp.setPosId(posId);
        emp.setOperationUid(userId);

        int i = empService.addEmp(emp);

        //给新添加的员工添加账号
        String newEmpId = empService.findNewEmpId().get(0);

        Users users = new Users();
        users.setUserName(empId);//默认的账号名
        users.setPassword(password);//默认的密码
        users.setEmpId(empId);//要添加账号的员工编号
        users.setOperationUid(userId);//操作人 当前登录人的编号
        System.out.println(users);

        int j = usersService.addUsers(users);
        if (i+j == 2){
            return i+j;
        }else {
            return 0;
        }
    }*/

}
