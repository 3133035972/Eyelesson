package com.eyelesson.dao;


import com.eyelesson.entity.Mk_fathercourse_section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Ht_Mk_fathercourse_sectionDao extends tk.mybatis.mapper.common.Mapper<Mk_fathercourse_section> {

    /* 根据课程id  父章节标题 章节内容查询父章节id */
    @Select("select * from mk_fathercourse_section where mkcourseid=#{mkcourseid} and mkfstitle=#{mkfstitle} and mkfscontent=#{mkfscontent}")
    Integer findMkfcsid(Mk_fathercourse_section mk_fathercourse_section);


    /* 根据课程编号查询 */
    @Select("select * from mk_fathercourse_section where mkcourseid=#{param1}")
    List<Mk_fathercourse_section> findmf(Integer mkcsid);


    /* 查询父章节id */
    @Select("select mkfcsid from mk_fathercourse_section where mkcourseid=#{mkcourseid} and mkfcsid=#{mkfcsid}")
    Integer fincount(Mk_fathercourse_section mk_fathercourse_section);

    /* 查询父章节id2 */
    @Select("select count(mkfcsid)+1 mkfcsid from mk_fathercourse_section where mkcourseid=#{mkcourseid} and mkfstitle=#{mkfstitle}")
    Integer fincountTie(Mk_fathercourse_section mk_fathercourse_section);

    @Delete("delete from mk_fathercourse_section where mkcourseid=#{param1}")
    int deletemkcsid(Integer mkcsid);


    @Delete("delete from mk_fathercourse_section where mkfcsid=#{param1} and mkcourseid=#{param2}")
    int deletemkfcsid(Integer mkfcsid,Integer mkcourseid);

}
