package day1;

public class Exercise2 {

	public static void main(String[] args) {
		int num1 = 35;
		int num2 = 10;
		
		System.out.println(num1 +" 를 "+ num2 +" 으로 나눈 결과 몫은 " + (num1/num2) + " 이고 나머지는 "
				+ (num1%num2) + " 입니다."); 
		// 원래 Java에서 문자열 결합 시 +를 쓰면 계속 객체가 만들어져 효율이 좋지 않았으나, 일정 버전(1.5) 이후부턴 최적화 과정을 거쳐 상관없음. 
	}

}
//[ 실습 2 ]
//
//작성 클래스명 : Exercise2
//(1) int 타입의 변수 2개를 선언하고 각각 35, 10 으로 초기화 한다. 
//(2) 나눈 몫과 나머지를 구하여 제시된 출력 형식과 같이 출력하는 프로그램을 작성하시오. 
//
//- 출력 결과 
//
//35 를 10 으로 나눈 결과 몫은 3 이고 나머지는 5 입니다.   