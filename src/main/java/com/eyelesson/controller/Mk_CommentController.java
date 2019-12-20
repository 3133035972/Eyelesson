package com.eyelesson.controller;

import com.eyelesson.entity.Mk_comment;
import com.eyelesson.service.Mk_commentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("Mk_Comment")
public class Mk_CommentController {

    @Resource
    Mk_commentService mkCommentService;

    //插入评论
    @RequestMapping("InsertComment")
    @ResponseBody
    public int InsertComment(Mk_comment mkComment)
    {
        return mkCommentService.InsertCommet(mkComment);
    }

}
