package aop09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreMain {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("aop09.xml");
		
		CoreEx ex=factory.getBean("core", CoreEx.class);
		try {
			ex.zeroMethod(5,1);
		}catch(Exception e) {
			System.out.println("오류발생");
		}
		((ClassPathXmlApplicationContext)factory).close();
	}
}
