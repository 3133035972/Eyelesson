package com.eyelesson.util;


import org.apache.commons.io.FilenameUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class EditorImg {

    public JSONObject  EditorJsonObject(MultipartFile[] file) throws JSONException {
        JSONObject jsonObject=new JSONObject();
        //定义序号
        try{
            for(MultipartFile mf:file){
                if(!mf.isEmpty())
                {
                    //重命名
                    String name=mf.getOriginalFilename();
                    System.out.println(name);
                    //获取文件的扩展名
                    String ext= FilenameUtils.getExtension(mf.getOriginalFilename());
                    System.out.println(ext);
                    //设置图片上传的路径
                    String url="D:/BaiduNetdiskDownload/";
                    //设置图片新的名字
                    String fileName=name+"."+ext;
                    //以绝对路径保存重命名的图片
                    File file1 = new File(url, fileName);
                    mf.transferTo(file1);
                    jsonObject.put("success", true);
                    jsonObject.put("file_path", fileName);
                }

            }
        }catch (Exception e)
        {
            e.printStackTrace();
            jsonObject.put("success", false);
        }
        return jsonObject;
    }

}
