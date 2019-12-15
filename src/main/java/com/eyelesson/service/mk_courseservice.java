package com.eyelesson.service;

import com.eyelesson.dao.mk_coursedao;
import com.eyelesson.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class mk_courseservice {

    @Resource
    mk_coursedao mk_coursedao;

    //查询该用户查看的课程
    public Map<String,Object> findByCidUid(Integer couseid,String uid)
    {
        Map<String,Object> count = mk_coursedao.findByCouridUid(couseid, uid);
        if(count==null)
        {
            return mk_coursedao.findCourid(couseid,null);
        }
        return count;
    }
    //分页获取课程评论全部
    public PageInfo<Map<String,Object>> findAllPing(int courseid,Integer pagenum,Integer pagesize)
    {
        PageHelper.startPage(pagenum,pagesize);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(mk_coursedao.findPingAll(courseid));
        return pageInfo;
    }
    //查询普通用户讲师
    public Mk_Use findUseId(int mkuid)
    {
        return mk_coursedao.findById(mkuid);
    }
    //查询员工角色
    public Mk_Staff findStaffId(int mksid)
    {
        return mk_coursedao.findstaffId(mksid);
    }
    //查询收藏
    public Mk_Favorites findByFavorites(int mkcsid,int mkuid)
    {
        return mk_coursedao.findByCouseiduserid(mkcsid, mkuid);
    }
    //插入收藏
    public int InsertFavorites(int mkcsid,int mkuid)
    {
        return mk_coursedao.InsertFavorites(mkcsid, mkuid);
    }
    //删除收藏
    public int DeleteFavorites(int mkcsid,int mkuid)
    {
        return mk_coursedao.DeleteFavorites(mkcsid, mkuid);
    }

    //一对多
    //获取子节点中所有父节点
    public List<Mk_soncourse_section> findzi(int mkscid)
    {
        return mk_coursedao.listzi(mkscid);
    }

    //先获取某个课程的所有的父级
    public List<Mk_fathercourse_section> Allfu(int courseid)
    {
        List<Mk_fathercourse_section> allfu = mk_coursedao.listfu(1);

        for(Mk_fathercourse_section mk:allfu)
        {
            List<Mk_soncourse_section> allzi=mk_coursedao.listzi(mk.getMkfcsid());
            mk.setChildrens(allzi);
        }
        return allfu;
    }

    //获取这个课程下面的笔记和图片1个 一对多
    public Mk_Note OneNoteImg(Integer couseid)
    {
        Mk_Note note = mk_coursedao.findTimedesc(couseid);
        List<Mk_NoteImg> noteImg = mk_coursedao.findNoteImg(note.getMknid());
        note.setChildrens(noteImg);
        return note;
    }

    //获取这个课程下面的所有笔记和图片 分页
    public List<Mk_Note> AllNoteImg(Integer couseid)
    {
        List<Mk_Note> note = mk_coursedao.findAllNode(couseid);
        for(Mk_Note mk:note)
        {
            List<Mk_NoteImg> noteImg = mk_coursedao.findNoteImg(mk.getMknid());
            mk.setChildrens(noteImg);
        }
        return note;
    }

    //查询要播放的视频
    public Mk_soncourse_section findSon(int mkcstid)
    {
        return mk_coursedao.findBySon(mkcstid);
    }
    //获取某个章节下的所有评论
    public PageInfo<Map<String,Object>> findZhangAll(int mkcstid,Integer pageNum,Integer pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(mk_coursedao.findZhangAll(mkcstid));
        return pageInfo;
    }
    //显示这个章节下面的所有课程
    public List<Mk_soncourse_section> listson(int mkcstid,int couseid)
    {
        return mk_coursedao.listson(mkcstid, couseid);
    }
    //显示这个科目下面的问答
    public PageInfo<Map<String,Object>> findAskAll(int coueseid,Integer pagenum,Integer pagesize)
    {
        PageHelper.startPage(pagenum,pagesize);
        PageInfo<Map<String,Object>> findaskAll=new PageInfo<>(mk_coursedao.findaskAll(coueseid));
        return findaskAll;
    }
    //显示这个类型的课程
    public List<Map<String,Object>> findTypeAll(int typeid)
    {
        return mk_coursedao.findTypeAll(typeid);
    }
    //删除笔记然后删除图片
    public int DeleteNote(int mknid)
    {
        int i=mk_coursedao.DeleteNote(mknid);
        if(i==1)
        {
            mk_coursedao.DeleteImg(mknid);
        }
        return i;

    }

    //这个章节下面的所有问答
    public PageInfo<Map<String,Object>> wenAll(int mkcstid,Integer pagenum,Integer pageSize)
    {
        PageHelper.startPage(pagenum,pageSize);
        PageInfo<Map<String,Object>> all=new PageInfo<>(mk_coursedao.findZWen(mkcstid));
        return all;
    }
    //这个章节下的评论
    public List<Map<String,Object>> findzall(int mkcstid)
    {
        return mk_coursedao.findZhangAll(mkcstid);
    }






}
