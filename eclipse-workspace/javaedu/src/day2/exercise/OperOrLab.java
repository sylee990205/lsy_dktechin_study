package day2.exercise;

public class OperOrLab {

	public static void main(String[] args) {
		int grade = (int)(Math.random()*6)+1;
		
		if (grade == 1 || grade == 2 || grade == 3)
			System.out.println(grade + " 학년은 저학년입니다.");
		else
			System.out.println(grade + " 학년은 고학년입니다.");

	}

}

//[ 실습 2 ] if 문 사용 실습 - 다음 요구사항을 잘 읽고 소스를 2개 구현한다.
//
//1. OperAndLab(&&연산자사용), OperOrLab(||연산자사용) 
//   이라는 클래스를 각각 하나씩 생성한다.
//2. grade 라는 변수를 int 타입으로 선언하고 1 부터 6 사이의 숫자를 
//   추출하고 저장한다.
//3. grade 의 값이 1 또는 2 또는 3이면 다음 결과를 출력한다.
//   "x 학년은 저학년입니다."
//   grade 의 값이 4 또는 5 또는 6이면 다음 결과를 출력한다.
//   "x 학년은 고학년입니다."