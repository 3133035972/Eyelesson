package com.eyelesson.util;

import com.eyelesson.entity.Mk_soncourse_section;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ReadVideoTime {


    /* 计算毫秒 */
    public  Long VideoMill(String VideoUrl) {

        String url = "D:/BaiduNetdiskDownload" + VideoUrl;
        File source = new File(url);
        Encoder encoder = new Encoder();
        String VideoChar = "";
        try {
            MultimediaInfo m = encoder.getInfo(source);
            System.out.println("-------" + m.getDuration());

            return m.getDuration();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0L;
    }


    /*  毫秒转换成字符串 */
    public String VideoChar(String VideoUrl){
        String VideoChar = "";

            long aLong = VideoMill(VideoUrl);
            long ls = aLong / 1000;
            int hour = (int) (ls / 3600);
            int minute = (int) (ls % 3600) / 60;
            int second = (int) (ls - hour * 3600 - minute * 60);
            if (hour == 0 && minute != 0 && minute != 0) {
                VideoChar = "" + minute + "分" + second + "秒";
            } else if (hour == 0 && minute == 0) {
                VideoChar = "" + second + "秒";
            } else {
                VideoChar = "" + hour + "时" + minute + "分" + second + "秒";
            }
        return VideoChar;
    }


    /* 计算总时长 */
    public String VideoTotalM(int counts,List to){
        String VideoChar = "";
        Long total =0L;

        for (int i=0;i<counts;i++){
            System.out.println("to.get(i):"+to.get(i));
            Long aLong = VideoMill(to.get(i).toString());
            total+=aLong;
        }
        long ls = total / 1000;
        int hour = (int) (ls / 3600);
        int minute = (int) (ls % 3600) / 60;
        int second = (int) (ls - hour * 3600 - minute * 60);
        if (hour == 0 && minute != 0 && minute != 0) {
            VideoChar = "" + minute + "分" + second + "秒";
        } else if (hour == 0 && minute == 0) {
            VideoChar = "" + second + "秒";
        } else {
            VideoChar = "" + hour + "时" + minute + "分" + second + "秒";
        }
        return VideoChar;
    }

    /* 计算总时长 */
    public String VideoTotal(int counts,List<Mk_soncourse_section> to){
        String VideoChar = "";
        Long total =0L;

            for (int i=0;i<counts;i++){
                System.out.println("to.get(i):"+to.get(i));
                Long aLong = VideoMill(to.get(i).getMkcsurl());
                total+=aLong;
            }
        long ls = total / 1000;
        int hour = (int) (ls / 3600);
        int minute = (int) (ls % 3600) / 60;
        int second = (int) (ls - hour * 3600 - minute * 60);
        if (hour == 0 && minute != 0 && minute != 0) {
            VideoChar = "" + minute + "分" + second + "秒";
        } else if (hour == 0 && minute == 0) {
            VideoChar = "" + second + "秒";
        } else {
            VideoChar = "" + hour + "时" + minute + "分" + second + "秒";
        }
        return VideoChar;
    }
}
