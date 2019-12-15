package com.eyelesson.dao;

import com.eyelesson.entity.Mk_UserInfo;
import org.apache.ibatis.annotations.Select;

public interface Ht_mk_UserinfoDao {

    //后台登录
    @Select("select mkst.*,mkuse.mkuserid,mkuse.mkusername,mkuse.mkupassword from mk_userinfo mkuse\n" +
            "left join mk_staff mkst on mkuse.mksid=mkst.mksid\n" +
            "where mkst.mkstate=0 and mkuse.mkusername=#{param1}")
    Mk_UserInfo findUserName(String uname);

    //根据用户的名称去查询职位(角色的编号)
    @Select("select  mkp.mkpid from mk_userinfo mku\n" +
            " join mk_staff mks on mku.mksid=mks.mksid\n" +
            " join mk_position mkp on mkp.mkpid = mks.mksposid\n" +
            " where mkusername = #{param1}")
    Integer findPosIdByUserName(String mkusername);

}
