package com.emotibot.adapter.constants;

/**
 * @Author: yangbai
 * @Date: 2020/7/6 1:49 PM
 * @Version 1.0
 */
public enum GlobalConsts {
    CODE_ERROR("000001"),


    //log
    LOG_GET("GET"),
    LOG_BODY("body");

    public String value;

    GlobalConsts(String value){
        this.value =value;
    }
}
