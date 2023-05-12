package aop03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Random;

public class StartMain {
	public static void main(String[] args) {
		ApplicationContext factory
				= new ClassPathXmlApplicationContext("aop03.xml");
		String beanName;
		if (new Random().nextBoolean())
			beanName = "customer";
		else
			beanName = "emp";
		Person p=(Person)factory.getBean(beanName); // customer or emp
		p.work();
		((ClassPathXmlApplicationContext)factory).close();
	}
}
