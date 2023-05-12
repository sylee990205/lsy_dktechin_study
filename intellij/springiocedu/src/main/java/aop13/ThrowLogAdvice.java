package aop13;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ThrowLogAdvice {
	@AfterThrowing(pointcut="execution(* *.*.error*())", throwing="e" )
	public void afterThrowing(Throwable e){
		System.out.println(":::오류 발생 메시지 : " + e.getMessage());
		//System.exit(0);
	}	
}