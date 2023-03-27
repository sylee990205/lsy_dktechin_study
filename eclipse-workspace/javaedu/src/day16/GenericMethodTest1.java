package day16;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;

public class GenericMethodTest1 {
	//제네릭 메소드
	public static <T> void test1(T t) {
		System.out.println("어떤 객체가 전달되었을까요? "+t.getClass().getName());
	}
	
	public static <T> String test2(T t) {
		return "제네릭 메서드 : " + t;
	}
	
	public static <T> ArrayList<T> test3(int num) {		
		return new ArrayList<T>(num);
	}
	
	public static <T> T test4(ArrayList<T> t) {
		return t.get(0);		
	}

	public static void main(String[] args) {		
		test1("가나다");
		test1(new java.util.Date());
		test1(100);
		System.out.println("-----------------------");
		System.out.println(test2("가나다"));
		System.out.println(test2(new java.util.Date()));
		System.out.println(test2(100));
		System.out.println("-----------------------");
		ArrayList<Date> l1 = test3(10);
		l1.add(new Date());
		l1.add(new Date());
		System.out.println(l1);
		ArrayList<String> l2 = test3(10);
		l2.add("가나다");
		l2.add("abc");
		l2.add("123");
		System.out.println(l2);
		System.out.println("-----------------------");
		Date d = test4(l1);
		String s = test4(l2);
		System.out.println(d);
		System.out.println(s);
	}
}