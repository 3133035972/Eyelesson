package com.eyelesson.dao;

import com.eyelesson.entity.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface Mk_UseDAO extends Mapper<Mk_Use> {

    //通过账号密码查询(登录)
    Mk_Use findOne(Mk_Use m);
    //目课网名称
    int selectMkuid();
    //查询账号
    Mk_Use selectOnes(Mk_Use m);
    //根据这个人的id跳转到他的个人中心
    Map<String,Object> users(int mkuid);
    //查询用户在课程下记录过的笔记
    List<Map<String,Object>> usernode(int mkuid);
    //查询用户的实战笔记
    List<Map<String,Object>> usermoney(int mkuid);
    //显示用户学过的全部课程
    List<Map<String,Object>> usercourseAll(int mkuid);
    //显示该用户下所有的免费课程
    List<Map<String,Object>> usernotpay(int mkuid);
    //显示该用户下所有付费的课程
    List<Map<String,Object>> userpay(int mkuid);
    //显示我的收藏里面你的课程
    List<Map<String,Object>> usercoll(int mkuid);
    //显示4个实战课程
    @Select("select *from mk_course mkc \n" +
            "left join mk_difficulty mdf \n" +
            "on mkc.mkdfid=mdf.mkdfid\n" +
            "where mkcmoney!=0\n" +
            "order by mkclearned desc limit 4")
    List<Map<String,Object>> usershizhan();
    //显示最近编辑过的笔记
    List<Map<String,Object>> nownote(int mkuid);
    //删除笔记
    @Delete("delete from mk_note where mknid=#{param1}")
    int DelMnid(int mknid);
    //修改笔记
    @Update("update mk_note set mkntecontent=#{parma1} where mknid=#{param2}")
    int UpdateMnid(String content, int mknid);
    //查询当前用户所在课程所提问的问题和回答的问题
    mk_course usercouseall(int mkcsid, int mkuid);
    //如果没有回答和问题
    mk_course usercall(int mkcsid);
    //获取所有子节点
    @Select("select *from mk_soncourse_section where mkcsid=#{param1}")
    List<Mk_soncourse_section> mks(int mkcsid);
    //获取问节点
    @Select("select mkask.*,mkss.mkcsname,count(mkawc.mkatpid) answer from mk_asktopic mkask\n" +
            "left join mk_soncourse_section mkss on mkask.mkcstid=mkss.mkcstid\n" +
            "left join mk_answertopic mkawc on mkask.mkatpid=mkawc.mkatpid\n" +
            "where mkask.mkcstid=#{param1} and mkask.mkuid=#{param2} \n" +
            "group by mkask.mkatpid")
    List<Mk_asktopic> findHui(int mkcstid, int mkuid);
    //获取答节点
    @Select("select mkask.mkatitle,mkawc.*,mkss.mkcsname,mkss.mkcstid,count(mkawc.mkaid) tanswer from \n" +
            "mk_answertopic mkawc \n" +
            "left join mk_asktopic mkask on mkawc.mkatpid=mkask.mkatpid\n" +
            "left join mk_soncourse_section mkss on mkask.mkcstid=mkss.mkcstid\n" +
            "where mkask.mkcstid=#{param1} and mkawc.mkuid=#{param2}\n" +
            "group by mkawc.mkaid")
    List<Mk_answertopic> findAnswer(int mkcstid, int mkuid);
    //用户点到个人设置
    @Select("select *from mk_use where mkuid=#{param1}")
    Mk_Use usersetup(int mkuid);
    //修改用户的密码
    @Update("update mk_use set mkupassword =#{param2} where mkuid=#{param1} and mkupassword=#{param3}")
    int UpdatePwd(int mkuid, String newpwd, String pwd);
    //查询微博账号
    @Select("select * from mk_use where mkuweibo=#{param1}")
    Mk_Use selectWeibo(String mkuweibo);



}
