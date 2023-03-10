package day5;

public class MethodTest10 {

	public static void main(String[] args) {
		int[][] nums = new int[5][3];
		int num=1;
		for (int i=0; i < nums.length; i++) {
			for (int j=0; j < nums[i].length; j++)
				System.out.print(nums[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
		for (int j=0; j < 3; j++) {
			for (int i=j; i < 5-j; i++)
				nums[i][j] = num++;
		}
		for (int i=0; i < nums.length; i++) {
			for (int j=0; j < nums[i].length; j++)
				System.out.print(nums[i][j]+"\t");
			System.out.println();
		}
	}
}
