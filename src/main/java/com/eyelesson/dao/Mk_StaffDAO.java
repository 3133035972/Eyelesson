package com.eyelesson.dao;


import com.eyelesson.entity.Mk_Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/* 员工表 */
@Mapper
public interface Mk_StaffDAO extends tk.mybatis.mapper.common.Mapper<Mk_Staff> {


    //查询员工分页模糊查询
    List<Map<String,Object>> query(String param, Integer posId, String startTime, String endTime);

    //添加员工信息
    @Insert("insert into mk_staff(mksname,mksex,mksbirthday,mksidcard,mksphone,mksaddress,mkschool,mkskill,mkposid)\n" +
            "values(#{mksname},#{mksex},NEW(),#{mksidcard},#{mksphone},#{mksaddress},#{mkschool},#{mkskill},#mkposid{})")
    int addStaff(Mk_Staff mk_staff);


    //查询出最新添加的员工编号
    @Select("select max(mksid) from mk_staff")
    List<String> findNewStaffId();

    //查询出员工讲师关注量最多的5位员工
    @Select("select * from mk_staff order by mksfollowcount desc limit 0,5")
    List<Mk_Staff> findfive();

}
