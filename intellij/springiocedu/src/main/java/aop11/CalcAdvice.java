package aop11;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component(value="advice")
@Aspect
public class CalcAdvice {
	@Pointcut("execution(public * *(..))")
	public void myCalc(){
	}
	@Before("myCalc()")
	public void before(){
		System.out.println("연산을 시작합니다.");
	}
	@After("myCalc()")
	public void after(){
		System.out.println("연산을 종료합니다\n");
	}
	
	@AfterThrowing(pointcut="myCalc()", throwing="e" )
	public void afterThrowing(Throwable e){
		System.out.println("예외가 발생되었습니다");
		System.out.println("에러메시지 : " + e.getMessage());
	}
}



