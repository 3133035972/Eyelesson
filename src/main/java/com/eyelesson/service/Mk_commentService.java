package com.eyelesson.service;

import com.eyelesson.dao.Mk_commentDao;
import com.eyelesson.entity.Mk_comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Mk_commentService {

    @Resource
    Mk_commentDao mkCommentDao;

    //插入评论
    public int InsertCommet(Mk_comment mkComment)
    {
        return mkCommentDao.insertSelective(mkComment);
    }

}
