package day5.excercise;

public class MethodLab1 {

	public static void main(String[] args) {
		System.out.print("우리 자바 교재명은 <");
		printTitle();
		System.out.print(">입니다.");
		System.out.println();
		
		System.out.printf("가격은 %,d원 입니다.",getPrice());
		
	}
	
	static void printTitle() {
		System.out.print("이것이 자바다");
	}
	
	static int getPrice(){
		return 36000;
	}

}

//[ 실습 1 ]
//1. 클래스명 : MethodLab1
//
//2. 구현해야 하는 추가 메서드 2개 (static 붙여서)
//
//   매개변수 : 없음 
//   리턴값 : 없음
//   메서드명 : printTitle
//   기능 : 우리 자바 교재의 책제목을 화면에 출력한다.(개행처리 제외)
//
//   매개변수 : 없음 
//   리턴값 : int
//   메서드명 : getPrice
//   기능 : 우리 자바 교재의 책 가격을 리턴한다.
//
//3. main() 메서드에서는 위에 정의한 메서드들을 호출하고 
//   다음과 같은 결과가 출력되도록 구현한다.
//
//	[ 실행 결과 ]
//
//	우리의 자바교재명은 <이것이 자바다>입니다.
//             가격은 36,000원입니다.