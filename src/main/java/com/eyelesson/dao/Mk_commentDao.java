package com.eyelesson.dao;

import com.eyelesson.entity.Mk_comment;
import tk.mybatis.mapper.common.Mapper;


public interface Mk_commentDao extends Mapper<Mk_comment> {

    //发布评论
    int InsertComment(Mk_comment mkComment);

}
