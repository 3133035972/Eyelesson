package com.eyelesson.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

@Configuration
//当前时一个配置类
@EnableWebSecurity
//启用security的全局方法配置
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    //拦截请求配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 解决跨域
        http.headers().frameOptions().disable();

        //设置权限 只在这些路径下面进行权限的设置和访问
        http.authorizeRequests()//只设置后台请求才能触发认证
                .antMatchers("/hou/**","/modules/**","/ht_mk_course/**","/ht_mk_wheelplanting/**").access("@permissionConfig.hasPermission(request,authentication)").and().csrf().disable();

        //先认证再授权
        // 认证请求  对于请求要进行身份认证
        http.authorizeRequests()
                // 所有请求  都需要进行身份认证
                .anyRequest()
                // 授权
                .authenticated()
                // 用于条件的拼接
                .and()
                // 使用自定义form表单进行登录
                .formLogin()
                // 登录页面的路径
                .loginPage("/hou/login")
                // 登录提交的地址,表单的提交路径和配置的路径一致  而这个路径在controller中是否真的存在无所谓
                //如果真的存在这个路径的话，访问这个路径不代表登录成功，仅仅是需要提交路径而已
                .loginProcessingUrl("/hou/loginSubmit")
                // 登录成功默认跳转的地址,在没有访问资源时才会跳转  就是你没有访问的其他路径被拦截的时候（直接访问登录进行登录而登录成功的路径）
                //如果要是在访问其他路径被拦截到登录页面，则登录成功之后会直接跳转到登录之前访问的路径
                /*.defaultSuccessUrl("/back/views/index.html")*/
                .defaultSuccessUrl("/hou/loginSuccess",true)
                //.successHandler(new ForwardAuthenticationSuccessHandler("/back/views/index.html"))
                // 失败的地址
                .failureUrl("/hou/loginError")
                // form表单对应的用户名属性名，默认必须使用username,password
                .usernameParameter("mkusername")
                .passwordParameter("mkupassword")
                // 不进行认证
                .permitAll()
                .and()
                //禁用csrf跨域请求
                .csrf()
                .disable();


        //定制退出
        http.logout()
                //.logoutUrl("/sys/doLogout")  //只支持定制退出url
                //支持定制退出url以及httpmethod
                .logoutRequestMatcher(new AntPathRequestMatcher("/hou/loginOut", "GET"))
                .addLogoutHandler((request,response,authentication) -> System.out.println("=====1====="))
                .addLogoutHandler((request,response,authentication) -> System.out.println("=====2======"))
                .addLogoutHandler((request,response,authentication) -> System.out.println("=====3======"))
                .logoutSuccessHandler(((request, response, authentication) -> {
                    System.out.println("=====4=======");
                    response.sendRedirect("/hou/login");
                }))
                //.logoutSuccessUrl("/html/logoutsuccess2.html")  //成功退出的时候跳转的页面
                //.deleteCookies()  //底层也是使用Handler实现的额
                //清除认证信息
                .clearAuthentication(true)
                .invalidateHttpSession(true)
        ;  //使session失效




        /*//认证请求
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
                .disable();*/




    }

    @Autowired
    AuthenticationProviderConfig authenticationProviderConfig;

    //认证管理配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //认证生成器
        auth.authenticationProvider(authenticationProviderConfig);
    }

    //配置不拦截的路径 后台的资源放行
    @Override
    public void configure(WebSecurity web) {


        web.ignoring().antMatchers(
                // 静态资源
                "/hts/**","/res/**","/img/**",
                // Mk_UseController 用户表
                "/Mk_Use/**",
                // Mk_asktopicController 问表
                "/InsertAsktopic","/findNode","/InsertAnswer","/InsertAnAnwer",
                // Mk_CommentController 评论表
                "/InsertComment",
                // mk_coursecontroller 课程表
                "/comment_show","/learn_show","/ask_show","/iscollect","/insertcollect","/Deletecollect","/video","/showNote","/DeNote","/zall","/InsertProcess","/qtkcfl",
                // Mk_FabulousController 点赞表
                "/NoteFavor","/PingFavor","/1",
                // Mk_NodeController 笔记表
                "/InsertNode","/CourseNodeAll","/updatenode",
                // Mk_UserFolController 用户关注表
                "/InsertAuth","/DeleteMkcsid"
        );

    }




}
