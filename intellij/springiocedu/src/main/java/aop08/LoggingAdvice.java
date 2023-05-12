package aop08;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//횡단(공통)관심 사항
public class LoggingAdvice {
	
	public void logAround(ProceedingJoinPoint jp) throws Throwable{
		String methodName = jp.getSignature().getName();
		StopWatch sw = new StopWatch(); // 실행 소요 시간을 알 수 있는 API
		System.out.println("From [aop8.xml]");
		System.out.println("[LOG]METHOD : " + methodName + " 호출");
		sw.start();
		jp.proceed();
		sw.stop();
		System.out.println(jp);
		System.out.println(jp.getSignature());
		System.out.println(jp.getSignature().getName()); // 메소드 이름 추출 가능
		System.out.println(jp.getTarget());
		System.out.println(jp.getTarget().getClass().getName());
		System.out.println(jp.toLongString());
		System.out.println(jp.toShortString());
		System.out.println(jp.getThis());
		System.out.println(jp.getThis().getClass().getName());
		System.out.println("[LOG]METHOD : " + methodName + " 수행 종료");
		System.out.println("[LOG]처리시간   : " + sw.getTotalTimeMillis()/1000 + " 초");
	}
}













