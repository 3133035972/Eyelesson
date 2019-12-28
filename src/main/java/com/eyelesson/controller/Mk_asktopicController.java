package com.eyelesson.controller;

import com.eyelesson.entity.Mk_answertopic;
import com.eyelesson.entity.Mk_asktopic;
import com.eyelesson.service.Mk_asktopicService;
import com.eyelesson.util.EditorImg;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class Mk_asktopicController {

    @Autowired
    Mk_asktopicService mkAsktopicService;

    @Resource
    EditorImg editorImg;
    //发布问题
    @RequestMapping("InsertAsktopic")
    @ResponseBody
    public int InsertAsktopic(Mk_asktopic mkAsktopic, MultipartFile[] file) throws Exception {

        editorImg.EditorJsonObject(file);
        if(mkAsktopic.getMkatpcontent()==null)
        {
            return 1;
        }
        return mkAsktopicService.insertasktop(mkAsktopic);
    }
    //通过点击这个问题来判断ip来增加浏览量
    //1.先判断这个任务是否已经存在
    //查看详细的笔记
    @RequestMapping("findNode")
    public String FindNode(int mkatpid, Model model) {
        Map<String, Object> nodes = mkAsktopicService.nodes(mkatpid);
        List<Mk_answertopic> answlist=mkAsktopicService.listanswert(mkatpid);
        List<Mk_asktopic> limit5=mkAsktopicService.limit5((Integer) nodes.get("mkcstid"));
        model.addAttribute("top5",limit5);
        model.addAttribute("nodes", nodes);
        model.addAttribute("answlist",answlist);
        return "FineNode";
    }
    //回答问题
    @RequestMapping("InsertAnswer")
    @ResponseBody
    public int InsertAnswer(Mk_answertopic mkAnswertopic,MultipartFile[] files) throws JSONException {
        editorImg.EditorJsonObject(files);
        if(mkAnswertopic.getMkatpcontent()==null)
        {
            return 1;
        }
        return mkAsktopicService.InsertAnswer(mkAnswertopic);
    }

    //回复的回复
    @RequestMapping("InsertAnAnwer")
    @ResponseBody
    public int InsertAnAnwer(Mk_answertopic mkAnswertopic,MultipartFile[] files) throws JSONException {
        editorImg.EditorJsonObject(files);
        if(mkAnswertopic.getMkatpcontent()==null)
        {
            return 1;
        }
        return mkAsktopicService.InsertAnAnswer(mkAnswertopic);
    }
}
