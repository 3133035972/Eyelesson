package com.eyelesson.dao;

import com.eyelesson.entity.Mk_UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface Ht_mk_UserinfoDao extends tk.mybatis.mapper.common.Mapper<Mk_UserInfo> {


    //后台登录
    @Select("select mkst.*,mkuse.mkuserid,mkuse.mkusername,mkuse.mkupassword from mk_userinfo mkuse\n" +
            "left join mk_staff mkst on mkuse.mksid=mkst.mksid\n" +
            "where mkst.mkstate=0 and mkuse.mkusername=#{param1}")
    Mk_UserInfo findUserName(String uname);


    //根据用户的名称去查询职位(角色的编号) 员工
    @Select("select  mkp.mkpid from mk_userinfo mku\n" +
            " join mk_staff mks on mku.mksid=mks.mksid\n" +
            " join mk_position mkp on mkp.mkpid = mks.mksposid\n" +
            " where mkusername = #{param1}")
    Integer findPosIdByUserName(String mkusername);





    //后台首页根据用户名显示对应的职位和员工名称 员工
    @Select("select u.mkuserid,p.mkpname,e.mksname from mk_userinfo  u\n" +
            "join mk_staff e on e.mksid = u.mksid\n" +
            "join mk_position p on p.mkpid = e.mksposid\n" +
            "where u.mkusername = #{param1}")
    Map<String,Object> findPosAndEmpNameByUserName(String mkusername);


    //后台首页根据用户名显示对应的职位和员工名称 用户
    @Select("select * from mk_use  us \n" +
            "join mk_position ps on us.mkposid=ps.mkpid \n" +
            "where us.mkuphone=#{param1}")
    Map<String,Object> findPosAndUseNameByUserName(String mkuphone);

    //根据用户的名称去查询职位(角色的编号) 用户
    @Select("select mkposid from mk_use where mkuphone=#{param1}")
    Integer findPosIdByUserPhone(String mkuphone);



}
