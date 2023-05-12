package aop04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMain {
	public static void main(String[] args) {
		ApplicationContext factory
				= new ClassPathXmlApplicationContext("aop04.xml");

		MyService ms=(MyService)factory.getBean("target");
		int result = ms.work1();
		System.out.println("================================ "+ result);
		ms.work2();
		System.out.println("================================");
		result = ms.work3();
		System.out.println("================================ "+ result);
		((ClassPathXmlApplicationContext)factory).close();
	}
}
