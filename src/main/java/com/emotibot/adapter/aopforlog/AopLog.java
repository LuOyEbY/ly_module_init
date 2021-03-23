package com.emotibot.adapter.aopforlog;

import com.emotibot.adapter.constants.GlobalConsts;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.log4j.Log4j2;
import cn.hutool.json.JSONUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 * @Author: yangbai
 * @Date: 2020/7/30 10:39 AM
 * @Version 1.0
 * @Descripe:aop接口的日志打印增强
 */
@Aspect
@Component
@Log4j2
public class AopLog {

    private static final String START_TIME = "request-start";


    @Pointcut("execution(public * com.emotibot.adapter.controller.*Controller.*(..))" )
    public void log(){

    }

    @Before("log()")
    public void beforeLog(JoinPoint point){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        log.info("【请求 URL】：{}", request.getRequestURL());
        log.info("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求方法类型】：{}", request.getMethod());
        log.info("【请求方法名】：{}", point.getSignature().getName());

        if(GlobalConsts.LOG_GET.value.equals(request.getMethod())){
            log.info("【请求参数】：{}",JSONUtil.toJsonStr(request.getParameterMap()));
        }else{
            log.info("【请求参数】：{}",point.getArgs());
        }
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        log.info("【返回值】：{}", JSONUtil.toJsonStr(result));
        return result;
    }

    @AfterReturning("log()")
    public void afterReturningLog() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("【请求耗时】：{}毫秒", end - start);

        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);
    }


}
