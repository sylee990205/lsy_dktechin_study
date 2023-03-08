package day3;

public class ContinueTest {

	public static void main(String[] args) {
		int num;
		while(true) {
			num = (int)(Math.random()*31); // 0 ~ 30
			if (num == 0) {
				System.out.println("\n종료");
				break; // 빠져 나가게끔 분기
			}
			if (num > 26) {
				System.out.println('@');
				continue; // 다시 조건식으로 분기
			}
			System.out.printf("%d(%c)", num, (char)(96+num)); // 대문자는 65부터 소문자는 97부터		
		}
	}
}
