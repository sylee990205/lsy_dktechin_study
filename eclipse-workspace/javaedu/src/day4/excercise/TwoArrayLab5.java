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
		
		for(int num = 0; num < 9; num++) {
			if (num < 5) {
				twoArr[num][0] = num + 1;
			}
			else if (num + 1 >= 6 && num + 1 <= 8) {
				twoArr[num-4][1] = num + 1;
			}
			else
				twoArr[num-6][2] = num + 1;
		
		}
		// 이거만 
		for(int j = 0; j < twoArr[0].length; j++) {
			for (int i = j; i < twoArr.length - j ; i++)
				twoArr[i][j] = i + (4 * j);
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
