package com.eyelesson.service;


import com.eyelesson.dao.Ht_Mk_fathercourse_sectionDao;
import com.eyelesson.entity.Mk_fathercourse_section;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Ht_Mk_fathercourse_sectionService {


    @Resource
    Ht_Mk_fathercourse_sectionDao ht_mk_fathercourse_sectionDao;

    public int add(Mk_fathercourse_section mk_fathercourse_section){
        return ht_mk_fathercourse_sectionDao.insert(mk_fathercourse_section);
    }
    /* 根据课程id  父章节标题 章节内容查询父章节id */
    public Integer findMkfcsid(Mk_fathercourse_section mk_fathercourse_section){
        return ht_mk_fathercourse_sectionDao.findMkfcsid(mk_fathercourse_section);
    }

    /* 根据课程编号查询 */
    public List<Mk_fathercourse_section> findmf(Integer mkcsid){
        return ht_mk_fathercourse_sectionDao.findmf(mkcsid);
    }



    /* 查询父章节id */
    public Integer fincount(Mk_fathercourse_section mk_fathercourse_section){
        return ht_mk_fathercourse_sectionDao.fincount(mk_fathercourse_section);
    }

    /* 查询父章节id2 */
    public Integer fincountTie(Mk_fathercourse_section mk_fathercourse_section){
        return ht_mk_fathercourse_sectionDao.fincountTie(mk_fathercourse_section);
    }


    public int deletemkcsid(Integer mkcsid){
        return ht_mk_fathercourse_sectionDao.deletemkcsid(mkcsid);
    }


    public int deletemkfcsid(Integer mkfcsid,Integer mkcourseid){
        return ht_mk_fathercourse_sectionDao.deletemkfcsid(mkfcsid,mkcourseid);
    }

}
