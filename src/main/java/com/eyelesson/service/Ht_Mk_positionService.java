package com.eyelesson.service;

import com.eyelesson.dao.Ht_Mk_positionDao;
import com.eyelesson.entity.Mk_position;
import com.eyelesson.util.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Ht_Mk_positionService {

    @Resource
    Ht_Mk_positionDao ht_mk_positionDao;

    /* 查询全部 */
    public List<Mk_position>  queryAll(){
        return ht_mk_positionDao.queryAll();
    }


    /* 分页查询 */
    public PageData queryAllfy(int page, int limit){
        PageHelper.startPage(page,limit);

        PageInfo<Mk_position> pageInfo = new PageInfo<Mk_position>(queryAll()) ;

        PageData pageData = new PageData(pageInfo.getPageNum(),pageInfo.getSize(), (int) pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList());

        return pageData;

    }



}
