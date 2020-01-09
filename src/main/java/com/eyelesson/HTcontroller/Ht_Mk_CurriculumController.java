package com.eyelesson.HTcontroller;


import com.eyelesson.entity.Mk_Curriculum;
import com.eyelesson.service.Mk_CurriculumService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("hou")
public class Ht_Mk_CurriculumController {

    @Resource
    Mk_CurriculumService mk_curriculumService;


    @RequestMapping("ht_Mk_Curriculum/findct")
    @ResponseBody
    public List<Mk_Curriculum> findct(Integer mkctid){

        return mk_curriculumService.selectct(mkctid);
    }


}
