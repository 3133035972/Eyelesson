package com.eyelesson.controller;

import com.eyelesson.service.Mk_FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class Mk_FabulousController {

    @Autowired
    Mk_FavoritesService mkFavoritesService;

    //笔记点赞
    @RequestMapping("NoteFavor")
    @ResponseBody
    public int updateFavor(int mknid,int mkuid)
    {
        System.out.println(mknid);
        return mkFavoritesService.UpdateFavorites(mknid, mkuid);
    }
    //评论点赞
    @RequestMapping("PingFavor")
    @ResponseBody
    public int updatepFavor(int mkuid,int mkcmid)
    {
        return mkFavoritesService.UpdayeFav(mkuid,mkcmid);
    }

    @RequestMapping("1")
    public String show()
    {
        return "1";
    }

}
