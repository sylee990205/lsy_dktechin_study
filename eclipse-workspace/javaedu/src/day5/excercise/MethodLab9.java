package day5.excercise;

public class MethodLab9 {

	public static void main(String[] args) {
		
		System.out.println(isRightTriangle(3,4,5));
		System.out.println(isRightTriangle(1,2,3));

	}
	
	static boolean isRightTriangle(int width, int height, int hypo) {
		int pytha = (hypo * hypo) - (width * width) - (height * height);
		if (pytha == 0)
			return true;
		else
			return false;
	}

}

//[ 실습 4 ]
//
//1. 클래스명 : MethodLab9
//2. 정의해야 하는 메서드
//   메서드명 :  isRightTriangle
//   매개변수 타입 :  int width, int height, int hypo
//   리턴값의 타입 : boolean
//   기능 : 너비와 높이 그리고 빗변의 데이터를 받아서 직각삼각형인지 판별하고(순서도작성-04.pdf 참조)
//           직각삼각형이면 true 를 아니면 false 를 리턴한다.
//
//3. 다음과 같이 isRightTriangle() 을 호출하고 리턴 결과를 화면에 출력한다.
//
//	isRightTriangle(3, 4, 5)
//	isRightTriangle(1, 2, 3)
//
//	[ 실행 결과 ]
//
//	true
//	false