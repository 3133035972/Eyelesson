package com.eyelesson.HTcontroller;


import com.eyelesson.entity.Mk_fathercourse_section;
import com.eyelesson.entity.Mk_soncourse_section;
import com.eyelesson.entity.mk_course;
import com.eyelesson.service.*;
import com.eyelesson.util.PageDatas;
import com.eyelesson.util.ReadVideoTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hou")
public class Ht_mk_coursecontroller {


    @Resource
    mk_courseservice courseservice;

    /* 难度service */
    @Resource
    Mk_difficultyService mk_difficultyService;
    /* 一级课程service */
    @Resource
    MK_CurriculumtypeService mk_curriculumtypeService;
    /* 二级课程service  */
    @Resource
    Mk_CurriculumService mk_curriculumService;

    @Resource
    Ht_Mk_fathercourse_sectionService ht_mk_fathercourse_sectionService;

    @Resource
    Ht_Mk_soncourse_sectionService ht_mk_soncourse_sectionService;

    @Resource
    HttpSession session;


    // ht_mk_course
    /* 后台课程查询 */
    @RequestMapping("ht_mk_course/findcourse")
    @ResponseBody
    public PageDatas<Map<String, Object>> findcourse(int page, int limit, String mkcsid, String mkdfid) {
        PageDatas<Map<String, Object>> findcourse = new PageDatas<Map<String, Object>>();
        /* 获取职位 */
        int posid = (int) session.getAttribute("posid");

        if (mkcsid == null) {
            mkcsid = "";
        }

        if (mkdfid == null) {
            mkdfid = "";
        }

        if (posid == 2) {
            Map<String, Object> infos = (Map<String, Object>) session.getAttribute("infos");

            return courseservice.findcourse(page, limit, (int) infos.get("mkuserid"), null, mkcsid, mkdfid);
        } else if (posid == 4) {

            Map<String, Object> infoss = (Map<String, Object>) session.getAttribute("infoss");

            return courseservice.findcourse(page, limit, null, (int) infoss.get("mkuid"), mkcsid, mkdfid);
        } else {


            return courseservice.findcourse(page, limit, null, null, mkcsid, mkdfid);
        }


    }

    /* 查询全部 用于模糊查询 */
    @RequestMapping("ht_mk_course/findAll")
    @ResponseBody
    public List<mk_course> findAll() {
        return courseservice.findAll();
    }


    /* 查询全部 用于模糊查询 */
    @RequestMapping("ht_mk_course/findsu")
    @ResponseBody
    public List<mk_course> findsu() {
        List<mk_course> mk_courses = new ArrayList<mk_course>();
        /* 获取职位 */
        int posid = (int) session.getAttribute("posid");

        if (posid == 2) {
            Map<String, Object> infos = (Map<String, Object>) session.getAttribute("infos");
            return courseservice.findsu((int) infos.get("mkuserid"), null);
        } else if (posid == 4) {
            Map<String, Object> infoss = (Map<String, Object>) session.getAttribute("infoss");

            return courseservice.findsu(null, (int) infoss.get("mkuid"));

        } else {

            return courseservice.findsu(null, null);
        }
    }


    @RequestMapping("ht_mk_course/addCourseShow")
    /* 添加课程显示 */
    public String addCourseShow() {
        /* 获取职位 */
        int posid = (int) session.getAttribute("posid");

        if (posid == 2) {
            Map<String, Object> infos = (Map<String, Object>) session.getAttribute("infos");
            /* 员工讲师 标题 */
            session.setAttribute("htbtadd", courseservice.findsu((int) infos.get("mkuserid"), null));
        } else if (posid == 4) {
            /* 用户个人讲师 标题 */

            Map<String, Object> infoss = (Map<String, Object>) session.getAttribute("infoss");
            session.setAttribute("htbtadd", courseservice.findsu(null, (int) infoss.get("mkuid")));
        } else {
            /* 经理查看全部 标题 */
            session.setAttribute("htbtadd", courseservice.findsu(null, null));
        }
        /* 全部 一级分类 */
        session.setAttribute("htyjadd", mk_curriculumtypeService.selectAll());
        /* 全部 课程难度 */
        session.setAttribute("htndadd", mk_difficultyService.selectAll());

        return "hts/mk_course/Mk_CourseAdd";

    }

