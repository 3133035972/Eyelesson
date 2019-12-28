package com.eyelesson.service;

import com.eyelesson.dao.Mk_CurriculumDao;
import com.eyelesson.entity.Mk_Curriculum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Mk_CurriculumService {

    @Resource
    Mk_CurriculumDao mk_curriculumDao;


    /* 查询全部二级课程分类 */
    public List<Mk_Curriculum> selectAll(){
        return mk_curriculumDao.selectAll();
    }

}
