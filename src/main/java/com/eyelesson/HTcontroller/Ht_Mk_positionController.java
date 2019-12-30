package com.eyelesson.HTcontroller;

import com.eyelesson.entity.Mk_position;
import com.eyelesson.service.Ht_Mk_positionService;
import com.eyelesson.util.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ht_mk_position")
public class Ht_Mk_positionController {

    @Resource
    Ht_Mk_positionService ht_mk_positionService;


    @RequestMapping("queryAll")
    @ResponseBody
    public PageData queryAllfy(int page, int limit){
        System.out.println(ht_mk_positionService.queryAllfy(page,limit));
        return ht_mk_positionService.queryAllfy(page,limit);
    }


}