    /* 添加课程 */
    @RequestMapping("ht_mk_course/addCourse")
    @ResponseBody
    public int addCourse(String mkctitle, String mkcontent, String mkcourseknow, String mkteacherlearwhat, String mkcmoney, String mkcimg, String mkcid, String mkdfid, String mkfstitle, String mkfscontent, String mkcsname, String mkcsurl, String mkssimg, String jsmkcsname, String jsmkcsurl, String jsmkssimg) {
        /* 获取时长 封装好的 */
        ReadVideoTime readVideoTime = new ReadVideoTime();
        /* 课程表 */
        mk_course course = new mk_course();
        // 课程的标题
        course.setMkctitle(mkctitle);
        // 课程的简介
        course.setMkcontent(mkcontent);
        // 课程须知
        course.setMkcourseknow(mkcourseknow);
        // 讲师告诉你可以学到什么
        course.setMkteacherlearwhat(mkteacherlearwhat);
        // 课程的价格 默认为0
        course.setMkcmoney(Double.parseDouble(mkcmoney));
        // 课程的封面
        course.setMkcimg(mkcimg);
        // 课程的类型 连接二级类型表外键
        course.setMkcid(Integer.parseInt(mkcid));
        // 课程难度表的外键
        course.setMkdfid(Integer.parseInt(mkdfid));


        /* 获取职位 */
        int posid = (int) session.getAttribute("posid");

        if (posid == 2) {
            Map<String, Object> infos = (Map<String, Object>) session.getAttribute("infos");
            /* 员工讲师 标题 */
            course.setMksid((int) infos.get("mkuserid"));
            course.setMkcstate(0);

        } else if (posid == 4) {
            /* 用户个人讲师 标题 */
            Map<String, Object> infoss = (Map<String, Object>) session.getAttribute("infoss");
            course.setMkuid((int) infoss.get("mkuid"));
            course.setMkcstate(0);
        } else {
            /* 经理查看全部 标题 */
            Map<String, Object> infos = (Map<String, Object>) session.getAttribute("infos");

            course.setMksid((int) infos.get("mkuserid"));
            course.setMkcstate(0);
        }


        List<String> list = new ArrayList<String>();


        //分割jsmkcsname
        String[] jsmkcsnames = jsmkcsname.split(",");//切割字符串返回的数组
        String[] jsmkcsnamesInfo = new String[jsmkcsnames.length];//定义一个数组来接收这个分割的数组

        //分割jsmkcsurl
        String[] jsmkcsurls = jsmkcsurl.split(",");//切割字符串返回的数组
        String[] jsmkcsurlsInfo = new String[jsmkcsurls.length];//定义一个数组来接收这个分割的数组

        //分割jsmkssimg
        String[] jsmkssimgs = jsmkssimg.split(",");//切割字符串返回的数组
        String[] jsmkssimgsInfo = new String[jsmkssimgs.length];//定义一个数组来接收这个分割的数组

        if (jsmkcsname!="") {
            for (int i = 0; i < jsmkcsnamesInfo.length; i++) {
                //jsmkcsurls
                jsmkcsurlsInfo[i] = jsmkcsurls[i];
                list.add(jsmkcsurlsInfo[i]);
            }
        }

        list.add(mkcsurl);
        /* 课程时长 */
        course.setMkctime(readVideoTime.VideoTotalM(list.size(), list));
        /* 添加课程 */
        courseservice.addMk_course(course);


        /* 获取课程表Id */
        /*Integer findmkcsid = courseservice.findmkcsid(course.getMkctitle(),course.getMksid());*/
        Integer findmkcsid = courseservice.findmkcsid(course);
        /*System.out.println("a = " + a);
        int findmkcsid = a.getMkcsid();*/

        /* 父级章节 */
        Mk_fathercourse_section mk_fathercourse_section = new Mk_fathercourse_section();
        /* 父级编号 */
        mk_fathercourse_section.setMkfstitle(mkfstitle);
        mk_fathercourse_section.setMkfscontent(mkfscontent);
        mk_fathercourse_section.setMkcourseid(findmkcsid);
        /* 获取父章节id */
        Integer mkfcsid = ht_mk_fathercourse_sectionService.findMkfcsid(mk_fathercourse_section);

        if (mkfcsid == null) {
            mkfcsid = 1;
        }

        mk_fathercourse_section.setMkfcsid(mkfcsid);
        /* 添加父级章节 */
        ht_mk_fathercourse_sectionService.add(mk_fathercourse_section);
        /* 子级章节 */
        Mk_soncourse_section mk_soncourse_section = new Mk_soncourse_section();
        mk_soncourse_section.setMkcsid(findmkcsid);
        mk_soncourse_section.setMkfcsid(mkfcsid);
        mk_soncourse_section.setMkcsname(mkcsname);
        mk_soncourse_section.setMkcsurl(mkcsurl);
        /* 时长 */
        mk_soncourse_section.setMkcstime(readVideoTime.VideoChar(mkcsurl));
        mk_soncourse_section.setMkssimg(mkssimg);
        mk_soncourse_section.setMkonsale(0);
        int add = ht_mk_soncourse_sectionService.add(mk_soncourse_section);

        if (jsmkcsname!="") {

            /* 子级 */
            for (int i = 0; i < jsmkcsnamesInfo.length; i++) {
                //jsmkcsname
                jsmkcsnamesInfo[i] = jsmkcsnames[i];
                //jsmkcsurls
                jsmkcsurlsInfo[i] = jsmkcsurls[i];
                list.add(jsmkcsurlsInfo[i]);
                //jsmkssimg
                jsmkssimgsInfo[i] = jsmkssimgs[i];
                Mk_soncourse_section section = new Mk_soncourse_section();
                section.setMkcsid(findmkcsid);
                section.setMkfcsid(mkfcsid);
                section.setMkcsname(jsmkcsnamesInfo[i]);
                section.setMkcsurl(jsmkcsurlsInfo[i]);
                /* 时长 */
                section.setMkcstime(readVideoTime.VideoChar(jsmkcsurlsInfo[i]));
                section.setMkssimg(jsmkssimgsInfo[i]);
                section.setMkonsale(0);
                ht_mk_soncourse_sectionService.add(section);
            }
        }
        return 1;
    }


