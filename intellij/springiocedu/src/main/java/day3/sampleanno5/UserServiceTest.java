package day3.sampleanno5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

	public static void main(String[] args) {
		ApplicationContext factory 
		   					= new ClassPathXmlApplicationContext("day3/sampleanno5.xml");
		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");

		UserService uu = factory.getBean("userService", UserService.class);
		uu.addUser();

		((ClassPathXmlApplicationContext) factory).close();

	}

}
