package day8;

public class PolyTest {

	public static void main(String[] args) {
		printObjectInfo(new Object());
		printObjectInfo("가나다");
		printObjectInfo("ABC");
		printObjectInfo(new java.util.Date());
		printObjectInfo(new java.io.File("c:/Temp"));
		printObjectInfo(new int[10]);
		printObjectInfo(new double[5]);
		printObjectInfo(100); 
		// Java5부터 autoboxing 지원, 100은 integer지만 메소드에서는 Object를 원하고 있어서 변경시켜주는것
		printObjectInfo(3.14); 

		
	}
	//동일한 static을 해야 같은 메모리 내에 할당이 되고 그래야 호출이 가능함
	static void printObjectInfo(Object o) {
		if(o instanceof String) {
			System.out.println("문자열 객체가 전달됨 : " + o.toString() + "-" + ((String)o).length());
		}else {
			System.out.println("전달된 객체의 클래스명 : "+ o.getClass().getName());	
		}
		
	}

}
