package day4.excercise;

public class TowArrayLab1 {

	public static void main(String[] args) {
		int[][] twoArr = {
							{10, 12, 14, 16},
							{18, 20, 22, 24},
							{26, 28, 30, 32},
							{34, 36, 38, 40}
						};
		System.out.println("1행 1열의 데이터 : " + twoArr[0][0]);
		System.out.println("3행 4열의 데이터 : " + twoArr[2][3]);
		System.out.println("행의 갯수 : " + twoArr.length);
		System.out.println("열의 갯수 : " + twoArr[0].length);
		
		System.out.print("3행의 데이터들 : ");
		for(int e : twoArr[2])
			System.out.print(e + " ");
		System.out.println();
		
		System.out.print("2열의 데이터들 : ");
		for(int i = 0; i < twoArr.length; i++)
			System.out.print(twoArr[i][2] + " ");
		System.out.println();
		
		System.out.print("왼쪽 대각선 데이터들 : ");
		for(int i = 0; i < twoArr.length; i++)
		System.out.print(twoArr[i][i] + " ");
		System.out.println();
		
		System.out.print("오른쪽 대각선 데이터들 : ");
		for(int i = 0; i < twoArr.length; i++)
			System.out.print(twoArr[i][twoArr.length-1-i] + " ");
		
		
	}

}

//[ 실습 1 ]
//1. TwoArrayLab1 라는 클래스를 만든다.
//2. 4개의 행과 4개의 열을 갖는 int 타입의 2차원 배열을 생성한다.
// 
//3. 다음과 같은 구성이 되도록 생성된 2차원 배열에 데이터를 대입한다.
//
//    10, 12, 14, 16
//    18, 20, 22, 24
//    26, 28, 30, 32
//    34, 36, 38, 40
//
//4. 출력형식
//
//    	1행 1열의 데이터 : 10
//   	3행 4열의 데이터 : 32
//	행의 갯수 : 4
//	열의 갯수 : 4
//	3행의 데이터들 : 26 28 30 32
//	2열의 데이터들 : 12 20 28 36
//             왼쪽 대각선 데이터들 : 10 20 30 40
//             오른쪽 대각선 데이터들 : 16 22 28 34
//
//   (*) 이 실습 문제를 해결할 때 제시된 배열은 4행 4열이지만 3행 3열 또는 5행 5열 등
//       사이즈가 다른 정방행열인 경우에도 요구사항이 처리될 수 있게 구현한다.    
