package day7;

class MyObject extends Object{ //extends Object는 생략해도 됨.
	void printName() {
		System.out.println("자바듀크");
	}
	
	public String toString() { // public 메서드를 오버라이딩할때는 반드시 public 접근제어자를 좁은 범위로 변경할 수 없다
		return "Object의 자식클래스인 MyObject 객체임"; 
	}
}


public class MyObjectTest {

	public static void main(String[] args) {
		MyObject my = new MyObject();
		System.out.println(my.toString());
		System.out.println(my); //변수값을 출력하시오 -> toString 메서드를 거쳐 출력됨
		System.out.println("출력" + my); 
		my.printName();
	}

}
