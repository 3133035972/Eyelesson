package com.eyelesson.service;


import com.eyelesson.dao.PermissionDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionService {
    @Resource
    PermissionDAO permissionDAO;

    //根据职务编号查询对应的权限
    public List<String> findPermissionByPosId(Integer posId){
        return permissionDAO.findPermissionByPosId(posId);
    }
}
