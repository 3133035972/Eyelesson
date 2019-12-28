package com.eyelesson.service;


import com.eyelesson.dao.MK_CurriculumtypeDao;
import com.eyelesson.entity.MK_Curriculumtype;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/* 课程一级分类表 */
@Service
public class MK_CurriculumtypeService {

    @Resource
    MK_CurriculumtypeDao mk_curriculumtypeDao;

    /* 查询全部一级分类和二级分类 */
    public List<MK_Curriculumtype> findAll(){
        return mk_curriculumtypeDao.findAll();
    }

    /* 查询全部一级课程分类 */
    public List<MK_Curriculumtype> selectAll(){
        return mk_curriculumtypeDao.selectAll();
    }


}
