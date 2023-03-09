package day4;

public class ArrayTest4 {

	public static void main(String[] args) {
		// 5개의 정수 데이터를 저장할 배열을 생성하여 nums 배열 변수에 저장한다.
		int[] nums = new int[5];
		// 각각의 엘리먼트로 1~45 사이의 난수를 꺼내서 저장한다.
		
		for(int i=0; i < nums.length; i++)
			nums[i] = (int)(Math.random()*45) + 1;
		
		for(int i=0; i < nums.length; i++) // for
			System.out.print(nums[i]+ " ");
		System.out.println();
		for(int data : nums)  // foreach
			System.out.print(data+ " ");
		
		// nums 라는 배열 변수가 참조하는 배열에서  최대값을 추출하여 출력해 보자.
		int bigNum = nums[0];
		int minNum = nums[0];
		for(int i=1; i < nums.length;i++) { // 최소, 최대값을 뽑는 api가 있다고함.
			if (bigNum < nums[i])
				bigNum = nums[i];
			if (minNum > nums[i])
				minNum = nums[i];
		}
		System.out.printf("\nnums라는 배열에서 제일 큰 값 : %d", bigNum);
		System.out.printf("\nnums라는 배열에서 제일 작은 값 : %d", minNum);
	}

}
