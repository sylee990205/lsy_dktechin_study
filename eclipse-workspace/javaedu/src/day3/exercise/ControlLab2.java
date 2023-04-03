package day3.exercise;

public class ControlLab2 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++) {
			if(i % 3 == 0 || i % 4 == 0) 
				continue;
			System.out.println(i);
		}

	}

}

//[ 실습5 ]
//1. ControlLab2 이라는 클래스를 생성한다.
//2. 다음 기능을 반복하여 처리하는 자바 프로그램을 구현한다.
//
//   1부터 10까지의 값을 행단위로 출력하는데 3의 배수와 4의 배수는 제외한다.
//   반드시 continue 문을 사용하여 해결한다.
//
//	1
//	2
//	5
//	7
//	10