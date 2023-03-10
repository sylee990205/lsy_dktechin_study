package day5.excercise;

public class MethodLab5 {

	public static void main(String[] args) {
		
		int repeat = 5;
		
		for(int i = 0; i < repeat; i ++) {
			if(i == repeat - 1)
				System.out.println(getRandom(10));
			else
				System.out.print(getRandom(10) + ", ");
		}
		
		System.out.println();
		
		for(int i = 0; i < repeat; i++) {
			if(i == repeat - 1)
				System.out.println(getRandom(10, 20));
			else
				System.out.print(getRandom(10, 20) + ", ");
		}

	}
	
	public static int getRandom(int n) { //public을 붙인 이유 => 다른 패키지에서도 사용 가능하게 하려고
		return (int)(Math.random() * n) + 1;
	}
	
	public static int getRandom(int n1, int n2) {
		// 두 값이 큰수와 작은수가 순서대로 들어온다는 보장이 없기에 이에 대한 처리를 해줘야함
		// 예외처리하는 방법도 있음
		
		int bigNum, smallNum;
		
		if(n1 > n2) {
			bigNum = n1;
			smallNum = n2;
		}else if(n2 > n1) {
			bigNum = n2;
			smallNum = n1;
		}else {
			bigNum = n1;
			smallNum = n1;
		}
		
		return (int)(Math.random() * (bigNum - smallNum + 1)) + 1;
	}

}

//[ 실습 5 ]
//1. 클래스명 : MethodLab5
//
//2. 구현해야 하는 메서드
//    public static int getRandom(int n) 
//	1 부터 n 까지 범위의 난수 리턴
//    public static int getRandom(int n1, int n2) 
//	n1 부터 n2 범위의 난수 리턴
//
//3. main() 메서드
//       getRandom(10) 을 5번 호출하고 리턴값을 하나의 행에 출력한다.
//	x, x, x, x, x
//
//       getRandom(10, 20) 을 5번 호출하고 리턴값을 하나의 행에 출력한다.
//	x, x, x, x, x
