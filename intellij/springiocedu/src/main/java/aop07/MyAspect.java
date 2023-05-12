package aop07;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component       // 기본값: myAspect
@Aspect
public class MyAspect{
	@Pointcut("execution(public void aop07.*.*())")
	public void myWork() {
	}
	
	@Before("myWork()")
	public void login(JoinPoint joinPoint) {
		System.out.println("로그인 처리");
	}
	
	@After("myWork()")
	public void logout(JoinPoint joinPoint) {
		System.out.println("로그아웃");
	}
}







