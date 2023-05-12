package aop10;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component(value="advice")
@Aspect
public class CalcAdvice {
	@Pointcut("execution(public * *(..))")
	public void myCalc(){
		
	}
	@Around("myCalc()")
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
	
	@AfterThrowing(pointcut="myCalc()", throwing="e" )
	public void afterThrowing(Throwable e){
		System.out.println("ㅠ 예외가 발생되었습니다 ㅠ");
	}
}
