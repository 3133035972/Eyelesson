package com.eyelesson.util;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class text {

    @Test
    public void test1(){

        /* 获取时长 封装好的 */
        ReadVideoTime readVideoTime = new ReadVideoTime();
        String s = readVideoTime.VideoChar("/d689957b-129a-490b-a139-08ed5d2d240a_天鹅之梦克隆.mp4");
        System.out.println(s);


    }

}

