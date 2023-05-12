package aop08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("aop08.xml");
		
		MessageBean ob=factory.getBean("proxy",MessageBean.class);
		ob.sayHello();
		
		((ClassPathXmlApplicationContext)factory).close();
	}
}
