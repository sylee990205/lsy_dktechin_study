package aop14;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodAroundAdvice {
	@Around("execution(public * aop14.DayServiceImpl.*())")
	public Object around(ProceedingJoinPoint pjp) {
		if (pjp.getSignature().getName().startsWith("get"))
			System.out.println("<<< MethodBeforeLogAdvice >>>");
		Object result=null;
		try {
			result = pjp.proceed();
		}catch(Throwable e) {
			System.out.println(":::오류 발생 메시지 : " + e.getMessage());
		}
		return result;
	}
}