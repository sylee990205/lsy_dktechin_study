package day10.exercise;
import java.util.Random;


public class LottoMachine {
	private int[] nums;
	
	
	public LottoMachine(){
		nums = new int[6];
	}
	
	public void createLottoNums() {
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(20) + 1;
		}
	}
	
	public void checkLottoNums() throws DuplicateException{

//		중첩된 for문 사용 (뒤의 배열과 비교)
//		int check = nums[0];
//		
//		for (int i = 1; i < nums.length; i++) {
//			for(int j = i; j < nums.length; j++) {
//				if(check == nums[j]) {
//					throw new DuplicateException();
//				}
//			}	
//			check = nums[i];
//		}
		
//		중첩된 for문 사용 (앞의 배열과 비교)
		
		
// 				
		int[] check = new int[21];
		
		for(int c : nums) {
			if(check[c] == 1) {
				throw new DuplicateException();
			}
			else {
				check[c] = 1;
			}
		}
		
		
		
		
	}
	
	public int[] getNums() {
		return nums;
	}
	
}
