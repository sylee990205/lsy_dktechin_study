package day4.excercise;

public class TwoArrayLab4 {

	public static void main(String[] args) {
		int[][] twoArr = new int[4][];
		twoArr[0] = new int[] {10, 20, 30, 40, 50};
		twoArr[1] = new int[] {5, 10, 15};
		twoArr[2] = new int[] {11, 22, 33, 44};
		twoArr[3] = new int[] {9,8,7,6,5,4,3,2,1};
		int sum;
		for(int i = 0; i < twoArr.length ; i++) {
			sum = 0;
			for (int j = 0; j < twoArr[i].length ; j++) {
				sum += twoArr[i][j];
			}
			System.out.println((i+1)+"행의 합은 " + sum +" 입니다.");
		}

	}

}

//1. TwoArrayLab4 라는 클래스를 만든다.
//2. 다음 사양의 int 타입 2차원 배열을 생성한다.
//
//    1행   10, 20, 30, 40, 50
//    2행   5, 10, 15
//    3행  11, 22, 33, 44
//    4행  9, 8, 7, 6, 5, 4, 3, 2, 1
//
//3. 행단위 합을 구하여 다음과 같이 출력한다.
//
//    1행의 합은 x 입니다.
//    2행의 합은 x 입니다.
//    3행의 합은 x 입니다.
//    4행의 합은 x 입니다.