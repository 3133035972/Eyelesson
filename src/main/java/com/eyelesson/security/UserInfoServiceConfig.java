package com.eyelesson.security;

import com.eyelesson.entity.Mk_Use;
import com.eyelesson.entity.Mk_UserInfo;
import com.eyelesson.service.Ht_UserInfoService;
import com.eyelesson.service.Mk_UseService;
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
import java.util.Map;

//用户详细信息配置类:获取用户真实详细信息
@Component
public class UserInfoServiceConfig implements UserDetailsService {

    @Resource
    Ht_UserInfoService htUserInfoService;

    @Resource
    Mk_UseService mk_useService;

    @Autowired
    HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        System.out.println("进入UsersServiceConfig");

        System.out.println("获取的username："+s);

        //根据用户名回去用户信息

        Mk_UserInfo user=htUserInfoService.findByUname(s);

        /*System.out.println("555:"+user);*/

        if (user!=null){

        /*System.out.println(user.getMkupassword());*/

        //2.根据用户名查询  显示对应的职位和员工名称在后台首页
        Map<String, Object> infos = htUserInfoService.findPosAndEmpNameByUserName(s);

        System.out.println("ininfos"+infos);

        session.setAttribute("infos", infos);

        System.out.println("session======>"+session.getAttribute("infos"));

            if(null!=user)
            {
                List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

                //根据用户的名称去查询职位的编号


                Integer posid = htUserInfoService.PosId(s);

                //将posid存到session中 方便在controller中获取

                session.setAttribute("posid",posid);

                System.out.println("session:"+session.getAttribute("posid"));

                String role=posid.toString();

                System.out.println("ad"+role);

                //获取对应的权限
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);

                return new User(user.getMkusername(),user.getMkupassword(), list);
            }


            }else {

            Mk_Use mk_use = mk_useService.selectUse(s);

            /*System.out.println(user.getMkupassword());*/

            //2.根据用户名查询  显示对应的职位和员工名称在后台首页
            Map<String, Object> infoss = htUserInfoService.findPosAndUseNameByUserName(s);

            System.out.println("ininfos" + infoss);

            session.setAttribute("infoss", infoss);

            System.out.println("session======>" + session.getAttribute("infoss"));

            if (null != mk_use) {

                List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

                //根据用户的名称去查询职位的编号
                Integer posid = htUserInfoService.PosIdPhone(s);

                //将posid存到session中 方便在controller中获取

                session.setAttribute("posid", posid);

                System.out.println("session====:" + session.getAttribute("posid"));

                String role = posid.toString();

                System.out.println("ad==:" + role);

                //获取对应的权限
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
                
                System.out.println("grantedAuthority==:"+grantedAuthority);
                
                return new User(mk_use.getMkuphone(),mk_use.getMkupassword(), list);


            }

        }
        return null;
    }
}
