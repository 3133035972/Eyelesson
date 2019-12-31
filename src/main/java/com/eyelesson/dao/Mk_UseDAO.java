package com.eyelesson.dao;

import com.eyelesson.entity.*;
import org.apache.ibatis.annotations.*;
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
    @Update("update mk_use set mkupassword =#{param2} where mkuid=#{param1}")
    int UpdatePwd(int mkuid, String newpwd);
    //查询微博账号
    @Select("select * from mk_use where mkuweibo=#{param1}")
    Mk_Use selectWeibo(String mkuweibo);
    //根据用户的id来查询出来用户的密码
    @Select("select mkupassword from mk_use where mkuid=#{param1}")
    String findpassword(int mkuid);
    //修改微博账号
    @Update("update mk_use set mkuweibo=null where mkuid=#{param1}")
    int UpdateWeibo(int mkuid);
    //修改这个人的个人信息
    @Update("update mk_use set mkuname=#{mkuname},mkusex=#{mkusex},mkusign=#{mkusign} where mkuid=#{mkuid}")
    int UpdateUseInfo(Mk_Use mkUse);
    //获取当前用户的消息
    @Select("select count(mknid) from mk_news where mkcollectuid=#{param1} and mknstatus=0")
    int UserNews(int mkuid);
    //查询当前点击作者的个人信息
    Mk_Staff staff(int mksid);
    //显示作者的实战课程
    @Select("select mkc.* from mk_staff mks\n" +
            "left join mk_staffrole mksr\n" +
            "on mks.mksrid=mksr.mksrid\n" +
            "left join mk_course mkc on mkc.mksid=mks.mksid\n" +
            "where mks.mksid=#{param1} and mkc.mkcmoney!=0 ")
    List<mk_course> Shizhan(int mksid);
    //显示作者的免费课程
    @Select("select mkc.* from mk_staff mks\n" +
            "left join mk_staffrole mksr\n" +
            "on mks.mksrid=mksr.mksrid\n" +
            "left join mk_course mkc on mkc.mksid=mks.mksid\n" +
            "where mks.mksid=#{param1} and mkc.mkcmoney=0")
    List<mk_course> mianfei(int mksid);
    //查询当前用户关注的人
    List<Map<String,Object>> folweruse(int mkuid);
    //查看我的粉丝
    List<Map<String,Object>> myfans(int mkuid);

    @Select("select * from mk_use where mkuphone = #{param1} and mkposid = 4")
    @Results({
            @Result(id = true,column = "mkpid",property = "mkpid"),
            @Result(column = "mkpname",property = "mkpname"),
            @Result(property = "mk_positions",column = "mkpid",javaType = Mk_position.class,
                    one = @One(select = "com.eyelesson.dao.Ht_Mk_positionDao.selectmkpid"))
    })
    Mk_Use selectUse(String mkuphone);

}
