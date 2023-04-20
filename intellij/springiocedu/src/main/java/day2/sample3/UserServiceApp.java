package day2.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceApp {
	public static void main(String[] args) {
		ApplicationContext factory 
        		= new ClassPathXmlApplicationContext("day2/sample3.xml");
		System.out.println("************ IoC 컨테이너의 초기화 작업 끝 ************\n");
		
		UserService u1=(UserService)factory.getBean("userService");
		UserVo vo = (UserVo)factory.getBean("obj1");
		u1.addUser(vo);
		System.out.println(u1);
		System.out.println("----------------------------------------------------");
		
		UserService u2=factory.getBean("userService", UserService.class); // Class 타입 객체 확장자 .class를 반드시 함께 작성해야함
		UserVo vo2 = (UserVo)factory.getBean("obj2");
		u2.addUser(vo2);
		System.out.println(u2);		
		((ClassPathXmlApplicationContext)factory).close();
	}
}





