package com.eyelesson.dao;

import com.eyelesson.entity.*;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface mk_coursedao  extends Mapper<mk_course> {

    //根据cid和uid查询
    Map<String,Object> findByCouridUid(int courseid, Integer uid);
    //如果没有学习这个课程就让他学习
    Map<String,Object> findCourid(int courseid, String uid);
    //获取章节的评论
    List<Map<String,Object>> findPingAll(int courseid);
    //获取作者是谁
    @Select("select *from mk_use where mkuid=#{param1}")
    Mk_Use findById(int mkuid);
    //获取员工作者是谁
    @Select("select *from mk_staff where mksid=#{param1}")
    Mk_Staff findstaffId(int mksid);
    //判断是否收藏了
    @Select("select *from mk_favorites where mkcsid=#{param1} and mkuid=#{param2}")
    Mk_Favorites findByCouseiduserid(int mkcsid, int mkuid);
    //插入收藏
    @Insert("insert into  mk_favorites values(#{param1},#{param2})")
    int InsertFavorites(int mkcsid, int mkuid);
    //删除收藏
    @Delete("delete  from mk_favorites where mkcsid=#{param1} and mkuid=#{param2}")
    int DeleteFavorites(int mkcsid, int mkuid);
    //再消息表插入这条关注的消息
    //显示章节级联的关系
    //先查询这个课程所有的父级菜单
    @Select("select *from mk_fathercourse_section \n" +
            "where mkcourseid=#{param1}")
    List<Mk_fathercourse_section> listfu(int courseid);
    //查询子级中的所有父节点
    @Select("select *from mk_soncourse_section  where mkfcsid=#{param1} and mkcsid=#{param2} ")
    List<Mk_soncourse_section> listzi(int mkfcsid, int mkcsid);
    //查询要播放的这个视频
    @Select("select mkss.*,mkc.mkcid,mksa.mksid,mksa.mksimg,mksa.mkskill,mku.mkuid,mku.mkuimg,mku.mkuintroduce from  mk_soncourse_section  mkss\n" +
            "left join mk_course mkc on  mkss.mkcsid=mkc.mkcsid\n" +
            "left join mk_staff mksa on mkc.mksid=mksa.mksid\n" +
            "left join mk_use mku on mkc.mkuid=mku.mkuid\n" +
            "where mkss.mkcstid=#{param1}")
    Mk_soncourse_section findBySon(int mkcstid);
    //查询这个章节所有的评论
    List<Map<String,Object>> findZhangAll(int mkcstid);
    //显示某个章节下面的所有视频
    @Select("select *from mk_soncourse_section\n" +
            "where mkfcsid=#{param1} and  mkcsid=#{param2}")
    List<Mk_soncourse_section> listson(int mkcstid, int couseid);
    //查询出这个科目下面的所有问答的东西
    List<Map<String,Object>> findaskAll(int couseid);
    //查询出这个类型的图书
    List<Map<String,Object>> findTypeAll(int typeid);
    //查询所有的笔记对应的图片
    @Select("select *from mk_noteimg where mknid=#{param1}")
    List<Mk_NoteImg> findNoteImg(int mknid);
    //查询这个课程1个笔记和图片
    Mk_Note findTimedesc(int couseid, int mkuid);
    //查询这个课程所有的笔记和图片
    List<Mk_Note> findAllNode(int couseid);
    //删除笔记
    @Delete("delete from mk_note where mknid=#{parma1}")
    int DeleteNote(int mknid);
    //删除笔记后图片也删除掉
    @Delete("delete from mk_noteimg where mknid=#{param1}")
    int DeleteImg(int mknid);
    //学习的进度
    @Insert("insert into mk_process(mkprid,mkuid,mkprduration,mkcstid,mkpsrarus)\n" +
            "select max(mkprid)+1,#{mkuid},#{mkprduration},#{mkcstid},#{mkpsrarus} from mk_process")
    int InsertProcess(Mk_process mk_process);
    //查询是不是最后一章节
    @Select("select max(mkcstid) from mk_soncourse_section\n" +
            "where mkcsid=#{param1}")
    Integer selectMaxmkcstid(int mkcsid);
    //查询这个进程存在不存在
    @Select("select *from mk_process where mkuid=#{param1} and mkcstid=#{param2}")
    Mk_process findprocess(int mkuid, int mkcstid);
    //查询这个章节下面的所有问答
    List<Map<String,Object>> findZWen(int mkcstid);
    //修改这个进程的进度
    @Update("update mk_process set mkprduration=#{mkprduration},mkpsrarus=#{mkprarus} where mkuid=#{mkuid} and mkcstid=#{mkcstid}")
    int UpdateProcess(Mk_process mkProcess);
    //只修改时间
    @Update("update mk_process set mkprduration=#{mkprduration} where mkuid=#{mkuid} and mkcstid=#{mkcstid}")
    int UpdateProcess1(Mk_process mkProcess);
    /*  前台显示免费课程 4条信息 */
    @Select("select * from mk_course where mkcmoney<=0  limit 4")
    @Results({
            @Result(id = true,column = "mkdfid",property = "mkdfid"),
            @Result(column = "mkdfname",property = "mkdfname"),
            @Result(property = "mk_difficultys",column = "mkdfid",javaType = Mk_difficulty.class,
                    one = @One(select = "com.eyelesson.dao.Mk_difficultyDao.findmkdfid"))
    })
    List<mk_course> qtmfFour();
    /*  前台显示实战课程 4条信息 */
    @Select("select * from mk_course where mkcmoney>0  limit 4")
    @Results({
            @Result(id = true,column = "mkdfid",property = "mkdfid"),
            @Result(column = "mkdfname",property = "mkdfname"),
            @Result(property = "mk_difficultys",column = "mkdfid",javaType = Mk_difficulty.class,
                    one = @One(select = "com.eyelesson.dao.Mk_difficultyDao.findmkdfid"))
    })
    List<mk_course> qtszFour();

    /* 免费课程 */
    @Select("select * from mk_course mkcr \n" +
            "join mk_difficulty mkdf on\n" +
            "mkcr.mkdfid = mkdf.mkdfid\n" +
            "join mk_curriculum mkcrlum on\n" +
            "mkcr.mkcid = mkcrlum.mkcid\n" +
            "join mk_curriculumtype mkcrtype on\n" +
            "mkcrlum.mkctid = mkcrtype.mkctid\n" +
            "where \n" +
            "mkcr.mkcmoney <=0 \n" +
            "and \n" +
            "mkcr.mkcstate = 0 \n" +
            "and \n" +
            "mkdf.mkdfid like '%${param1}%' \n" +
            "and \n" +
            "mkcrlum.mkcid like '%${param2}%' \n" +
            "and \n" +
            "mkcrtype.mkctid like '%${param3}%' " )
    List<Map<String,Object>> flselect(Integer mkdfid, Integer mkcid, Integer mkctid);


    /* 实战课程 */
    @Select("select * from mk_course mkcr \n" +
            "join mk_difficulty mkdf on\n" +
            "mkcr.mkdfid = mkdf.mkdfid\n" +
            "join mk_curriculum mkcrlum on\n" +
            "mkcr.mkcid = mkcrlum.mkcid\n" +
            "join mk_curriculumtype mkcrtype on\n" +
            "mkcrlum.mkctid = mkcrtype.mkctid\n" +
            "where \n" +
            "mkcr.mkcmoney >0 \n" +
            "and \n" +
            "mkcr.mkcstate = 0 \n" +
            "and \n" +
            "mkcrlum.mkcid like '%${param1}%' \n" +
            "and \n" +
            "mkcrtype.mkctid like '%${param2}%' " )
    List<Map<String,Object>> szflselect(Integer mkcid, Integer mkctid);




    //视频管理 讲师员视频
    @Select("select course.mkcsid,course.mkctitle,course.mkcontent,culum.mkcname,\n" +
            "culty.mkdfname,u.mkuname,course.mkcimg,course.mkctime,\n" +
            "course.mkcmoney,course.mkclearned,course.mkcnote,course.mkcscore,\n" +
            "course.mkcstate,course.mkcourseknow,course.mkteacherlearwhat\n" +
            "from mk_course course join mk_use u on course.mkuid=u.mkuid\n" +
            "join mk_curriculum culum on course.mkcid = culum.mkcid\n" +
            "join mk_difficulty culty on course.mkdfid = culty.mkdfid")
    List<Map<String,Object>> UseCourse();





}
