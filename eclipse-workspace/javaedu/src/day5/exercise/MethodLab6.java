package day5.exercise;

public class MethodLab6 {

	public static void main(String[] args) {
		
		int[] arr1 = new int[] {10,20,30};
		int[] arr2 = new int[] {100,500,300,200,400};
		int[] arr3 = new int[] {1,10,3,4,5,8,7,6,9,2};
		
		System.out.printf("가장 큰 값은 %d 입니다.\n",maxNumArray(arr1));
		System.out.printf("가장 큰 값은 %d 입니다.\n",maxNumArray(arr2));
		System.out.printf("가장 큰 값은 %d 입니다.",maxNumArray(arr3));
		
		int[] result = new int[3]; // 값을 배열에 넣으면 출력 시 반복문 사용 가능
		result[0] = maxNumArray(arr1);
		result[1] = maxNumArray(arr2);
		result[2] = maxNumArray(arr3);
		
		for(int i = 0; i < result.length; i++) {
			System.out.printf("가장 큰 값은 %d 입니다.\n",result[i]);
		}
		
	}
	
	static int maxNumArray(int[] arr) {
		//int max = 0, temp;
		int max = arr[0]; // 첫 값을 넣으면
		
		for(int i = 1; i < arr.length ; i++) { // index 1부터 시작하면 된다.
			if(arr[i] > max)
				max = arr[i];
			
//			temp = arr[i];
//			if (max < temp)
//				max = temp;
		}
		
		return max;
	}

}


//[ 실습 1 ]
//
//1. 클래스명 : MethodLab6
//2. 정의해야 하는 메서드  
//   메서드명 : maxNumArray
//   매개변수 타입 : int[]
//   리턴값의 타입 : int
//
//   매개변수에 전달된 배열의 원소값들 중에서 가장 큰값 리턴
//   
//3. main() 메서드에서 maxNumArray 를 3번 호출한다.
//   다음 배열들을 전달하여
//     배열 1 : 10, 20, 30
//     배열 2 : 100, 500, 300, 200, 400
//     배열 3 : 1, 10, 3, 4, 5, 8, 7, 6, 9, 2
//   
//   호출하고 리턴값을 다음과 같이 출력한다.
//
//     가장 큰 값은 30 입니다.
//     가장 큰 값은 500 입니다.
//     가장 큰 값은 10 입니다.