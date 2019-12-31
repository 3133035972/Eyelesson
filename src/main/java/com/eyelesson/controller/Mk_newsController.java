package com.eyelesson.controller;

import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.Mk_news;
import com.eyelesson.service.Mk_newsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("qt")
public class Mk_newsController {

    @Resource
    HttpSession session;
    @Resource
    Mk_newsService mkNewsService;

    @RequestMapping("Message")
    public String Message(Model model)
    {
        Mk_Use m= (Mk_Use) session.getAttribute("msgss");
        List<Mk_news> listnews = mkNewsService.listnews(m.getMkuid());
        List<Mk_news> Unreadnews=mkNewsService.Unreadnews(m.getMkuid());
        model.addAttribute("listnews",listnews);
        model.addAttribute("Unreadnews",Unreadnews);
        return "Message";
    }
    //删除消息
    @RequestMapping("DeleteNews")
    @ResponseBody
    public int DeleteNews(int mknid)
    {
        return mkNewsService.DeleteNews(mknid);
    }
    //修改消息为已读状态
    @RequestMapping("NewsStatu")
    @ResponseBody
    public int UpdateNewsStatus()
    {
        Mk_Use m= (Mk_Use) session.getAttribute("msgss");
        session.removeAttribute("news");
        return mkNewsService.UpdatenewsStatus(m.getMkuid());
    }

}
