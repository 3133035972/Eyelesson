package com.eyelesson.service;


import com.eyelesson.dao.PosModulesDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PosModulesService {
    @Resource
    PosModulesDAO posModulesDAO;
    //根据职务编号查询对应的菜单执行路径
    public List<String> findUrlByPosId(Integer posId){
        return posModulesDAO.findUrlByPosId(posId);
    }
}
