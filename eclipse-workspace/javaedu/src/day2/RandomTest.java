package day2;

public class RandomTest {

	public static void main(String[] args) {
		double rand = Math.random();
		System.out.println(rand);    
		System.out.println(rand*10);
		System.out.println(rand*100);
		System.out.println(rand*6);
		System.out.println((int)(rand*10)); // 0~9   
		System.out.println((int)(rand*100));  // 0~99
		System.out.println((int)(rand*6));  // 0~5
		System.out.println((int)(rand*10)+1);   // 1~10
		System.out.println((int)(rand*100)+1);  // 1~100
		System.out.println((int)(rand*6)+1);   // 1~6
		System.out.println((int)(rand*45)+1);   // 1~45
	}

}