    @RequestMapping("ht_mk_course/addmkssShow")
    public String findmkss(Integer mkcsid, Integer mkfcsid) {

        session.setAttribute("findmkss", ht_mk_soncourse_sectionService.findmkss(mkcsid, mkfcsid));

        session.setAttribute("findmf", ht_mk_fathercourse_sectionService.findmf(mkcsid));

        return "hts/mk_soncourse_section/Mk_soncourse_sectionAdd";
    }


    /* 添加章节 */
    @RequestMapping("ht_mk_course/addmkss")
    @ResponseBody
    public int addmkss(String mkcsid, String mkfstitle, String newmkfstitle, String mkfscontent, String mkcsname, String mkcsurl, String mkssimg, String jsmkcsname, String jsmkcsurl, String jsmkssimg) {

        Integer fincount = 0;

        /* 获取时长 封装好的 */
        ReadVideoTime readVideoTime = new ReadVideoTime();

        Mk_fathercourse_section mk_fathercourse_section = new Mk_fathercourse_section();
        mk_fathercourse_section.setMkcourseid(Integer.parseInt(mkcsid));
        if (mkfstitle == null || mkfstitle == "") {
            mk_fathercourse_section.setMkfstitle(newmkfstitle);
            mk_fathercourse_section.setMkfscontent(mkfscontent);
            fincount = ht_mk_fathercourse_sectionService.fincountTie(mk_fathercourse_section);
            mk_fathercourse_section.setMkfcsid(fincount);
            ht_mk_fathercourse_sectionService.add(mk_fathercourse_section);
        } else {
            mk_fathercourse_section.setMkfcsid(Integer.parseInt(mkfstitle));
            fincount = ht_mk_fathercourse_sectionService.fincount(mk_fathercourse_section);
        }

        //分割jsmkcsname
        String[] jsmkcsnames = jsmkcsname.split(",");//切割字符串返回的数组
        String[] jsmkcsnamesInfo = new String[jsmkcsnames.length];//定义一个数组来接收这个分割的数组

        //分割jsmkcsurl
        String[] jsmkcsurls = jsmkcsurl.split(",");//切割字符串返回的数组
        String[] jsmkcsurlsInfo = new String[jsmkcsurls.length];//定义一个数组来接收这个分割的数组

        //分割jsmkssimg
        String[] jsmkssimgs = jsmkssimg.split(",");//切割字符串返回的数组
        String[] jsmkssimgsInfo = new String[jsmkssimgs.length];//定义一个数组来接收这个分割的数组

        /* 子级章节 */
        Mk_soncourse_section mk_soncourse_section = new Mk_soncourse_section();
        mk_soncourse_section.setMkcsid(Integer.parseInt(mkcsid));
        mk_soncourse_section.setMkfcsid(fincount);
        mk_soncourse_section.setMkcsname(mkcsname);
        mk_soncourse_section.setMkcsurl(mkcsurl);
        /* 时长 */
        mk_soncourse_section.setMkcstime(readVideoTime.VideoChar(mkcsurl));
        mk_soncourse_section.setMkssimg(mkssimg);
        mk_soncourse_section.setMkonsale(0);
        ht_mk_soncourse_sectionService.add(mk_soncourse_section);

        if (jsmkcsname != "") {

            System.out.println("--[[]]----[[]]----[[]]----[[]]--");

            /* 子级 */
            for (int i = 0; i < jsmkcsnamesInfo.length; i++) {
                //jsmkcsname
                jsmkcsnamesInfo[i] = jsmkcsnames[i];
                //jsmkcsurls
                jsmkcsurlsInfo[i] = jsmkcsurls[i];
                //jsmkssimg
                jsmkssimgsInfo[i] = jsmkssimgs[i];
                Mk_soncourse_section section = new Mk_soncourse_section();
                section.setMkcsid(Integer.parseInt(mkcsid));
                section.setMkfcsid(fincount);
                section.setMkcsname(jsmkcsnamesInfo[i]);
                section.setMkcsurl(jsmkcsurlsInfo[i]);
                /* 时长 */
                section.setMkcstime(readVideoTime.VideoChar(jsmkcsurlsInfo[i]));
                section.setMkssimg(jsmkssimgsInfo[i]);
                section.setMkonsale(0);
                ht_mk_soncourse_sectionService.add(section);
            }
        }

        /* 获取当前课程的总时长 */
        List<Mk_soncourse_section> findss = ht_mk_soncourse_sectionService.findss(Integer.parseInt(mkcsid));
        String s = readVideoTime.VideoTotal(findss.size(), findss);
        System.out.println("mkcsidmkcsid:"+mkcsid);
        System.out.println("sssssssssss:"+s);
        /* 修改课程时长 */
        courseservice.updateTile(s, Integer.parseInt(mkcsid));
        return 1;
    }



