package day2.excercise;

public class ForLab4 {

	public static void main(String[] args) {
		int evenNum = 0; 
		int oddNum = 0;
		
		for(int i=1;i<=100;i++) {
			if (i % 2 == 0)
				evenNum += i;
			else
				oddNum += i;
		}
		
		System.out.println("1부터 100까지의 숫자들 중에서");
		System.out.println("짝수의 합은 " + evenNum + " 이고");
		System.out.println("홀수의 합은 " + oddNum + " 이다.");

	}

}

//[ 실습 6 ]
//1. ForLab4 이라는 클래스를 만든다.
//2. int 타입으로 evenNum 변수와 oddNum 변수를 선언한다.
//3. 1 부터 100 까지의 값 중에서 
//   짝수의 합은 evenNum 에 누적하고 
//   홀수의 합은 oddNum 에 누적한다.
//4. 수행 결과는 다음과 같이 출력한다.
//
//    1부터 100까지의 숫자들 중에서 
//    짝수의 합은 XXX 이고 
//    홀수의 합은 YYY 이다.
