package com.eyelesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.eyelesson.dao")
public class EyelessonApplication {
    public static void main(String[] args) {
        SpringApplication.run(EyelessonApplication.class);
    }

}
