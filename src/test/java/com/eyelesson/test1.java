package com.eyelesson;

import com.eyelesson.entity.Mk_fathercourse_section;
import com.eyelesson.entity.Mk_soncourse_section;
import com.eyelesson.service.ModulesService;
import com.eyelesson.service.mk_courseservice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class test1 {

    @Resource
    mk_courseservice mkCourseservice;

    @Resource
    ModulesService modulesService;

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
    public void test2()
    {
        System.out.println(mkCourseservice.OneNoteImg(1));
    }
    @Test
    public void test3()
    {
        System.out.println(modulesService.getTree(1));
    }

}
