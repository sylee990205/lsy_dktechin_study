package day2;

public class OperTest12 {

	public static void main(String[] args) {
		int num = 100;
		
		System.out.println(num > 100 && ++num == 101); // false
		System.out.println(num);  // 100
		
		System.out.println(num > 100 || ++num == 101); // true
		System.out.println(num);  // 101
	}

}
