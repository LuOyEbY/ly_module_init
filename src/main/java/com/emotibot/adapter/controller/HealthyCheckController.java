package com.emotibot.adapter.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: emotibot_adapter
 * @Author: yangbai
 * @Date: 2020/12/22 3:42 PM
 * @Version: 1.0
 * @Description: 健康检查
 */
@Controller
@Log4j2
public class HealthyCheckController {

    @GetMapping("/healthCheck")
    public String healthCheck(){

        return "200";
    }
}
