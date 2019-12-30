package com.eyelesson.HTcontroller;

import com.eyelesson.entity.Mk_Wheelplanting;
import com.eyelesson.service.Mk_WheelplantingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("ht_mk_wheelplanting")
public class Ht_Mk_wheelplantingController {

    @Resource
    Mk_WheelplantingService mk_wheelplantingService;

    @RequestMapping("kmshow")
    public String Show(){
        return "mk_wheelplantingShow";
    }

    @RequestMapping("show")
    @ResponseBody
    public Map show(Model model) {
        List<Map<String,Object>> mk_wheelplanting =mk_wheelplantingService.queryAll();
        System.out.println("mk_wheelplanting = " + mk_wheelplanting);
        model.addAttribute("Mk_wheelplanting",mk_wheelplanting);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("count",100);
        map.put("data", mk_wheelplanting);
        return map;
    }

    @RequestMapping("add")
    public String add(Model model){

        model.addAttribute("list",mk_wheelplantingService.findA());

        System.out.println(" = " +mk_wheelplantingService.findA());

        return "/hts/mk_wheelplanting/mk_wheelplantingAdd";
    }


    @RequestMapping("mkAdd")
    @ResponseBody
    public int Add(Mk_Wheelplanting mk_wheelplanting){
        return mk_wheelplantingService.add(mk_wheelplanting);
    }



    @RequestMapping("Delete")
    @ResponseBody
    public int Delete(Integer mkwpid){
        return mk_wheelplantingService.del(mkwpid);
    }


    @RequestMapping("update")
    public String update(Integer mkwpid ,Model model){
        model.addAttribute("one",mk_wheelplantingService.selectOne(mkwpid));
        model.addAttribute("list",mk_wheelplantingService.findA());
        return "/hts/mk_wheelplanting/mk_wheelplantingUpdate";
    }


    @RequestMapping("mkUpdate")
    @ResponseBody
    public int Update(Mk_Wheelplanting mk_wheelplanting){
        return mk_wheelplantingService.upd(mk_wheelplanting);
    }



}
