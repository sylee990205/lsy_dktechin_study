package day5.excercise;

public class MethodLab3 {

	public static void main(String[] args) {
		
		String string = isEven(10) ? "짝수" : "홀수";
		System.out.println("10은 " +  string + " 입니다.");
		
//		string = isEven(13) ? "짝수" : "홀수";
//		System.out.println("13은 " +  string + " 입니다.");
		
		// 같은 내용이 두번 이상 사용되지않는다면 변수를 생성하지않고 바로 작성해도 된다.
		System.out.printf("%d은 %s 입니다.",13,isEven(13) ? "짝수" : "홀수");
		
		
	}
	
	static boolean isEven(int num) {
		return num % 2 == 0 ? true : false;
	}
}

//[ 실습 3 ]
//1. 클래스명 : MethodLab3
//
//2. 구현해야 하는 추가 메서드(static 붙여서)
//
//   매개변수 : int 타입으로 1개 
//   리턴값 : boolean
//   메서드명 : isEven
//   기능 : 매개변수를 통해서 전달받은 숫자가 짝수면 true 를 리턴하고
//           홀수면 false를 리턴한다.
//
//3. main() 메서드에서는 위에 정의한 메서드를 호출하고 
//   다음과 같이 결과가 되도록 구현한다.
//
//	2번에서 구현한 함수를 다음과 같은 아규먼트를 전달하여 호출하는 것으로 정한다.
//
//		xxxx(10)
//		xxxx(13)
//
//	[ 실행 결과 ]
//
//	 	10은 짝수 입니다.
//		13은 홀수 입니다.
//
//	(*) 2번의 함수를 호출하고 리턴결과가 참인지 거짓인지에 따라 
//	    위와 같은 결과가 출력되도록 구현하는데 반드시 3항 연산자(조건 연산자)를 사용한다.