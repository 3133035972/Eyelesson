package com.eyelesson.service;

import com.eyelesson.dao.Mk_NodeDAO;
import com.eyelesson.dao.Mk_NoteImgDAO;
import com.eyelesson.entity.Mk_Note;
import com.eyelesson.entity.Mk_NoteImg;
import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.Mk_asktopic;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Mk_NoteService {

    @Resource
    Mk_NodeDAO mkNodeDAO;

    @Resource
    Mk_NoteImgDAO mkNoteImgDAO;
    //发布笔记
    public int Insert(Mk_Note mk_note)
    {
        return mkNodeDAO.insertSelective(mk_note);
    }
    //发布笔记图片
    public int InsertImg(Mk_NoteImg mkNoteImg)
    {
        return mkNoteImgDAO.insert(mkNoteImg);
    }
    //查看详细的笔记
    public Map<String,Object> nodes(int mktapid)
    {
        return mkNodeDAO.notes(mktapid);
    }
    //查看前5个相关问题
    public List<Mk_asktopic> limit5(int mkcstid)
    {
        return mkNodeDAO.limit5(mkcstid);
    }
    //查看这个课程的全部笔记
    public PageInfo<Map<String,Object>> NoteAll(int mkuid,int pagenum,int pagesize)
    {
        PageHelper.startPage(pagenum,pagesize);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(mkNodeDAO.NoteAll(mkuid));
        return pageInfo;
    }
    //查询当前课程的信息
    public Map<String,Object> authAll(int couseid)
    {
        return mkNodeDAO.authall(couseid);
    }
    //查询当前用户的信息
    public Mk_Use mkUse(int mkuid)
    {
        return mkNodeDAO.use(mkuid);
    }
    //修改笔记
    public int UpdateNote(String content,int mknid)
    {
        return mkNodeDAO.UpdateNode(content, mknid);
    }

}
