package com.emotibot.adapter.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangbai
 * @Date: 2020/7/30 11:15 AM
 * @Version 1.0
 */
@RestController
@Log4j2
public class TestController {

    @GetMapping("/test")
    public String Test(){
        log.info("【逻辑日志】：{}","测试");
        return "测试成功";
    }
}
