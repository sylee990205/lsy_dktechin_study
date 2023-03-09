package day4;

public class ArrayTest6 {
	public static void main(String[] args) {
		char letters[] = {'A', 'B', 'z', 't', 'M', 'm'};

		for (char ch : letters) { // 배열을 하나하나 읽어 오고 있어서 foreach문 사용이 좋다
			if (ch >= 'A' && ch <= 'Z') // 대문자 A부터 Z까지의 코드값 , JAVA는 대소문자 check API 내장하고 있음.
				System.out.println(ch+ "는 대문자입니다.");
			else
				System.out.println(ch+ "는 소문자입니다.");
		}
	}
}
