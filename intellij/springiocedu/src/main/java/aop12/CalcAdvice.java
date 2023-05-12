package aop12;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component(value="advice")
@Aspect
public class CalcAdvice {
	@Before("bean(calc)")
	public void before(){
		System.out.println("연산을 시작합니다.");
	}

	@After("bean(calc)")
	public void after(){
		System.out.println("연산을 종료합니다.");
	}

	@Around("bean(calc)")
	public void around(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("** 연산시작 **");
		try {
			pjp.proceed();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("** 연산종료 **\n\n");
	}
}

