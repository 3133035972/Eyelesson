package com.eyelesson.HTcontroller;

import com.eyelesson.entity.Mk_soncourse_section;
import com.eyelesson.service.Ht_Mk_fathercourse_sectionService;
import com.eyelesson.service.Ht_Mk_soncourse_sectionService;
import com.eyelesson.service.mk_courseservice;
import com.eyelesson.util.PageDatas;
import com.eyelesson.util.ReadVideoTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("hou")
public class Ht_Mk_soncourse_sectionController {


    @Resource
    mk_courseservice courseservice;
    @Resource
    Ht_Mk_soncourse_sectionService ht_mk_soncourse_sectionService;
    @Resource
    Ht_Mk_fathercourse_sectionService ht_mk_fathercourse_sectionService;

    /* 根据课程父级编号查询子章节的内容 */
    @RequestMapping("ht_mk_soncourse_section/findmkfcsid")
    public String findmkfcsid(Integer mkcsid,Integer mkfcsid, HttpSession session){
        //查询子章节的内容
        System.out.println("----------------:"+mkfcsid);
        //List<Mk_soncourse_section> findmkfcsid = ht_mk_soncourse_sectionService.findmkfcsid(mkfcsid);
        session.setAttribute("mkcsid",mkcsid);
        session.setAttribute("mkfcsid",mkfcsid);
        //System.out.println("findmkfcsid = " + findmkfcsid);
        return "hts/mk_soncourse_section/Mk_soncourse_sectionShow";
    }




    /* 根据课程父级编号查询子章节的内容 */
    @RequestMapping("ht_mk_soncourse_section/findmkfcsidshow")
    @ResponseBody
    public PageDatas<Mk_soncourse_section> findmkfcsidshow(int page, int limit,HttpSession session){
        //查询子章节的内容
        System.out.println("moomom-----:"+session.getAttribute("mkfcsid"));
        System.out.println("momomom------:"+session.getAttribute("mkcsid"));
        PageDatas<Mk_soncourse_section> findmkfcsid = ht_mk_soncourse_sectionService.findmkfcsid(page,limit,(Integer)session.getAttribute("mkcsid"),(Integer)session.getAttribute("mkfcsid"));

        System.out.println("findmkfcsid = " + findmkfcsid);
        return findmkfcsid;
    }


    @RequestMapping("ht_mk_soncourse_section/deletemkcstid")
    @ResponseBody
    public int deletemkcstid(Integer mkcsid,Integer mkcstid,Integer mkfcsid){

        ReadVideoTime readVideoTime = new ReadVideoTime();

        int deletecstid = ht_mk_soncourse_sectionService.deletecstid(mkcstid);

        int findcstcount = ht_mk_soncourse_sectionService.findcstcount(mkfcsid, mkcsid);

        System.out.println("findcstcount = " + findcstcount);

        if (findcstcount==0){
            System.out.println("mkfcsid = " + mkfcsid);


            int deletemkfcsid = ht_mk_fathercourse_sectionService.deletemkfcsid(mkfcsid, mkcsid);
            System.out.println("deletemkfcsid = " + deletemkfcsid);
        }


        /* 获取当前课程的总时长 */
        List<Mk_soncourse_section> findss = ht_mk_soncourse_sectionService.findss(mkcsid);
        String s = readVideoTime.VideoTotal(findss.size(), findss);
        System.out.println("mkcsidmkcsid:"+mkcsid);
        System.out.println("sssssssssss:"+s);
        /* 修改课程时长 */
        courseservice.updateTile(s, mkcsid);

        return  deletecstid;

    }



}

