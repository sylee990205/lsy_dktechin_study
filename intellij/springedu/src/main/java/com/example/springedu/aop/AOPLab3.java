package com.example.springedu.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Slf4j
@Aspect
public class AOPLab3 {
    @Around("within(com.example.springedu.controller.EmpController)")
    public Object around(ProceedingJoinPoint pjp) {
        Object result = null;
        StopWatch sw = new StopWatch();
        try {
            sw.start();
            result = pjp.proceed();
            sw.stop();
            log.info(pjp.getTarget().getClass().getName() + " - 수행시간(밀리초) - " + sw.getTotalTimeMillis());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
