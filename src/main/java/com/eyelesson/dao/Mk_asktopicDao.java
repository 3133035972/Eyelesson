package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Ip;
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
    Mk_Ip findIp(Integer mkatpid,String address);

    @Update("update mk_asktopic set mkapreview=mkapreview+1 where mkatpid=#{param1}")
    int UpdateMkapreview(Integer mkatpid);

}
