package com.eyelesson.util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 图片上传的工具类
 */
@Controller
@RequestMapping("upload")
public class UploadUtil {

    private final String disk = "D:/BaiduNetdiskDownload/";

    //上传图片   图片名称  页面传递过来的  路径 页面传递过来要进行拼接的路径  截取存入到数据库的长度11 ：E:/driving/
    @RequestMapping("uploadSource")
    @ResponseBody
    public  String uploadSource(@RequestParam("file") MultipartFile photo, String path, int subSize) {
        
        
        System.out.println("你好");

        // System.out.println("photo:" + photo+"path:"+path +"subSize:"+subSize);
        String pathString = null;//定义全路径变量
        String fileName = "";//定义存入数据库的文件名称
        //判断文件是否等于空
        if(photo!=null) {
            UUID uuid = UUID.randomUUID();
            //文件存在磁盘的全路径  磁盘路径  页面传递过来的专辑名称 +uuid +文件的原名称
            pathString = disk +path+"/" +uuid + "_" +photo.getOriginalFilename();
        }
        // System.out.println("pathString = " + pathString);
        //否则判断该文件夹是否存在 不存在则创建新的文件夹
        try {
            File files = new File(pathString);
            System.out.println("files = " + files);
            //存入数据库的名称是全路径截取之后的名称
            fileName = pathString.substring(subSize);
            // System.out.println("fileName = " + fileName);
            //判断该文件的路径是否存在
            if(!files.getParentFile().exists()){
                files.getParentFile().mkdirs();
            }
            //保存文件
            photo.transferTo(files);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"code\":0,\"msg\":\""+fileName+"\"}";
    }



}