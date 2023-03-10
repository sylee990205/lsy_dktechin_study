package day5.excercise;

public class MethodLab4 {

	public static void main(String[] args) {
		
		int ran_num1, ran_num2;
		
		for(int i = 0; i < 5; i++) {
			ran_num1 = (int)(Math.random() * 30) + 1;
			ran_num2 = (int)(Math.random() * 30) + 1;
			
			System.out.printf("%d 와 %d 의 차는 %d 입니다.\n", ran_num1, ran_num2, getSub(ran_num1, ran_num2));			
		}
		
	}
	
	static int getSub(int num1, int num2) {
		if (num1 > num2)
			return num1 - num2;
		else if (num2 > num1)
			return num2 - num1;
		else
			return 0;
	}

}

//[ 실습 4 ]
//1. 클래스명 : MethodLab4
//
//2. 구현해야 하는 추가 메서드 (static 붙여서)
//   매개변수 : int 타입으로 2 개
//   리턴값 : int 타입으로 1개
//   메서드명 : 임의로
//   기능 : 전달받은 2개의 데이터 중에서 큰 값에서 작은 값의 
//            차를 리턴 두 값이 동일하면 0 을 리턴한다.
//           10, 20 이 전달되면 ---> 10 리턴
//           20, 5 가 전달되면 ---> 15 리턴
//           5, 30 이 전달되면 ---> 25 리턴
//           6, 3 이 전달되면  ---> 3 리턴
//
//3. main() 메서드에서는 
//   1부터 30 사이의 난수 2 개를 추출하여 2번에서 구현된 메서드를 호출하고
//   리턴되는 결과를 가지고 다음과 같은 형식으로 출력한다.
//   "X 와 Y 의 차는 W 입니다."
//   ----> 5회 반복
//
//	[ 실행 결과 ]
//
//	X 와 Y 의 차는 W 입니다.
//	X 와 Y 의 차는 W 입니다.
//	X 와 Y 의 차는 W 입니다.
//	X 와 Y 의 차는 W 입니다.
//	X 와 Y 의 차는 W 입니다.