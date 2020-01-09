package com.eyelesson.dao;

import com.eyelesson.entity.Mk_soncourse_section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Ht_Mk_soncourse_sectionDao extends tk.mybatis.mapper.common.Mapper<Mk_soncourse_section> {

    /* 根据课程父级编号查询子章节的内容 */
    @Select("select * from mk_soncourse_section where mkcsid=#{param1} and mkfcsid=#{param2}")
    List<Mk_soncourse_section> findmkfcsid(Integer mkcsid, Integer mkfcsid);


    /* 用于子章节添加 */
    @Select("select * from mk_course mkcu\n" +
            "left join mk_curriculum mkcr on mkcu.mkcid=mkcr.mkcid\n" +
            "left join mk_curriculumtype mkct on mkcr.mkctid=mkct.mkctid\n" +
            "left join mk_fathercourse_section mkfs on mkcu.mkcsid=mkfs.mkcourseid\n" +
            "left join mk_difficulty mkdf on mkcu.mkdfid=mkdf.mkdfid\n" +
            " where mkcu.mkcsid=#{param1} and mkfs.mkfcsid=#{param2}")
    Map<String, Object> findmkss(Integer mkcsid, Integer mkfcsid);


    @Select("select * from mk_soncourse_section  where mkcsid=#{param1}")
    List<Mk_soncourse_section> findss(Integer mkcsid);
    /* 删除子章节 */
    @Delete("delete from mk_soncourse_section where mkcstid=#{param1}")
    int deletecstid(Integer mkcstid);

    @Delete("delete from mk_soncourse_section  where mkcsid=#{param1}")
    int deletemkcsid(Integer mkcsid);

    @Select("select count(*) from mk_soncourse_section where mkfcsid=#{param1} and mkcsid=#{param2}")
    int findcstcount(Integer mkfcsid,Integer mkcsid);


}
