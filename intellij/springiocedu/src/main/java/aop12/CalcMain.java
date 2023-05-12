package aop12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {
	public static void main(String[] args) {
		ApplicationContext factory=new ClassPathXmlApplicationContext("aop12.xml");
		
		CalcMethod calc = factory.getBean("calc", CalcMethod.class);
		try {
			calc.sum(5, 4);
			calc.div(5, 0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		((ClassPathXmlApplicationContext)factory).close();
	}
}
