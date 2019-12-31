package com.eyelesson.service;

import com.eyelesson.dao.Mk_OrderDao;
import com.eyelesson.entity.Mk_order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Mk_OrderService {

    @Resource
    Mk_OrderDao mk_orderDao;

    //查询这个用户下面的所有订单
    public List<Mk_order> findAll(int mkuid)
    {
        return  mk_orderDao.findAll(mkuid);
    }
    //成功的
    public List<Mk_order> findsucess(int mkuid)
    {
        return mk_orderDao.findsucessorder(mkuid);
    }
    //支付失败的
    public  List<Mk_order> finderror(int mkuid)
    {
        return mk_orderDao.finderror(mkuid);
    }
    //失效的
    public List<Mk_order> InvalidOrder(int mkuid)
    {
        return mk_orderDao.InvalidOrder(mkuid);
    }
    //消费记录
    public Mk_order mkOrder(int mkuid)
    {
        return mk_orderDao.outmoney(mkuid);
    }
    //删除记录
    public List<Mk_order> listdel(int mkuid)
    {
        return mk_orderDao.deletelist(mkuid);
    }
}
