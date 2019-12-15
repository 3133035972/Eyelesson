package com.eyelesson.security;

import com.eyelesson.entity.Mk_UserInfo;
import com.eyelesson.service.Ht_UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//用户详细信息配置类:获取用户真实详细信息
@Component
public class UserInfoServiceConfig implements UserDetailsService {

    @Resource
    Ht_UserInfoService htUserInfoService;

    @Autowired
    HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名回去用户信息
        Mk_UserInfo user=htUserInfoService.findByUname(s);
        if(null!=user)
        {
            List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

            //根据用户的名称去查询职位的编号
            Integer posid = htUserInfoService.PosId(s);
            //将posid存到session中 方便在controller中获取
            session.setAttribute("posid",posid);
            String role=posid.toString();
            //获取对应的权限
            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            return new User(user.getMkusername(),user.getMkupassword(), list);
        }
        return null;
    }
}
