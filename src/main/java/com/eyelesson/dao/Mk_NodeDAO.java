package com.eyelesson.dao;

import com.eyelesson.entity.Mk_Note;
import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.Mk_asktopic;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface Mk_NodeDAO extends Mapper<Mk_Note> {

    //详细查看这个用户发的笔记
    Map<String,Object> notes(int mkatpid);
    //查看前五个相关问题
    @Select("select *from mk_asktopic\n" +
            "where mkcstid=#{param1}\n" +
            "order by mkatptime desc limit 5")
    List<Mk_asktopic> limit5(int mkcsid);
    //查看这个课程的全部笔记
    List<Map<String,Object>> NoteAll(int mkuid);
    //这个课程讲师的信息
    Map<String,Object> authall(int couseid);
    //查询登录这个人的信息
    @Select("select mkuid,mkuname,mkuimg from mk_use where mkuid=#{param1}")
    Mk_Use use(int mkuid);
    //修改笔记
    @Update("update mk_note set mknotecontent=#{param1} where mknid=#{param2}")
    int UpdateNode(String content,int mknid);

}
