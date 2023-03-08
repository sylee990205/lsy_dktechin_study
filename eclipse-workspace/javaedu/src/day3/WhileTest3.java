package day3;

public class WhileTest3 {

	public static void main(String[] args) {  // 가~힣
		System.out.println("main() 수행 시작");
		char hangul = '가';
		while(hangul <= '나') 
			System.out.print(hangul++); // hangul 변수 출력 후 1 증가 		

		System.out.println("\nmain() 수행 종료");  // \n : 줄바꿈문자, 개행문자
		// while문 안의 수행 문장이 개행되지 않기 때문에 개행문자를 먼저 넣고 출력해야 다음 줄에 나온다.
	}
}
