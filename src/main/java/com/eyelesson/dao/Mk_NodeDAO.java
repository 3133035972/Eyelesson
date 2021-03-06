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

    //发布笔记
    int InsertNode(Mk_Note mkNote);
    //查看这个课程的全部笔记
    List<Map<String,Object>> NoteAll(int mkuid, int mkcsid);
    //这个课程讲师的信息
    Map<String,Object> authall(int couseid);
    //查询登录这个人的信息
    @Select("select mkuid,mkuname,mkuimg from mk_use where mkuid=#{param1}")
    Mk_Use use(int mkuid);
    //修改笔记
    @Update("update mk_note set mknotecontent=#{param1} where mknid=#{param2}")
    int UpdateNode(String content, int mknid);

}
