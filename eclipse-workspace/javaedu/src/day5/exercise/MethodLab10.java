package day5.exercise;

public class MethodLab10 {

	public static void main(String[] args) {
		
		int a1[] = new int[] { 1,2,3,4,5};
		MethodLab7.printArray(a1);
		powerArray(a1, 3);
		MethodLab7.printArray(a1);
		
		System.out.println();
		
		int a2[] = new int[] { 10,20,30,40,50, 60 };
		MethodLab7.printArray(a2);
		powerArray(a2, 10);
		MethodLab7.printArray(a2);
		
	}
	
	static void powerArray(int[] iArr, int num) {
		if(num >= 2 && num <= 5 ) {
			for(int i = 0 ; i < iArr.length; i++) {
				iArr[i] *= num;
			}
		}
		else {
			return;
		}
	}

}

//[ 실습 5 ]
//
//1. 클래스명 : MethodLab10
//2. 정의해야 하는 메서드
//   메서드명 : powerArray
//   매개변수 타입 : int 타입배열, int
//   리턴값의 타입 : void
//   기능 : 첫 번째 아규먼트로 전달된 배열의 element 값들을 두 번째 아규먼트로 전달된 값만큼 배수로 만들어 변경한다.
//           두 번째 아규먼트가 2~5 사이가 아니면 아무것도 수행하지 않고 그냥 리턴한다. 
//
//3. 다음과 같이 powerArray() 를 호출하고 리턴 결과를 화면에 출력한다.
//
//	int a1[] = new int[] { 1,2,3,4,5};
//	MethodLab7.printArray(a1);
//	powerArray(a1, 3)
//	MethodLab7.printArray(a1);
//
//	int a2[] = new int[] { 10,20,30,40,50, 60 };
//	MethodLab7.printArray(a2);
//	powerArray(a2, 10)
//	MethodLab7.printArray(a2);
//
//	[ 실행 결과 ]
//
//	1,2,3,4,5
//	3,6,9,12,15
//
//	10,20,30,40,50,60
//	10,20,30,40,50,60
