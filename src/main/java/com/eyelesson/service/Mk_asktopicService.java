package com.eyelesson.service;

import com.eyelesson.dao.Mk_IpDAO;
import com.eyelesson.dao.Mk_asktopicDao;
import com.eyelesson.entity.Mk_Ip;
import com.eyelesson.entity.Mk_answertopic;
import com.eyelesson.entity.Mk_asktopic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Mk_asktopicService {

    @Resource
    Mk_asktopicDao mkAsktopicDao;
    @Resource
    Mk_IpDAO mkIpDAO;

    //插入问题
    public  int insertasktop(Mk_asktopic mkAsktopic)
    {
        return mkAsktopicDao.insertSelective(mkAsktopic);
    }

    //查看详细的笔记
    //根据详细的笔记来查询这个ip存在不存在 不存在 添加到ip表 然后增加访问量 存在就不加访问量
    public Map<String,Object> nodes(int mktapid)
    {

        //获取用户的ip
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String hostAddress = address.getHostAddress();
        Mk_Ip ip = mkAsktopicDao.findIp(mktapid, hostAddress);
        if(ip==null)
        {
            //添加到数据库中
            Mk_Ip mkIp=new Mk_Ip();
            mkIp.setIp(hostAddress);
            mkIp.setMkatpid(mktapid);
            //添加到数据库中
            mkIpDAO.insert(mkIp);
            mkAsktopicDao.UpdateMkapreview(mktapid);
        }

        return mkAsktopicDao.notes(mktapid);
    }

    //查看前5个相关问题
    public List<Mk_asktopic> limit5(int mkcstid)
    {
        return mkAsktopicDao.limit5(mkcstid);
    }

    public List<Mk_answertopic> listanswert(int mkatpid)
    {
        List<Mk_answertopic> listanswer = mkAsktopicDao.listanswer(mkatpid);
        List<Mk_answertopic> treelist=node(listanswer);
        return treelist;
    }

    //查询某个问题下面的所有问答
    public List<Mk_answertopic> node(List<Mk_answertopic> lists)
    {
        List<Mk_answertopic> rslist=new ArrayList<Mk_answertopic>();
        for(Mk_answertopic mk:lists)
        {
            List<Mk_answertopic> listzi = mkAsktopicDao.listzi(mk.getMkantid());
            if(listzi.size()>0)
            {
                mk.setChildren(listzi);
                List<Mk_answertopic> node = node(listzi);
            }
            else
            {
                mk.setChildren(null);
            }
            rslist.add(mk);
        }

        return rslist;
    }
}
