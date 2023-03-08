package day2.excercise;

public class SwitchLab2 {

	public static void main(String[] args) {
		int num = (int)(Math.random()*5) + 1;
		int result = 0; //실질적으로 default로 빠질일은 없으니 선언 시 초기화
		
		switch (num) {
			case 1:
				result = 300 + 50;
				break;
			case 2:
				result = 300 - 50;
				break;
			case 3:
				result = 300 * 50;
				break;
			case 4:
				result = 300 / 50;
				break;
			case 5:
				result = 300 % 50;
				break;
//			default:
//				result = 0;
		}
		
		System.out.println("결과값 : " + result);
	}

}

//[ 실습 2 ] switch 문 사용 실습 
//1. ConditionOperLab.java를 복사해서 SwitchLab2.java를 생성한다.
//2. 다음 기능을 if 문이 아닌 switch 문으로 변경하여 구현한다.
//    추출된 값이 1이면 300 과 50 의 덧셈 연산을 처리한다.
//    추출된 값이 2이면 300 과 50 의 뺄셈 연산을 처리한다.
//    추출된 값이 3이면 300 과 50 의 곱센 연산을 처리한다.
//    추출된 값이 4이면 300 과 50 의 나눗셈 연산을 처리한다.
//    추출된 값이 5이면 300 과 50 의 나머지 연산을 처리한다.
//3. 출력 형식(단, 결과를 출력하는 수행문장은 한 번만 구현한다.)
//    결과값 : XX