package com.eyelesson.dao;


import com.eyelesson.entity.Mk_order;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface Mk_OrderDao extends Mapper<Mk_order> {

    //查询这个用户下面的所有订单
    @Select("select mko.*,mkco.mkcimg,mkco.mkctitle from mk_order mko\n" +
            "left join mk_course mkco \n" +
            "on mko.mkcsid=mkco.mkcsid where mko.mkuid=#{param1} and mko.mkodel=0\n" +
            "order by mko.mkoctime desc")
    List<Mk_order> findAll(int mkuid);
    //查询这个用户下面已经成功的订单
    @Select("select mko.*,mkco.mkcimg,mkco.mkctitle from mk_order mko\n" +
            "left join mk_course mkco \n" +
            "on mko.mkcsid=mkco.mkcsid where mko.mkuid=#{param1} and mko.mkostate=1 and mko.mkodel=0\n" +
            "order by mko.mkoctime desc")
    List<Mk_order> findsucessorder(int mkuid);
    //未支付的订单
    @Select("select mko.*,mkco.mkcimg,mkco.mkctitle from mk_order mko\n" +
            "left join mk_course mkco \n" +
            "on mko.mkcsid=mkco.mkcsid where mko.mkuid=#{param1} and mko.mkostate=0 and mko.mkodel=0\n" +
            "order by mko.mkoctime desc")
    List<Mk_order>finderror(int mkuid);
    //失效的订单
    @Select("select mko.*,mkco.mkcimg,mkco.mkctitle from mk_order mko\n" +
            "left join mk_course mkco \n" +
            "on mko.mkcsid=mkco.mkcsid where mko.mkuid=#{param1} and mko.mkostate=3 and mko.mkodel=0\n" +
            "order by mko.mkoctime desc")
    List<Mk_order>InvalidOrder(int mkuid);
    //消费的金钱以及个数
    @Select("select count(mko.mkoid) count ,sum(mko.mkomoney) totalmoney from mk_order mko\n" +
            "left join mk_course mkco \n" +
            "on mko.mkcsid=mkco.mkcsid \n" +
            "where mko.mkuid=#{param1} and mko.mkostate=1")
    Mk_order outmoney(int mkuid);
    //查询出已经删除的订单
    @Select("select mko.*,mkco.mkcimg,mkco.mkctitle from mk_order mko\n" +
            "left join mk_course mkco \n" +
            "on mko.mkcsid=mkco.mkcsid where mko.mkuid=#{param1} and mko.mkodel=1\n" +
            "order by mko.mkoctime desc")
    List<Mk_order> deletelist(int mkuid);
}
