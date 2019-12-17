package com.eyelesson.controller;

import com.eyelesson.entity.*;
import com.eyelesson.service.mk_courseservice;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class mk_coursecontroller {

    @Autowired
    mk_courseservice  mk_courseservice;

    //显示评论页面和数据
    @RequestMapping("comment_show")
    public String comment_show(Integer courseid,String uid,Model model,Integer pagenum,Integer pagesize)
    {
        Map<String, Object> byCidUid = mk_courseservice.findByCidUid(1, "2");
        if(byCidUid.get("mkuid")==null)
        {
            Mk_Staff mksid = mk_courseservice.findStaffId((Integer) byCidUid.get("mksid"));
            model.addAttribute("mksid",mksid);
            model.addAttribute("mkuid",null);
        }
        else
        {
            Mk_Use mkuid = mk_courseservice.findUseId((Integer) byCidUid.get("mkuid"));
            model.addAttribute("mkuid",mkuid);
            model.addAttribute("mksid",null);
        }
        //获取这个课程的所有评论以及点赞
        if(pagenum==null)
        {
            pagenum=1;
        }
        if(courseid==null)
        {
            courseid= (Integer) byCidUid.get("mkcsid");

        }
        List<Map<String,Object>> TypeAll=mk_courseservice.findTypeAll((Integer) byCidUid.get("mkcid"));
        model.addAttribute("type",TypeAll);
        PageInfo<Map<String, Object>> allPing = mk_courseservice.findAllPing(courseid, pagenum, 2);
        model.addAttribute("commentlist",byCidUid);
        model.addAttribute("pageinfo",allPing);
        return "comment";
    }

    //显示章节页面和数据
    @RequestMapping("learn_show")
    public String learn_show(Integer courseid,String uid,Model model)
    {
        Map<String, Object> learn = mk_courseservice.findByCidUid(1, "2");
        if(learn.get("mkuid")==null)
        {
            Mk_Staff mksid = mk_courseservice.findStaffId((Integer) learn.get("mksid"));
            model.addAttribute("mksid",mksid);
            model.addAttribute("mkuid",null);
        }
        else
        {
            Mk_Use mkuid = mk_courseservice.findUseId((Integer) learn.get("mkuid"));
            model.addAttribute("mkuid",mkuid);
            model.addAttribute("mksid",null);
        }
        List<Map<String,Object>> TypeAll=mk_courseservice.findTypeAll((Integer) learn.get("mkcid"));
        model.addAttribute("type",TypeAll);
        //获取这个课程的所有章节
        List<Mk_fathercourse_section> listfu=mk_courseservice.Allfu(1);
        model.addAttribute("listfu",listfu);
        model.addAttribute("commentlist",learn);
        return "learn";
    }
    //显示问答页面的数据
    @RequestMapping("ask_show")
    public String askAll(Integer couseid,Integer pagenum,Integer pagesize,Model model)
    {
        Map<String, Object> byCidUid = mk_courseservice.findByCidUid(1, "2");
        if(byCidUid.get("mkuid")==null)
        {
            Mk_Staff mksid = mk_courseservice.findStaffId((Integer) byCidUid.get("mksid"));
            model.addAttribute("mksid",mksid);
            model.addAttribute("mkuid",null);
        }
        else
        {
            Mk_Use mkuid = mk_courseservice.findUseId((Integer) byCidUid.get("mkuid"));
            model.addAttribute("mkuid",mkuid);
            model.addAttribute("mksid",null);
        }
        //获取这个课程的所有评论以及点赞
        if(pagenum==null)
        {
            pagenum=1;
        }
        if(couseid==null)
        {
            couseid= (Integer) byCidUid.get("mkcsid");
        }
        List<Map<String,Object>> TypeAll=mk_courseservice.findTypeAll((Integer) byCidUid.get("mkcid"));
        model.addAttribute("type",TypeAll);
        PageInfo<Map<String, Object>> askAll = mk_courseservice.findAskAll(couseid, pagenum, 2);
        model.addAttribute("commentlist",byCidUid);
        model.addAttribute("pageinfo",askAll);
        return "ask";
    }
    //查询收藏
    @RequestMapping("iscollect")
    @ResponseBody
    public Mk_Favorites isconllect(Integer mkcsid,Integer mkuid)
    {
        return mk_courseservice.findByFavorites(mkcsid,mkuid);
    }
    //添加收藏
    @RequestMapping("insertcollect")
    @ResponseBody
    public int InsertFavorites(Integer mkcsid,Integer mkuid)
    {
        return mk_courseservice.InsertFavorites(mkcsid, mkuid);
    }

    //删除收藏
    @RequestMapping("Deletecollect")
    @ResponseBody
    public int DeleteFavorites(Integer mkcsid,Integer mkuid)
    {
        return mk_courseservice.DeleteFavorites(mkcsid,mkuid);
    }

    @RequestMapping("video")
    public String Video(Integer mkcstid,Model model,Integer pageNum,Integer pageSize)
    {
        //显示播放的视频
        Mk_soncourse_section son = mk_courseservice.findSon(mkcstid);
        model.addAttribute("son",son);
        //显示章节下面的所有评论
        if(pageNum==null)
        {
            pageNum=1;
        }
        PageInfo<Map<String,Object>> pinglist=mk_courseservice.findZhangAll(mkcstid,pageNum,2);
        model.addAttribute("pageinfo",pinglist);
        List<Mk_fathercourse_section> listfu=mk_courseservice.Allfu(son.getMkcsid());
        model.addAttribute("listfu",listfu);
        List<Mk_soncourse_section> listson=mk_courseservice.listson(son.getMkcsid(),mkcstid);
        model.addAttribute("listson",listson);
        List<Map<String,Object>> TypeAll=mk_courseservice.findTypeAll(son.getMkcid());
        model.addAttribute("type",TypeAll);
        if(pageNum==null)
        {
            pageNum=1;
        }
        PageInfo<Map<String,Object>> wenall=mk_courseservice.wenAll(mkcstid,pageNum,2);
        model.addAttribute("wenall",wenall);
        try{
            //这本笔记
            //从session中获取这个用户的id
            Mk_Note oneNote = mk_courseservice.OneNoteImg(son.getMkcsid(),1);
            model.addAttribute("onenote",oneNote);
        }catch (Exception e){
            model.addAttribute("onenote",null);
        }
        return "video";
    }

    //显示这个用户的笔记
    @RequestMapping("showNote")
    @ResponseBody
    public Mk_Note showNote(Integer mkcsid)
    {
        //从session获取这个用户的id
        return mk_courseservice.OneNoteImg(mkcsid,1);
    }

    //删除笔记
    @RequestMapping("DeNote")
    @ResponseBody
    public int DeleteNote(int mknid)
    {
        return mk_courseservice.DeleteNote(mknid);
    }
    //获取科目下的评论
    @RequestMapping("zall")
    @ResponseBody
    public List<Map<String,Object>> zpAll(Integer mkcstid)
    {
        return mk_courseservice.findzall(mkcstid);
    }

}
