package day5;

public class MethodTest10_1 {

	public static void main(String[] args) {
		int[][] nums = new int[5][3];
		int num=1;
		
		printTwoArray(nums);
		
		System.out.println();
		for (int j=0; j < 3; j++) {
			for (int i=j; i < 5-j; i++)
				nums[i][j] = num++;
		}
		
		printTwoArray(nums);
	}
	static void printTwoArray(int[][] nums) {
		for (int i=0; i < nums.length; i++) {
			for (int j=0; j < nums[i].length; j++)
				System.out.print(nums[i][j]+"\t");
			System.out.println();
		}
	}
}
