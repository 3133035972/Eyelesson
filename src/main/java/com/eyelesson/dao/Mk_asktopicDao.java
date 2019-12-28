package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Ip;
import com.eyelesson.entity.Mk_answertopic;
import com.eyelesson.entity.Mk_asktopic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface Mk_asktopicDao  extends Mapper<Mk_asktopic> {

    //详细查看这个用户发的问题
    Map<String,Object> notes(int mkatpid);
    //查看前五个相关问题
    @Select("select *from mk_asktopic\n" +
            "where mkcstid=#{param1}\n" +
            "order by mkatptime desc limit 5")
    List<Mk_asktopic> limit5(int mkcsid);

    @Select("select *from mk_ip where mkatpid=#{param1} and ip=#{param2}")
    Mk_Ip findIp(Integer mkatpid, String address);

    @Update("update mk_asktopic set mkapreview=mkapreview+1 where mkatpid=#{param1}")
    int UpdateMkapreview(Integer mkatpid);

    //显示这个问题下的全部 回答 父回答以及全部的子回答
    @Select("select mkaw.*,mku.mkuname,mku.mkuimg,count(mkf.mkatpid) fab  from mk_answertopic mkaw\n" +
            "left join mk_use mku on mkaw.mkuid=mku.mkuid\n" +
            "left join mk_fabulous mkf on mkaw.mkantid=mkf.mkatpid\n" +
            "where mkaw.mkatpid=#{param1} and mkaid=0\n" +
            "group by mkaw.mkantid")
    List<Mk_answertopic> listanswer(int mkatpid);

    //显示下面的子节点
    @Select("select mkaw.*,mku.mkuname,mku.mkuimg,mku1.mkuname as uname,mku1.mkuimg as uimg from mk_answertopic mkaw \n" +
            "left join mk_use mku on mkaw.mkuid=mku.mkuid\n" +
            "left join mk_answertopic mka on mkaw.mkantid=mka.mkaid\n" +
            "left join mk_use mku1 on mka.mkuid=mku1.mkuid \n" +
            "where mkaw.mkaid=#{param1}")
    List<Mk_answertopic> listzi(int mkaid);

    //查询这个节点下最大的编号
    @Select("select max(mkanum)+1 from mk_answertopic where mkatpid=#{param1} ")
    Integer mknum(int mkatpid);

    //显示出来回答所在的顺序
    @Select("select mkaw.mkantid as mkantid,mkaw.mkatpid,mkaw.mkatpcontent,mkaw.mkuid,\n" +
            "mkaw.mkaid,mkaw.mkanum,mkaw.mkantptime,mku.mkuname,mku.mkuimg,mku1.mkuname as uname,mku1.mkuimg as uimg,\n" +
            "count(mkf.mkatpid) fab  \n" +
            "from mk_answertopic mkaw\n" +
            "left join mk_use mku on mkaw.mkuid=mku.mkuid\n" +
            "left join mk_fabulous mkf on mkaw.mkantid=mkf.mkatpid\n" +
            "left join mk_answertopic mka on mka.mkantid=mkaw.mkaid\n" +
            "left join mk_use mku1 on mka.mkuid=mku1.mkuid \n" +
            "where mkaw.mkantid in(${param1})\n" +
            "group by mkaw.mkantid\n" +
            "order by field(mkaw.mkantid,${param1}) ")
    List<Mk_answertopic> listall(String str);
    //回答问题
    @Insert("insert into mk_answertopic (mkatpid,mkatpcontent,mkuid,mkaid,mkanum)values(#{mkatpid},#{mkatpcontent},#{mkuid},#{mkaid},#{mkanum})")
    int InsertAnswer(Mk_answertopic mkAnswertopic);

    @Select("select *From mk_asktopic order by mkatpid ${parma1}")
    List<Mk_answertopic> findAll(String tsra);

    //查询出这个问题的内容以及回复的人
    @Select("select mkatp.*,mkatitle from mk_answertopic mkatp\n" +
            "left join mk_asktopic mkask on mkatp.mkatpid=mkask.mkatpid\n" +
            "where mkatp.mkantid=#{param1}")
    Mk_answertopic findMkantid(int mkantid);
}
