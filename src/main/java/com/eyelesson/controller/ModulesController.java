package com.eyelesson.controller;


import com.eyelesson.service.ModulesService;
import com.eyelesson.util.ModulesNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("modules")
public class ModulesController {
    @Autowired
    ModulesService modelsService;

    //模块
    @RequestMapping("getModules")
    @ResponseBody
   public  List<ModulesNode> getModules(HttpSession session)
    {
        //获取职位的id
        //根据职位的id去查询
       System.out.println(modelsService.getTree((Integer) session.getAttribute("posid")));
        return modelsService.getTree((Integer) session.getAttribute("posid"));

    }

}
