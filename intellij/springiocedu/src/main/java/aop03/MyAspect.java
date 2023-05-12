package aop03;

import org.aspectj.lang.JoinPoint;

public class MyAspect{
	public void login(JoinPoint joinPoint) {
		System.out.println("로그인 처리**");
	}
	
	public void logout(JoinPoint joinPoint) {
		System.out.println("로그아웃**");
	}
}
