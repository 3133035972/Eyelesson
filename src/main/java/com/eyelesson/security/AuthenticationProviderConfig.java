package com.eyelesson.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

//认证生成器:生成身份信息
@Component
public class AuthenticationProviderConfig  implements AuthenticationProvider {

    @Autowired
    UserInfoServiceConfig userInfoServiceConfig;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取身份名称(表单提交的用户名)
        String name=authentication.getName();
        //获取凭证
        Object credentials = authentication.getCredentials();
        //根据用户名获取用户的真实用户信息
        UserDetails userDetails = userInfoServiceConfig.loadUserByUsername(name);
        if(userDetails==null)
        {
            //抛出没有用户的异常
            return null;
        }
        else
        {
            //判断密码
            if(userDetails.getPassword().equals(credentials)){
                //认证成功
                return new UsernamePasswordAuthenticationToken(userDetails,userDetails.getPassword(),userDetails.getAuthorities());
            }
        }
        //抛出密码错误异常
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
