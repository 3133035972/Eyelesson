package com.eyelesson.HTcontroller;


import com.alibaba.fastjson.JSONArray;
import com.eyelesson.service.mk_courseservice;
import com.eyelesson.util.PageData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ht_mk_course")
public class Ht_mk_coursecontroller {

    @Resource
    mk_courseservice courseservice;

    //显示 视频管理 显示讲师员视频
    @RequestMapping("UseCourse")
    @ResponseBody
    public String pageQuery(int page, int limit){
        PageData pageData = courseservice.UseCourse(page,limit);
        String jsonStr = JSONArray.toJSONStringWithDateFormat(pageData,"yyyy-MM-dd HH:mm:ss");
        System.out.println("jsonStr = " + jsonStr);
        return jsonStr;
    }
   

}
