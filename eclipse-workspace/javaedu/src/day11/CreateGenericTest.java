package day11;
import java.util.Date;


public class CreateGenericTest {

	public static void main(String[] args) {
		Value1 v1 = new Value1();
		v1.put("가나다");
		String s1 = v1.get();
		System.out.println(s1);
		// v1.put(new Date()); //불가능
		
		Value2 v2 = new Value2();
		v2.put("가나다");
		String s2 = (String) v2.get(); // 꺼낼때는 반드시 형변환 해야함
		System.out.println(s2);
		
		v2.put(new Date());	// object 타입이라 모든 클래스 객체가 가능
		Date d1 = (Date) v2.get(); // 꺼낼때는 반드시 형변환 해야함
		System.out.println(d1);
		
		Value3<String> v3 = new Value3<>(); // Value3는 String 객체를 만들 수 있는 클래스가 됨
		v3.put("가나다");
		String s3 = v3.get(); // 형변환연산을 하지 않아도 괜찮음
		System.out.println(s3);
		
		Value3<Date> v4 = new Value3<>(); // type parameter를 Date로 지정 -> Date 객체를 만들 수 있는 클래스
		v4.put(new Date());	
		Date d2 = v4.get(); 
		System.out.println(d2);
	}

}

class Value1 { //String 타입만 다룰 수 있음
	String obj;
	void put(String obj) {
		this.obj = obj;
	}
	
	String get() {
		return obj;
	}
	
}

class Value2 { //모든 타입의 객체를 다룰 수 있음
	Object obj;
	void put(Object obj) {
		this.obj = obj;
	}
	
	Object get() {
		return obj;
	}
	
}


// generic 프로그래밍을 통해 만들어진 클래스
class Value3<T> {
	T obj;
	void put(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return obj;
	}
	
}
