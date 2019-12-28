package com.eyelesson.service;

import com.eyelesson.dao.Mk_newsDao;
import com.eyelesson.entity.Mk_news;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Mk_newsService {

    @Resource
    Mk_newsDao mkNewsDao;

    public int InsertMknews(Mk_news mk_news)
    {
        return mkNewsDao.insertSelective(mk_news);
    }

}
