package com.eyelesson.service;

import com.eyelesson.dao.mk_coursedao;
import com.eyelesson.entity.*;
import com.eyelesson.util.PageData;
import com.eyelesson.util.PageDatas;
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
    public Map<String,Object> findByCidUid(Integer couseid,Integer uid)
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
    public List<Mk_soncourse_section> findzi(int mkscid,int mkcsid)
    {
        return mk_coursedao.listzi(mkscid,mkcsid);
    }

    //先获取某个课程的所有的父级
    public List<Mk_fathercourse_section> Allfu(int courseid)
    {
        List<Mk_fathercourse_section> allfu = mk_coursedao.listfu(courseid);

        for(Mk_fathercourse_section mk:allfu)
        {
            List<Mk_soncourse_section> allzi=mk_coursedao.listzi(mk.getMkfcsid(),mk.getMkcourseid());
            mk.setChildrens(allzi);
        }
        return allfu;
    }

    //获取这个课程下面的笔记和图片1个 一对多
    public Mk_Note OneNoteImg(Integer couseid,Integer mkuid)
    {
        Mk_Note note = mk_coursedao.findTimedesc(couseid,mkuid);
        if(note!=null)
        {
            List<Mk_NoteImg> noteImg = mk_coursedao.findNoteImg(note.getMknid());
            note.setChildrens(noteImg);
        }
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
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(mk_coursedao.findZhangAll(mkcstid));
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
        PageInfo<Map<String,Object>> findaskAll=new PageInfo<Map<String,Object>>(mk_coursedao.findaskAll(coueseid));
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
        PageInfo<Map<String,Object>> all=new PageInfo<Map<String,Object>>(mk_coursedao.findZWen(mkcstid));
        return all;
    }
    //这个章节下的评论
    public List<Map<String,Object>> findzall(int mkcstid)
    {
        return mk_coursedao.findZhangAll(mkcstid);
    }

    //学习进程中插入
    public int InsertProcess(Mk_process mkProcess)
    {
        Mk_process findprocess = mk_coursedao.findprocess(mkProcess.getMkuid(), mkProcess.getMkcstid());
        if(findprocess==null)
        {
            Integer mkcstid = mk_coursedao.selectMaxmkcstid(mkProcess.getMkcsid());
            if(mkcstid==mkProcess.getMkcstid())
            {
                //插入已经学完了
                mkProcess.setMkprid(1);
                return mk_coursedao.InsertProcess(mkProcess);
            }
            //正常插入
            return mk_coursedao.InsertProcess(mkProcess);
        }
        Integer inmkcstid = mk_coursedao.selectMaxmkcstid(mkProcess.getMkcsid());
        if(inmkcstid==mkProcess.getMkcstid())
        {
            //修改时间和进程的进度
            Mk_process mkProcess1=new Mk_process();
            mkProcess1.setMkprduration(mkProcess.getMkprduration());
            mkProcess1.setMkpsrarus(1);
            mkProcess1.setMkuid(mkProcess.getMkuid());
            mkProcess1.setMkcstid(mkProcess.getMkcstid());
            return mk_coursedao.UpdateProcess(mkProcess1);
        }
        //只修改时间
        Mk_process mkProcess1=new Mk_process();
        mkProcess1.setMkprduration(mkProcess.getMkprduration());
        mkProcess1.setMkuid(mkProcess.getMkuid());
        mkProcess1.setMkcstid(mkProcess.getMkcstid());
        return mk_coursedao.UpdateProcess1(mkProcess1);



    }

    /*  前台显示免费课程 4条信息 */
    public List<mk_course> qtmfFour(){
        return mk_coursedao.qtmfFour();
    }

    /*  前台显示实战课程 4条信息 */
    public List<mk_course> qtszFour(){
        return mk_coursedao.qtszFour();
    }


    //查询免费信息
    public PageDatas<Map<String,Object>> flselect(int page, int limit, Integer mkdfid, Integer mkcid, Integer mkctid){
        PageHelper.startPage(page,limit);
        List<Map<String,Object>> jx_studnets = mk_coursedao.flselect(mkdfid,mkcid,mkctid);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(jx_studnets);
        PageDatas<Map<String,Object>> pd = new PageDatas<Map<String,Object>>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(jx_studnets);//当前页的数据
        return pd;
    }


    //查询实战信息
    public PageDatas<Map<String,Object>> szflselect(int page, int limit,Integer mkcid, Integer mkctid){
        PageHelper.startPage(page,limit);
        List<Map<String,Object>> jx_studnets = mk_coursedao.szflselect(mkcid,mkctid);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(jx_studnets);
        PageDatas<Map<String,Object>> pd = new PageDatas<Map<String,Object>>();
        pd.setCurPage(page);//当前第几页
        pd.setPageSize(limit);//每页记录数
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        pd.setTotalPage(pageInfo.getPages());//总共页数
        pd.setCount((int) pageInfo.getTotal());//总记录数
        pd.setData(jx_studnets);//当前页的数据
        return pd;
    }


    //视频管理 查询讲师员视频
    public PageData UseCourse(int page, int limit){
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> emps = mk_coursedao.UseCourse();

        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(emps) ;

        PageData pageData = new PageData(pageInfo.getPageNum(),pageInfo.getSize(), (int) pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList());

        return pageData;

    }




}
