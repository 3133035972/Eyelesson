package com.eyelesson.service;

import com.eyelesson.dao.Mk_difficultyDao;
import com.eyelesson.entity.Mk_difficulty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Mk_difficultyService {

    @Resource
    Mk_difficultyDao mk_difficultyDao;

    public List<Mk_difficulty> selectAll(){
        return mk_difficultyDao.selectAll();
    }
}
