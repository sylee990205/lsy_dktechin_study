package day16;

public class GenericMethodTest2 {
	//제네릭 메소드
	public static <T extends Number> T whichBig(T t1, T t2) {
		if (t1.doubleValue() > t2.doubleValue())
			return t1;
		else 
			return t2;
	}	
	public static <T extends Number> boolean equalValue(T t1, T t2) {
		if (t1.doubleValue() == t2.doubleValue())
			return true;
		else 
			return false;
	}	
	public static void main(String[] args) {		
		System.out.println(whichBig(100, 200));
		System.out.println(whichBig(100, 20));
		System.out.println(whichBig(100.0, 20.0));
		//System.out.println(whichBig("100", "20"));
		System.out.println(equalValue(100, 100));
		System.out.println(equalValue(200, 100));
	}
}