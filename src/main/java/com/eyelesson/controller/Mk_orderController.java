package com.eyelesson.controller;

import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.Mk_order;
import com.eyelesson.service.Mk_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("qt")
public class Mk_orderController {

    @Autowired
    Mk_OrderService mk_orderService;

    @Autowired
    HttpSession session;
    //查询全部
    @RequestMapping("orderAll")
    public String orderAll(Model model)
    {
        Mk_Use m= (Mk_Use) session.getAttribute("msgss");
        List<Mk_order> orderall = mk_orderService.findAll(1);
        //成功
        List<Mk_order> success = mk_orderService.findsucess(1);
        //失败
        List<Mk_order> error = mk_orderService.finderror(1);
        //失效
        List<Mk_order> inval = mk_orderService.InvalidOrder(1);
        //消费记录
        Mk_order mk_order=mk_orderService.mkOrder(1);
        //删除订单的记录
        List<Mk_order> listdel = mk_orderService.listdel(1);
        System.out.println("mk_order"+listdel);
        model.addAttribute("success",success);
        model.addAttribute("error",error);
        model.addAttribute("inval",inval);
        model.addAttribute("orderall",orderall);
        model.addAttribute("totalmoney",mk_order);
        model.addAttribute("listdel",listdel);
        return "Ordercenter";
    }

}
