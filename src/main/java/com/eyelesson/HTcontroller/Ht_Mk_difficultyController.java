package com.eyelesson.HTcontroller;

import com.eyelesson.entity.Mk_difficulty;
import com.eyelesson.service.Mk_difficultyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("hou")
public class Ht_Mk_difficultyController {

    @Resource
    Mk_difficultyService mk_difficultyService;


    @RequestMapping("ht_Mk_difficulty/fiindAll")
    @ResponseBody
    public List<Mk_difficulty> findAll(){
        return mk_difficultyService.selectAll();
    }


}
