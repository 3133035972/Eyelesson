package com.eyelesson.service;

import com.eyelesson.dao.Mk_IpDAO;
import com.eyelesson.dao.Mk_asktopicDao;
import com.eyelesson.dao.Mk_newsDao;
import com.eyelesson.entity.Mk_Ip;
import com.eyelesson.entity.Mk_answertopic;
import com.eyelesson.entity.Mk_asktopic;
import com.eyelesson.entity.Mk_news;
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
    @Resource
    Mk_newsService mkNewsService;

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

    //回答这个问题
    public int InsertAnswer(Mk_answertopic mkAnswertopic)
    {
        Mk_news mkNews=new Mk_news();
        mkNews.setMkhairuid(mkAnswertopic.getMkuid());
        mkNews.setMkcollectuid(mkAnswertopic.getNodeuid());
        mkNews.setMknecontent("你在"+mkAnswertopic.getMkatitle()+"下的问题被回复了");
        mkNewsService.InsertMknews(mkNews);
        return mkAsktopicDao.InsertAnswer(mkAnswertopic);
    }
    //回复的回复
    public int InsertAnAnswer(Mk_answertopic mkAnswertopic)
    {
        //根据这个id查询出在这个表里的
        Mk_answertopic mkantid = mkAsktopicDao.findMkantid(mkAnswertopic.getMkaid());
        Mk_news mkNews=new Mk_news();
        mkNews.setMknecontent("你在"+mkantid.getMkatitle()+"下的问题被回复了");
        mkNews.setMkcollectuid(mkantid.getMkuid());
        mkNews.setMkhairuid(mkAnswertopic.getMkuid());
        mkNewsService.InsertMknews(mkNews);
        Integer mknum = mkAsktopicDao.mknum(mkAnswertopic.getMkatpid());
        if(mknum!=null)
        {
            mkAnswertopic.setMkanum(mknum);
            return mkAsktopicDao.InsertAnswer(mkAnswertopic);
        }
        return 0;
    }

    public List<Mk_answertopic> listanswert(int mkatpid)
    {
        //父节点 mkaid 0
        List<Mk_answertopic> listanswer = mkAsktopicDao.listanswer(mkatpid);
        //下面这个步骤肯定是错误的
        List<Mk_answertopic> treelist=node(listanswer);
        //打的回复的顺序
        String str = "";
        String a=a(listanswer,str);
        if(a!="")
        {
            //截取字符串最后一个字符
            //获取该章节下的回复
            //最后页面渲染这个数据
            String b=a.substring(0,a.length()-1);
            return mkAsktopicDao.listall(b);
        }
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
    //这个是对的

    //获取这个父回复的所有的子回复
    public String a(List<Mk_answertopic> lists,String str)
    {
        List<Mk_answertopic> rslist=new ArrayList<Mk_answertopic>();
        for(Mk_answertopic mk:lists)
        {
            str += mk.getMkantid() +",";
            List<Mk_answertopic> listzi = mkAsktopicDao.listzi(mk.getMkantid());
            if(listzi.size()>0)
            {
                mk.setChildren(listzi);
                str= a(listzi, str);
            }
            else
            {
                mk.setChildren(null);
            }
            rslist.add(mk);
        }
        return str;
    }

    public List<Mk_answertopic> findAll(String stra)
    {
        return mkAsktopicDao.findAll(stra);
    }
}
