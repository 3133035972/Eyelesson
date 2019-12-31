package com.eyelesson.service;


import com.eyelesson.dao.Mk_UseDAO;
import com.eyelesson.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Mk_UseService {
    @Resource
    Mk_UseDAO mk_useDAO;

    //添加
    public int insert(Mk_Use mkUse) {
        return mk_useDAO.insert(mkUse);
    }

    //删除
    public int delete(Integer mkuid) {
        return mk_useDAO.deleteByPrimaryKey(mkuid);
    }

    //修改
    public int update(Mk_Use mkUse) {
        return mk_useDAO.updateByPrimaryKey(mkUse);
    }

    //查询
    public List<Mk_Use> selectAll() {
        return mk_useDAO.selectAll();
    }

    //登录查询
    public Mk_Use selectOne(Mk_Use mkUse) {
        return mk_useDAO.findOne(mkUse);
    }

    //登录注册
    public Mk_Use selectOnes(Mk_Use mkUse) {
        return mk_useDAO.selectOnes(mkUse);
    }

    //目课注册册名称
    public int selectMkuid() {
        return mk_useDAO.selectMkuid();
    }

    //查询微博账号
    public Mk_Use selectWeibo(String mkuweibo) {
        return mk_useDAO.selectWeibo(mkuweibo);
    }

    //查询这个用户个人中心下的所有课程的笔记
    public List<Map<String, Object>> usernode(int mkuid) {
        return mk_useDAO.usernode(mkuid);
    }

    //查询用户学习过的全部课程
    public PageInfo<Map<String, Object>> usercouseAll(int mkuid, Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        PageInfo<Map<String, Object>> pageinfo = new PageInfo<>(mk_useDAO.usercourseAll(mkuid));
        return pageinfo;
    }

    //显示该用户下不是免费的课程
    public PageInfo<Map<String, Object>> userpay(int mkuid, Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mk_useDAO.userpay(mkuid));
        return pageInfo;
    }

    //显示该用户是免费课程的
    public PageInfo<Map<String, Object>> usernotpay(int mkuid, Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mk_useDAO.usernotpay(mkuid));
        return pageInfo;
    }

    //显示这个用户收藏的全部课程
    public PageInfo<Map<String, Object>> usercoll(int mkuid, Integer pagenum, Integer pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        PageInfo<Map<String, Object>> usercoll = new PageInfo<>(mk_useDAO.usercoll(mkuid));
        return usercoll;
    }

    //显示实战课程4个课程
    public List<Map<String, Object>> usershizhan() {
        return mk_useDAO.usershizhan();
    }

    //查询用户的实战笔记
    public List<Map<String, Object>> usermoney(int mkuid) {
        return mk_useDAO.usermoney(mkuid);
    }

    //显示用户最近编辑过的笔记
    public List<Map<String, Object>> nownoteall(int mkuid) {
        return mk_useDAO.nownote(mkuid);
    }

    //删除笔记
    public int DelMnid(int mknid) {
        return mk_useDAO.DelMnid(mknid);
    }

    //修改笔记
    public int UpdateMnid(String content, int mknid) {
        return mk_useDAO.UpdateMnid(content, mknid);
    }

    //显示课程的信息以及用户的问答
    public mk_course usercourseall(int mkcsid, int mkuid) {
        mk_course list = mk_useDAO.usercouseall(mkcsid, mkuid);
        if (list == null) {
            return mk_useDAO.usercall(mkcsid);
        } else {
            List<Mk_asktopic> list1 = new ArrayList<>();
            List<Mk_answertopic> list2 = new ArrayList<>();
            //循环子节点
            List<Mk_soncourse_section> mks = mk_useDAO.mks(list.getMkcsid());
            //如果子节点不等于0
            if (mks.size() != 0) {
                for (Mk_soncourse_section mkss : mks) {
                    //循环问节点
                    List<Mk_asktopic> hui = mk_useDAO.findHui(mkss.getMkcstid(), mkuid);
                    if (hui.size() != 0) {
                        for (Mk_asktopic a : hui) {
                            list1.add(a);
                        }
                    }
                    //循环答节点
                    List<Mk_answertopic> answer = mk_useDAO.findAnswer(mkss.getMkcstid(), mkuid);
                    if (answer.size() != 0) {
                        for (Mk_answertopic mkAnswertopic : answer) {
                            list2.add(mkAnswertopic);
                        }
                    }
                }
                list.setTopchildren(list1);
                list.setAnswerchildren(list2);
            }
            return list;
        }
    }

    //用户点到个人设置
    public Mk_Use usersetup(int mkuid) {
        return mk_useDAO.usersetup(mkuid);
    }

    //修改密码
    public int UpdatePwd(int mkuid, String newpwd) {
        return mk_useDAO.UpdatePwd(mkuid, newpwd);
    }

    //根据id来查询出用户的密码
    public String findpassword(int mkuid) {
        return mk_useDAO.findpassword(mkuid);
    }

    //根据id来修改微博账号
    public int UpdateWeibo(int mkuid) {
        return mk_useDAO.UpdateWeibo(mkuid);
    }

    //修改个人信息
    public int UpdateUseInfo(Mk_Use mkUse) {
        return mk_useDAO.UpdateUseInfo(mkUse);
    }

    //登录的时候获取到登录的消息
    public int UserNews(int mkuid) {
        return mk_useDAO.UserNews(mkuid);
    }

    //查询当前作者的信息
    public Mk_Staff mkStaff(int mksid) {
        Mk_Staff staff = mk_useDAO.staff(mksid);
        //根据当前作者的信息查询作者的所有实战课程
        List<mk_course> Shizhan = mk_useDAO.Shizhan(mksid);
        if (Shizhan.size() != 0) {
            staff.setShizhan(Shizhan);
        } else {
            staff.setShizhan(null);
        }
        //根据当前作者的信息查询作者的所有免费课程
        List<mk_course> mianfei = mk_useDAO.mianfei(mksid);
        if (mianfei.size() != 0) {
            staff.setMianfei(mianfei);
        } else {
            staff.setMianfei(null);
        }
        return staff;
    }

    //当前用户关注的人
    public List<Map<String,Object>> folweruse(int mkuid)
    {
        return mk_useDAO.folweruse(mkuid);
    }
    //查看我的粉丝
    public List<Map<String,Object>> myfans(int mkuid)
    {
        return mk_useDAO.myfans(mkuid);
    }

    //根据手机号查找用户
    public Mk_Use selectUse(String mkuphone){
        return mk_useDAO.selectUse(mkuphone);
    }
}
