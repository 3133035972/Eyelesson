package com.eyelesson.service;

import com.eyelesson.dao.Ht_Mk_soncourse_sectionDao;
import com.eyelesson.entity.Mk_soncourse_section;
import com.eyelesson.util.PageDatas;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Ht_Mk_soncourse_sectionService {

    @Resource
    Ht_Mk_soncourse_sectionDao ht_mk_soncourse_sectionDao;
    /* 根据课程父级编号查询子章节的内容 */
    public PageDatas<Mk_soncourse_section> findmkfcsid(int page, int limit,Integer mkcsid, Integer mkfcsid){

        System.out.println("----------------:"+mkfcsid);
        
        PageHelper.startPage(page,limit);
        
        List<Mk_soncourse_section> findcourse =ht_mk_soncourse_sectionDao.findmkfcsid(mkcsid,mkfcsid);
        
        PageInfo<Mk_soncourse_section> pageInfo=new PageInfo<Mk_soncourse_section>(findcourse);
        
        PageDatas<Mk_soncourse_section> pd = new PageDatas<Mk_soncourse_section>();
        
        pd.setCurPage(page);//当前第几页
        
        pd.setPageSize(limit);//每页记录数
        
        pd.setTotalCount((int) pageInfo.getTotal());//总记录数
        
        pd.setTotalPage(pageInfo.getPages());//总共页数
        
        pd.setCount((int) pageInfo.getTotal());//总记录数
        
        pd.setData(findcourse);//当前页的数据
        
        return pd;

    }


    public int add(Mk_soncourse_section mk_soncourse_section){
        return ht_mk_soncourse_sectionDao.insert(mk_soncourse_section);
    }

    /* 用于子章节添加 */
    public Map<String,Object> findmkss(Integer mkcsid,Integer mkfcsid){
        return ht_mk_soncourse_sectionDao.findmkss(mkcsid,mkfcsid);
    }



    public List<Mk_soncourse_section> findss(Integer mkcsid){
        return ht_mk_soncourse_sectionDao.findss(mkcsid);
    }

    /* 删除子章节 */
    public int deletecstid(Integer mkcstid){
        return ht_mk_soncourse_sectionDao.deletecstid(mkcstid);
    }


    public int deletemkcsid(Integer mkcsid){
        return ht_mk_soncourse_sectionDao.deletemkcsid(mkcsid);
    }

    public int findcstcount(Integer mkfcsid,Integer mkcsid){
        return ht_mk_soncourse_sectionDao.findcstcount(mkfcsid,mkcsid);
    }


}
