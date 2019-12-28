package com.eyelesson.service;


import com.eyelesson.dao.Mk_StaffDAO;
import com.eyelesson.entity.Mk_Staff;
import com.eyelesson.util.PageData;
import com.eyelesson.util.PageEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class Mk_StaffService {


    @Resource
    Mk_StaffDAO mk_staffDAO;



    //分页显示
    public PageData pageQuery(int page, int limit, String param,
                              Integer mkpid, String startTime, String  endTime){
        PageHelper.startPage(page,limit);
        List<Map<String, Object>> emps = mk_staffDAO.query(param,mkpid,startTime,endTime);

        PageInfo pageInfo = new PageInfo(emps) ;

        PageData pageData = new PageData(pageInfo.getPageNum(),pageInfo.getSize(), (int) pageInfo.getTotal(),pageInfo.getPages(),pageInfo.getList());

        return pageData;

    }

    //添加员工
    public int addStaff(Mk_Staff mk_staff){
        return mk_staffDAO.addStaff(mk_staff);
    }

    //查询出最新添加的员工编号
    public List<String> findNewEmpId(){
        return mk_staffDAO.findNewStaffId();
    }


    //删除  离职员工  更改员工状态为1
    public int delEmp(Integer mksid){
        return mk_staffDAO.deleteByPrimaryKey(mksid);
    }

    //修改员工信息
    public int updateEmp(Mk_Staff mk_staff){
        return mk_staffDAO.updateByPrimaryKey(mk_staff);
    }


    //修改员工信息并显示
    public PageEntity updateShowEmp(String mksid){
        PageEntity pageEntity = new PageEntity();
        pageEntity.setData(mk_staffDAO.selectByPrimaryKey(mksid));
        return pageEntity;
    }

    //查询出员工讲师关注量最多的5位员工
    public List<Mk_Staff> findfive(){
        return mk_staffDAO.findfive();
    }


}
