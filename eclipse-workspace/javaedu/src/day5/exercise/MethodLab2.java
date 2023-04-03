package day5.exercise;

public class MethodLab2 {

	public static void main(String[] args) {
		
		printTriangle('@',3);
		System.out.println();
		printTriangle('%',4);
		System.out.println();
		printTriangle('A',5);
		System.out.println();
	
		
	}
	
	static void printTriangle(char deco, int num) {
		
		for (int i = 0 ; i < num; i++) {
			for(int j = 1; j < num - i; j++ ) {
				System.out.print(" ");
			}
			
			for(int k = 0; k < i + 1; k++) {
				System.out.print(deco);
			}
			
			System.out.println();
		}
		
	}

}



//[ 실습 2 ]
//1. 클래스명 : MethodLab2
//
//2. 구현해야 하는 추가 메서드 (static 붙여서)
//   매개변수 : char 타입 1개, int 타입 1 개 
//   리턴값 : 없음
//   메서드명 : 임의로
//   기능 : 첫 번째 아규먼트로 전달된 문자를 
//           두 번째 아규먼트로 전달된 숫자의 행으로 구성되는 삼각형을 출력한다.
//           (출력해야 하는 삼각형 모양은 3번을 참고한다.-직각삼각형)
//
//3. main() 메서드에서는 다음과 같이 아규먼트를 전달하면서 2번에 구현한 메서드를 다음과 같이 호출한다.
//
//
//     xxxx('@', 3)
//
//	  @
//   @@
//  @@@
//
//     xxxx('%', 4)
//
//	        %
//         %%
//        %%%
//       %%%%
//
//     xxxx('A', 5)
//
//	       A
//        AA
//       AAA
//      AAAA
//     AAAAA