package aop13;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class MethodBeforeLogAdvice {
	@Before("execution(public * aop13.DayServiceImpl.get*())")
	public void bbb(){
		System.out.println("<<< MethodBeforeLogAdvice >>>");
	}
}