package com.eyelesson.controller;

import com.eyelesson.entity.Mk_asktopic;
import com.eyelesson.service.Mk_NoteService;
import com.eyelesson.service.Mk_asktopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class Mk_asktopicController {

    @Autowired
    Mk_asktopicService mkAsktopicService;

    //发布问题
    @RequestMapping("InsertAsktopic")
    @ResponseBody
    public int InsertAsktopic(Mk_asktopic mkAsktopic)
    {
        System.out.println(mkAsktopic);
        return mkAsktopicService.insertasktop(mkAsktopic);
    }
    //通过点击这个问题来判断ip来增加浏览量
    //1.先判断这个任务是否已经存在
    //查看详细的笔记
    @RequestMapping("findNode")
    public String FindNode(int mkatpid, Model model) {
        Map<String, Object> nodes = mkAsktopicService.nodes(mkatpid);
        List<Mk_asktopic> limit5=mkAsktopicService.limit5((Integer) nodes.get("mkcstid"));
        model.addAttribute("top5",limit5);
        model.addAttribute("nodes", nodes);
        return "FineNode";
    }

}
