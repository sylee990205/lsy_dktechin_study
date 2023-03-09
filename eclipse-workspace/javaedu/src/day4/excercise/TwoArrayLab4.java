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
