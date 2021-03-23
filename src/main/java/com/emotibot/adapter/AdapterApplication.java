package com.emotibot.adapter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author: yangbai
 * @Date: 2020/7/30 11:18 AM
 * @Param: 
 * @return: 
 * @Description:项目入口
 * @Version 1.0
 */
@SpringBootApplication
@ServletComponentScan
public class AdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdapterApplication.class, args);
    }

}
