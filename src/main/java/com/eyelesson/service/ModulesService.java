package com.eyelesson.service;


import com.eyelesson.dao.ModulesDAO;
import com.eyelesson.entity.Modules;
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
    public List<ModulesNode> getTree(Integer posid)
    {
        List<Modules> parcode = modulesDAO.findByParcode("L01", posid);
        List<ModulesNode> treelist=getNode(parcode,posid);
        return treelist;
    }
    //获取主菜单下面的所有子菜单
    public  List<ModulesNode> getNode(List<Modules> list,Integer posid)
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
            List<Modules> childlist=modulesDAO.findByParcode(modules.getModuleCode(),posid);
            if(childlist.size()>0)
            {
                //有子节点
                node.setState("close");
                List<ModulesNode> childNode=getNode(childlist,posid);
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

}
