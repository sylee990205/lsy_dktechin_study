package day4;

public class TwoArrayTest2 {
	public static void main(String[] args) {
		int[] a1 = new int[10];
		char a2[] = new char[5];//{'가', '나', '다'};
		double a3[] = new double[5];
		System.out.println(a1.length + " : "+a2.length + " : " + a3.length); // 10 : 3 : 5
		System.out.println(a1);		// 배열 a1 참조값 [I@참조값
		System.out.println(a2);		// 배열 a2 참조값 x , 가나다 - System.out.println()이 char형 배열을 특별 취급하기때문에 내용을 출력. 만약 초기화를 안하면 공백 문자 출력 (다른 배열은 객체로 취급) 
		System.out.println(a3);		// 배열 a3 참조값 [D@참조값
		System.out.println(a1[0]);	// 0	
		System.out.println(a2[0]); 	// 가
		System.out.println(a3[0]);	// 0.0
		System.out.println();
		
		int[][] a4 = new int[5][12];
		System.out.println(a4);		// 배열 a4의 행의 배열 참조값
		System.out.println(a4[0]);	// 배열 a4의 첫번째 행에 의한 열의 배열 참조값
		System.out.println(a4[1]);	// 배열 a4의 두번째 행에 의한 열의 배열 참조값
		System.out.println(a4[2]);	// 배열 a4의 세번째 행에 의한 열의 배열 참조값
		System.out.println(a4[3]);	// 배열 a4의 넷번째 행에 의한 열의 배열 참조값
		System.out.println(a4[4]);	// 배열 a4의 다섯번째 행에 의한 열의 배열 참조값
		System.out.println();
		System.out.println(a4.length); //5
		System.out.println(a4[0].length); //12
		System.out.println(a4[1].length); //12
		System.out.println(a4[2].length); //12
		System.out.println(a4[3].length); //12
		System.out.println(a4[4].length); //12
	}
}



