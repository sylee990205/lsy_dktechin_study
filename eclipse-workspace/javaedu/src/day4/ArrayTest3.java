package day4;

public class ArrayTest3 {
	public static void main(String[] args) {
		boolean a1[] = new boolean[10];
		int a2[] = new int[5];
		long a3[] = new long[20];
		double a4[] = new double[3];
		// 참조 값은 @ 앞과 뒤로 나뉘어지는데, @앞은 배열의 타입별로 달라지며 @뒤가 참조값이다.
		System.out.println(a1); 
		System.out.println(a1.length);
		
		System.out.println(a2);
		System.out.println(a2.length);
		
		System.out.println(a3);
		System.out.println(a3.length);
		
		System.out.println(a4);
		System.out.println(a4.length);
		
		a2 = new int[100];
		System.out.println(a2);
		System.out.println(a2.length);
		
	}
}
