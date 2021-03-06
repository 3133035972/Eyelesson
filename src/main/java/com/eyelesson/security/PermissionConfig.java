package com.eyelesson.security;

import com.eyelesson.service.PermissionService;
import com.eyelesson.service.PosModulesService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class PermissionConfig {



    @Resource
    PermissionService permissionService;

    @Resource
    HttpSession session;

    @Resource
    PosModulesService posModulesService;

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        boolean flag = false;
        System.out.println("进入hasPermission");


        // 获取用户身份
        Object principal = authentication.getPrincipal();

        System.out.println("principal:" + principal);
        System.out.println("principal.getClass:" + principal.getClass());

        //判断是否认证成功
        if (principal instanceof UserDetails) {
            // 根据用户获取对应的权限
            Integer posId = (Integer) session.getAttribute("posid");
            System.out.println(posId);

            List<String> permission = permissionService.findPermissionByPosId(posId);
            System.out.println(permission);
            System.out.println("根据职务编号查询的权限是：" + permission);
            System.out.println("根据职务编号查询的权限是==获取的路径" + request.getRequestURI());

            for (int i = 0; i < permission.size(); i++) {
                String per = permission.get(i);
                System.out.println("per:" + per);
                System.out.println("123======"+request.getRequestURI().equals(per));
                if (request.getRequestURI().equals(per)) {
                    //代表有当前的权限
                    System.out.println("代表有当前的权限");
                    flag = true;
                    break;
                }

            }

            List<String> urls = posModulesService.findUrlByPosId(posId);
            System.out.println("查询的菜单路径是：" + urls);
            System.out.println("查询的菜单路径是:====>>>获取的路径" + request.getRequestURI());

            for (int i = 0; i < urls.size(); i++) {
                String url = urls.get(i);
                System.out.println("urls:" + url);
                if (request.getRequestURI().equals(url)) {
                    //代表有当前的权限
                    System.out.println("代表有当前的权限====");
                    flag = true;
                    break;
                }

            }
            return flag;
        } else {
            return false;
        }

    }

}
