package day5.excercise;

public class MethodLab7 {

	public static void main(String[] args) {
		//int[] powerArr; 변수를 생성하지 않아도 괜찮음
		
		for(int i = 2; i <= 4; i++) {
//			powerArr = powerArray(i);
//			printArray(powerArr);
			printArray(powerArray(i));
		}

	}
	
	static int[] powerArray(int num) {
		int[] arr = new int[10];
		
		for(int i = 1; i <= 10; i++) {
			arr[i-1] = i * num; 
		}
		
		return arr;
	}
	
	static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length-1)
				System.out.print(arr[i] + "\n");
			else
				System.out.print(arr[i] + ", ");
		}
	}
	
	

}

//[ 실습 2 ]
//
//1. 클래스명 : MethodLab7
//2. 정의해야 하는 메서드(2개)
//   메서드명 : powerArray
//   매개변수 타입 : int
//   리턴값의 타입 : int[]
//   기능 : 1부터 10까지의 값으로 구성되는 배열을 만들어 
//           매개변수에 전달된 값만큼 배수로 element 값들을 변경하여 리턴한다.
//
//   메서드명 : printArray
//   매개변수 타입 : int[]
//   리턴값의 타입 : void
//   기능 : 매개변수를 통해서 전달된 배열을 element 값들을 다음 형식으로 출력한다. 
//
//	x,x,x,x,x,x,x,x,x,x
//
//
//3. main() 메서드에서 powerArray() 를 다음과 같이 아규먼트를 전달하여 3번 호출하고 리턴된
//   배열을 printArray() 에 전달하여 각 element 값을 출력한다.
//   
//	powerArray(2);
//	powerArray(3);
//	powerArray(4);
//
//             [ 실행 결과 ]
//	2,4,6,8,10,12,14,16,18,20
// 	3,6,9,12,15,18,21,24,27,30
//	4,8,12,16,20,24,28,32,36,40	
