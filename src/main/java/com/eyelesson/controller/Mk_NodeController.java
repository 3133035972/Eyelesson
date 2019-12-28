package com.eyelesson.controller;

import com.eyelesson.entity.Mk_Note;
import com.eyelesson.entity.Mk_NoteImg;
import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.Mk_asktopic;
import com.eyelesson.service.Mk_NoteService;
import com.eyelesson.util.EditorImg;
import com.eyelesson.util.QiniuUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class Mk_NodeController {

    @Autowired
    Mk_NoteService mkNoteService;

    @Resource
    EditorImg editorImg;

    //笔记图片
    @RequestMapping("InsertNode")
    @ResponseBody
    public int  Insert(Mk_Note mkNote,MultipartFile[] file) throws Exception
    {
        editorImg.EditorJsonObject(file);
        if(mkNote.getMknotecontent()==null)
        {
            return 1;
        }else
        {
            return mkNoteService.Insert(mkNote);
        }
    }

    //查看这个课程所有的笔记
    @RequestMapping("CourseNodeAll")
    public String showCourseNote(int mkuid,Integer pagenum,Integer pagesize,Model model,Integer mkcsid)
    {
        if(pagenum==null)
        {
            pagenum=1;
        }
        PageInfo<Map<String, Object>> pageInfo = mkNoteService.NoteAll(mkuid, pagenum, 2,mkcsid);
        model.addAttribute("pageinfo",pageInfo);
        //作者的信息
        Map<String, Object> auth = mkNoteService.authAll(mkcsid);
        model.addAttribute("auth",auth);
        //用户的信息
        Mk_Use use = mkNoteService.mkUse(mkuid);
        model.addAttribute("use",use);
        return "notepad";
    }
    //修改笔记
    @RequestMapping("updatenode")
    @ResponseBody
    public int UpdateNode(String content,int mknid,MultipartFile[] files) throws JSONException {
        editorImg.EditorJsonObject(files);
        if(content=="")
        {
            return 1;
        }
        return mkNoteService.UpdateNote(content,mknid);
    }

}
