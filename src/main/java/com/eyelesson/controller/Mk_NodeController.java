package com.eyelesson.controller;

import com.eyelesson.entity.Mk_Note;
import com.eyelesson.entity.Mk_NoteImg;
import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.Mk_asktopic;
import com.eyelesson.service.Mk_NoteService;
import com.eyelesson.util.QiniuUtil;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class Mk_NodeController {

    @Autowired
    Mk_NoteService mkNoteService;


    //笔记图片
    @RequestMapping("InsertNode")
    @ResponseBody
    public int  Insert(Mk_Note mkNote,MultipartFile[] file) throws Exception
    {
        int i = mkNoteService.Insert(mkNote);
        JSONObject jsonObject=new JSONObject();
        //定义序号
        try{
            int count=1;
            for(MultipartFile mf:file){
                if(!mf.isEmpty())
                {
                    //重命名
                    String name=mf.getOriginalFilename();
                    //获取文件的扩展名
                    String ext=FilenameUtils.getExtension(mf.getOriginalFilename());
                    //设置图片上传的路径
                    String url="D:/BaiduNetdiskDownload/";
                    //设置图片新的名字
                    String fileName=name+"."+ext;
                    //以绝对路径保存重命名的图片
                    File file1 = new File(url, fileName);
                    mf.transferTo(file1);
                    jsonObject.put("success", true);
                    jsonObject.put("file_path", fileName);
                    //把图片存储路径保存到数据库
                    Mk_NoteImg img=new Mk_NoteImg();
                    img.setMknid(mkNote.getMknid());
                    img.setMknurl(fileName);
                    mkNoteService.InsertImg(img);
                }
                count++;
            }

        }catch (Exception e)
        {
            e.printStackTrace();
            jsonObject.put("success", false);
        }
        return 1;
    }

    //查看详细的笔记
    @RequestMapping("findNode")
    public String FindNode(int mkatpid,Model model) {
        Map<String, Object> nodes = mkNoteService.nodes(mkatpid);
        List<Mk_asktopic> limit5=mkNoteService.limit5((Integer) nodes.get("mkcstid"));
        model.addAttribute("top5",limit5);
        model.addAttribute("nodes", nodes);
        return "FineNode";
    }
    //查看这个课程所有的笔记
    @RequestMapping("CourseNodeAll")
    public String showCourseNote(int mkuid,Integer pagenum,Integer pagesize,Model model)
    {
        if(pagenum==null)
        {
            pagenum=1;
        }
        PageInfo<Map<String, Object>> pageInfo = mkNoteService.NoteAll(mkuid, pagenum, 2);
        model.addAttribute("pageinfo",pageInfo);
        //作者的信息
        Map<String, Object> mkcsid = mkNoteService.authAll((Integer) pageInfo.getList().get(1).get("mkcsid"));
        model.addAttribute("auth",mkcsid);
        //用户的信息
        Mk_Use use = mkNoteService.mkUse(mkuid);
        model.addAttribute("use",use);
        return "notepad";
    }
    //修改笔记
    @RequestMapping("updatenode")
    @ResponseBody
    public int UpdateNode(String content,int mknid)
    {
        return mkNoteService.UpdateNote(content,mknid);
    }

}
