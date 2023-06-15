package com.example.springedu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPLab2 {
    @Before("execution(public String com.example.springedu.controller.MultiController.select_proc())")
    public void bbb() {
        System.out.println("[AOP]select_proc 수행전");
    }
    @After("execution(public String com.example.springedu.controller.MultiController.search_proc())")
    public void aaa() {
        System.out.println("[AOP]search_proc 수행후");
    }
}
