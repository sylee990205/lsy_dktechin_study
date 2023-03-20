package day11;

import java.util.Scanner;

public class EqualsTest1 {
	public static void main(String[] args) {
		String s1 = "가나다"; // 문자열에 리터럴을 직접 담은 경우
		String s2 = "가나다";
		String s3 = new String("가나다"); // 객체를 새로 생성한 경우
		String s4 = new String("가나다");

		System.out.println(s1 == s2); //true
		System.out.println(s3 == s4); //false
		System.out.println(s3.equals(s4)); //true
		
		Scanner scan = new Scanner(System.in);
		System.out.print("문자열 입력 : "); // 등가 연산으로 비교하면 절대 안됨
		String inputStr = scan.next();
		if(inputStr.equals(s1)) 
			System.out.println("\"가나다\"를 입력했군요...");
		else 
			System.out.println("\"가나다\"가 아니군요...");
		scan.close();
	}
}
