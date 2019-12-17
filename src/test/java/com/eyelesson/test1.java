package com.eyelesson;

import com.eyelesson.entity.Mk_Note;
import com.eyelesson.entity.Mk_fathercourse_section;
import com.eyelesson.entity.Mk_soncourse_section;
import com.eyelesson.service.Mk_NoteService;
import com.eyelesson.service.ModulesService;
import com.eyelesson.service.mk_courseservice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@SpringBootTest
public class test1 {

    @Resource
    mk_courseservice mkCourseservice;

    @Resource
    ModulesService modulesService;

    @Resource
    Mk_NoteService mkNoteService;

    @Test
    public void test1()
    {
        List<Mk_fathercourse_section> allfu = mkCourseservice.Allfu(1);

        for(Mk_fathercourse_section mk:allfu)
        {
            List<Mk_soncourse_section> allzi=mkCourseservice.findzi(mk.getMkfcsid());
            mk.setChildrens(allzi);
        }
    }
    @Test
    public void test3()
    {
        System.out.println(modulesService.getTree(1));
    }
    @Test
    public void test4()
    {
        System.out.println(mkCourseservice.wenAll(1,1,5));
    }

    @Test
    public void test5()
    {
        Mk_Note mkNote=new Mk_Note();
        mkNote.setMknotecontent("111");
        mkNote.setMkuid(1);
        mkNote.setMkcsid(1);
        System.out.println(mkNoteService.Insert(mkNote));
    }
    @Test
    public void test6()
    {
        //获取用户的ip
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String hostAddress = address.getHostAddress();
        System.out.println(hostAddress);
    }
}