    /* 删除课程 */
    @RequestMapping("ht_mk_course/deletemkcsid")
    @ResponseBody
    public int deletemkcsid(Integer mkcsid){

        ht_mk_soncourse_sectionService.deletemkcsid(mkcsid);
        ht_mk_fathercourse_sectionService.deletemkcsid(mkcsid);
        courseservice.deletecsid(mkcsid);


        return 1;
    }

    @RequestMapping("ht_mk_course/selectmkcsid")
    @ResponseBody
    public int selectmkcsid(String mkctitle){
        int coount=0;
        /* 获取职位 */
        int posid = (int) session.getAttribute("posid");
        if (posid == 2) {
            Map<String, Object> infos = (Map<String, Object>) session.getAttribute("infos");
            /* 员工讲师 标题 */
            coount= courseservice.selectmkcsid(mkctitle,null,(int) infos.get("mkuserid"));
        } else if (posid == 4) {
            /* 用户个人讲师 标题 */
            Map<String, Object> infoss = (Map<String, Object>) session.getAttribute("infoss");
            coount= courseservice.selectmkcsid(mkctitle,(int) infoss.get("mkuid"),null);
        } else {
            /* 经理查看全部 标题 */
            Map<String, Object> infos = (Map<String, Object>) session.getAttribute("infos");
            coount= courseservice.selectmkcsid(mkctitle,null,null);

        }

        return coount;
    }

}
