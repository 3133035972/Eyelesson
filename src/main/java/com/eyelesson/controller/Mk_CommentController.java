package com.eyelesson.controller;

import com.eyelesson.entity.Mk_comment;
import com.eyelesson.service.Mk_commentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class Mk_CommentController {

    @Resource
    Mk_commentService mkCommentService;

    //插入评论
    @RequestMapping("InsertComment")
    public int InsertComment(Mk_comment mkComment)
    {
        return mkCommentService.InsertCommet(mkComment);
    }

}
