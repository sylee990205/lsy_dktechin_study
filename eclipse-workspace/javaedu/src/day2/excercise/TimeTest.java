package day2.excercise;

public class TimeTest {

	public static void main(String[] args) {
		int time = 32150;
		int hour = time / 60 / 60;
		int min = time / 60 % 60;
		int sec = time % 60;
		
		System.out.println(hour + "시간 " + min +"분 " + sec + "초");
		

	}

}

//[ 실습 1 ] 연산자 실습
//
//1. TimeTest 라는 클래스를 생성한다.
//2. time 이라는 변수를  int 타입으로 선언하여 32150(초) 이라는 값을 저장한다.   
//3. time 변수의 값을 가지고 연산식을 만들어서
//    "XX시간 XX분 XX초" 형식으로 변환하여 화면에 출력한다.
//위의 결과를 만들기 위해서 변수선언과 식 정의는 모두 임의로 정한다.