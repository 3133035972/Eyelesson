package com.eyelesson.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//当前时一个配置类
@EnableWebSecurity
//启用security的全局方法配置
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    //拦截请求配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //认证请求
        http.authorizeRequests()
                //只设置后台请求才能触发认证
                .antMatchers("/hou/**","/modules/**")
                //授权
                .authenticated()
                //条件连接
                .and()
                //使用自定义form表单登录
                .formLogin()
                //登录页面的路径
                .loginPage("/hou/login")
                //登录提交的地址,表单的提交路径和配置路径必须一直
                .loginProcessingUrl("/hou/loginSubmit")
                //登录成功默认跳转的地址,没有访问资源时
                .defaultSuccessUrl("/hou/loginSuccess")
                //登录失败的地址
                .failureUrl("/hou/loginError")
                //form表单对应的用户名属性名,默认必须使用username,password
                .usernameParameter("mkusername")
                .passwordParameter("mkupassword")
                //不进行认证
                .permitAll()
                .and()
                //配置退出
                .logout()
                //退出的地址
                .logoutUrl("/hou/loginOut")
                //退出成功的地址
                .logoutSuccessUrl("/hou/login")
                .and()
                //禁用csrf跨域请求
                .csrf()
                .disable();
        http.authorizeRequests().anyRequest().access("@permissionConfig.hasPermission(request,authentication)");
    }

    //配置不拦截的路径 后台的资源放行
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/ht/**","/res/**");
    }

    @Autowired
    AuthenticationProviderConfig authenticationProviderConfig;
    //认证管理配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //认证生成器
        auth.authenticationProvider(authenticationProviderConfig);
    }
}
