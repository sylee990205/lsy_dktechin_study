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
		//arraylist 초기 용량을 설정 안하면 10 15 이런식으로 자동으로 늘어남.
		//만약 arraylist의 용량이 커질 것이라는것을 안다면 미리 용량을 설정할 수 있음.
		//그 외의 경우엔 필요 x
		//size 는 list의 객체의 수를 return 하는 것이고
		//용량 return은 java에서는 지원하지 않는 기능
	}
	
	public static <T> T test4(ArrayList<T> t) {
		return t.get(0);		
	}

	public static void main(String[] args) {		
		test1("가나다");										// 어떤 객체가 전달되었을까요? java.lang.String
		test1(new java.util.Date());						// 어떤 객체가 전달되었을까요? java.util.Date
		test1(100);											// 어떤 객체가 전달되었을까요? java.lang.Integer
		System.out.println("-----------------------");
		System.out.println(test2("가나다"));					// 제네릭 메서드 : 가나다
		System.out.println(test2(new java.util.Date()));	// 제네릭 메서드 : [현재시간]
		System.out.println(test2(100));						// 제네릭 메서드 : 100
		System.out.println("-----------------------");
		ArrayList<Date> l1 = test3(10);
		l1.add(new Date());
		l1.add(new Date());
		System.out.println(l1);								// [현재시간], [현재시간]
		ArrayList<String> l2 = test3(10);
		l2.add("가나다");
		l2.add("abc");
		l2.add("123");
		System.out.println(l2);								// [가나다, abc, 123]
		System.out.println("-----------------------");
		Date d = test4(l1);
		String s = test4(l2);
		System.out.println(d);								// [현재시간]
		System.out.println(s);								//	가나다
	}
}