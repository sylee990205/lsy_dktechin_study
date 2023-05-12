package com.example.springedu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPLab1 {
    @Before("execution(public * com.example.springedu.controller.HelloController.*(..))")
    public void bbb() {
        System.out.println("[AOP]hello 수행 전");
    }

    @After("execution(public * com.example.springedu.controller.HelloController.*(..))")
    public void aaa(){
        System.out.println("[AOP]hello 수행 후");
    }
}
