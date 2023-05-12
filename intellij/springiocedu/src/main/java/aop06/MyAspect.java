package aop06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect{
	@Pointcut("execution(public void aop06.*.*())")
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







