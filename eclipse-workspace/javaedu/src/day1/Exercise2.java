package day1;

public class Exercise2 {

	public static void main(String[] args) {
		int num1 = 35;
		int num2 = 10;
		
		System.out.println(num1 +" 를 "+ num2 +" 으로 나눈 결과 몫은 " + (num1/num2) + " 이고 나머지는 "
				+ (num1%num2) + " 입니다."); 
		// 원래 Java에서 문자열 결합 시 +를 쓰면 계속 객체가 만들어져 효율이 좋지 않았으나, 일정 버전 이후부턴 최적화 과정을 거쳐 상관없음. 
	}

}
