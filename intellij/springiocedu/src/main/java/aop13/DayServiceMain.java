package aop13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DayServiceMain {
	public static void main(String[] args) {
		ApplicationContext context  = new ClassPathXmlApplicationContext("aop13.xml");

		DayService service = (DayService)context.getBean("ds13");
		String day = service.getDay();
		System.out.println("오늘은 "+day+"입니다.");
		int year = service.getYear();
		System.out.println("올해는 "+year+"년입니다.");

		service.errorTest();
		
		((ClassPathXmlApplicationContext)context).close();
	}
}








