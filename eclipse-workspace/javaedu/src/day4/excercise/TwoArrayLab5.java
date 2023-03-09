package day4.excercise;

public class TwoArrayLab5 {

	public static void main(String[] args) {
		int[][] twoArr = new int[5][3];
		
		for(int i = 0; i < twoArr.length; i++) {
			for(int j = 0; j < twoArr[0].length ; j++) {
				System.out.print(twoArr[i][j] + "\t");
			}
			System.out.println();
		}
		// if로 푼 식
//		for(int num = 0; num < 9; num++) {
//			if (num < 5) {
//				twoArr[num][0] = num + 1;
//			}
//			else if (num + 1 >= 6 && num + 1 <= 8) {
//				twoArr[num-4][1] = num + 1;
//			}
//			else
//				twoArr[num-6][2] = num + 1;
//		
//		}
		// 순서도를 사용한 식 
		for(int j = 0; j < twoArr[0].length; j++) {
			for (int i = j; i < twoArr.length - j ; i++)
				twoArr[i][j] = i + 1 + j * (twoArr.length - j);
				}
		
		System.out.println();
		for(int i = 0; i < twoArr.length; i++) {
			for(int j = 0; j < twoArr[0].length ; j++) {
				System.out.print(twoArr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}

//[ 실습5 ]
//
//1. TwoArrayLab5 라는 클래스를 만든다.
//
//2. 5개의 행과 3개의 열을 갖는 int 타입의 2차원 배열을 생성하여 다음과 같이 출력한다.
//
//	0	0	0	
//	0	0	0	
//	0	0	0	
//	0	0	0	
//	0	0	0	
// 
//3. 2번에서 만든 2차원 배열에 다음과 같이 구성되도록 데이터를 대입한다.
//	
//	1	0	0		
//	2	6	0		
//	3	7	9		
//	4	8	0		
//	5	0	0	
//
//(*) 2번에서의 출력과 3번에서의 출력 사이에는 빈행을 출력한다.
//     또한 규칙을 잘 찾아서 로직을 잘 구현해 본다.
//
//- 수행 결과
//
//0	0	0	
//0	0	0	
//0	0	0	
//0	0	0	
//0	0	0	
//
//1	0	0	
//2	6	0	
//3	7	9	
//4	8	0	
//5	0	0