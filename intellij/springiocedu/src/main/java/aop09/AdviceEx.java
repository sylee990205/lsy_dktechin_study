package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceEx {
	    @Before("within(aop09.CoreEx)") // within에 지정된 클래스의 모든 메소드가 pointcut
		public void before(){
			System.out.println("Before Advice");
		}
		
		@AfterThrowing(pointcut="within(aop09.CoreEx)", throwing="e" )
		public void afterThrowing(Throwable e){
			System.out.println("예외가 실행될때 호출되는 Advice : "+e.getMessage());
		}
		
		@AfterReturning(pointcut="within(aop09.CoreEx)", returning="ret" )
		public void afterReturing(Object ret){
			System.out.println("Joinpoint 가 정상 종료후 실행되는 Advice");
		}
		
		@After("within(aop09.CoreEx)")
		public void after(){
			System.out.println("After Advice");
		}
		
		@Around("within(aop09.CoreEx)")
		public Object around(ProceedingJoinPoint  jp) throws Throwable{
			System.out.println("Around Advice(1)");
			Object result = null;
			try {
				result = jp.proceed();
			} catch(Exception e ) {
				System.out.println("오류가 발생했다네 : "+ e.getMessage());
			}
			System.out.println("Around Advice(2)");
			return result;
		}	
}
