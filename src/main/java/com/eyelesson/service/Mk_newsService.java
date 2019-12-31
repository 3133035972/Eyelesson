package com.eyelesson.service;

import com.eyelesson.dao.Mk_newsDao;
import com.eyelesson.entity.Mk_news;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Mk_newsService {

    @Resource
    Mk_newsDao mkNewsDao;

    public int InsertMknews(Mk_news mk_news)
    {
        return mkNewsDao.insertSelective(mk_news);
    }
    //前往消息页面
    public List<Mk_news> listnews(int mkuid)
    {
        return mkNewsDao.listnews(mkuid);
    }
    //删除消息
    public int DeleteNews(int mknid)
    {
        return mkNewsDao.deleteByPrimaryKey(mknid);
    }
    //修改为已读状态
    public int UpdatenewsStatus(int mkuid)
    {
        return mkNewsDao.Newstatus(mkuid);
    }
    //未读消息
    public List<Mk_news> Unreadnews(int mkuid)
    {
        return mkNewsDao.Unreadnews(mkuid);
    }

}
