package com.eyelesson.service;


import com.eyelesson.dao.ModulesDAO;
import com.eyelesson.entity.Modules;
import com.eyelesson.util.LayuiModules;
import com.eyelesson.util.ModulesNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModulesService {
    @Resource
    ModulesDAO modulesDAO;

    //获取菜单
    public List<ModulesNode> getTree(Integer posId)
    {
        List<Modules> parcode = modulesDAO.findByParcode("L01", posId);
        List<ModulesNode> treelist=getNode(parcode,posId);
        return treelist;
    }
    //获取主菜单下面的所有子菜单
    public  List<ModulesNode> getNode(List<Modules> list,Integer posId)
    {
        List<ModulesNode> rslist=new ArrayList<ModulesNode>();
        //遍历
        for(Modules modules:list)
        {
            ModulesNode node=new ModulesNode();
            node.setId(modules.getModuleCode());
            node.setText(modules.getModuleText());
            node.setIconCls(modules.getModuleIconCls());
            node.setChecked("false");

            Map<String,String> map=new HashMap<String,String>();
            //子节点
            List<Modules> childlist=modulesDAO.findByParcode(modules.getModuleCode(),posId);
            if(childlist.size()>0)
            {
                //有子节点
                node.setState("close");
                List<ModulesNode> childNode=getNode(childlist,posId);
                node.setChildren(childNode);
            }else{
                //没有子节点
                node.setState("open");
                //没有子节点,点击时要打开新窗口,需要url地址信息
                map.put("url",modules.getModuleUrl());
                node.setChildren(null);
            }
            node.setAttributes(map);
            rslist.add(node);

        }
        return rslist;
    }


    // 分配权限
    public boolean pos_modules(Integer posId,String[] modules){
        // 根据角色清空所属的权限
        int del = modulesDAO.delByPosIdModules(posId);
        // 根据角色添加所属的权限
        int add = 0;
        for (int i = 0; i < modules.length; i++) {
            modulesDAO.addByPosIdModules(posId,modules[i]);
        }
        return del >= 0 && add >=0?true:false;
    }




    // 查询所有菜单  判断有权限选中
    public List<Modules> findAll(){
        return modulesDAO.selectAll();
    }

    //属性菜单
    public List<LayuiModules> showModules(Integer posId){
        List<Modules> list = modulesDAO.showModules("L01");
        List<LayuiModules> layuiModulesList = getLayuiModules(list,posId);
        return layuiModulesList;
    }


    //layui的树形菜单  用于权限分配
    public List<LayuiModules> getLayuiModules(List<Modules> list,Integer posId){
        List<LayuiModules> rsList = new ArrayList<LayuiModules>();
        for(Modules modules:list){
            LayuiModules layuiModules = new LayuiModules();
            layuiModules.setValue(modules.getModuleCode());
            layuiModules.setTitle(modules.getModuleText());

            // 查询该角色已有的权限是否存在  存在选择状态
            List<String> moduleCodes = modulesDAO.findByPosId(posId);
            layuiModules.setChecked(moduleCodes.contains(modules.getModuleCode()));

            Map<String,String> map = new HashMap<String,String>();
            // 子节点
            List<Modules> childlist = modulesDAO.showModules(modules.getModuleCode());
            if(childlist.size()>0){
                // 有子节
                List<LayuiModules> childNode = getLayuiModules(childlist,posId);
                layuiModules.setData(childNode);
            }else{
                // 没有
                // 没有子节点，点击时要打开新窗口，需要url地址信息
                map.put("url",modules.getModuleUrl());
                layuiModules.setData(null);
            }
            rsList.add(layuiModules);
        }
        return rsList;
    }


}
