package com.example.springedu.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Slf4j
@Order(2) // filter의 실행 순서가 2번째라는 의미
public class TestFilter1 implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws IOException, ServletException{
        log.info("[필터1] 요청 자원 수행 전");
        chain.doFilter(request, response);
        log.info("[필터1] 요청 자원 수행 후");
    }
}
