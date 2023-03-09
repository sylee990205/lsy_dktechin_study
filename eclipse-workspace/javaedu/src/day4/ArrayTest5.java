package day4;

public class ArrayTest5 {
	public static void main(String[] args) {
		int nums[] = { 10, 5, 7, 6, 21, 3, 22, 18, 9, 2, 25, 14 };
		// nums 배열의 크기
		System.out.println(nums.length);
		// (1) 첫번째 원소만 출력해 보기
		System.out.println(nums[0]);
		// (2) 마지막 원소만 출력해 보기
		System.out.println(nums[nums.length-1]);
		// (3) 첫번째 원소부터 마지막 원소까지 하나의 행에 공백을 분리자로 해서 출력
		for(int i=0; i < nums.length; i++)
			System.out.print(nums[i]+" ");
		System.out.println();
		for(int d : nums)
			System.out.print(d+" ");
		System.out.println();
		// (4) 홀수번째 원소들을 하나의 행에 공백을 분리자로 해서 출력
		for(int i=0; i < nums.length; i+=2)
			System.out.print(nums[i]+" ");
		System.out.println();
		// (5) 모든 원소들을 역순으로 하나의 행에 공백을 분리자로 해서 출력
		for(int i=nums.length-1; i >= 0; i--)
			System.out.print(nums[i]+" ");
		// (6) 모든 원소들의 합을 구해서 sumV 라는 변수에 담고 출력
		int sumV = 0;
		for(int d : nums)
			sumV += d;
		System.out.println("\n"+sumV);		
		// (7) 원소값이 짝수인 원소들의 합을 구해서 evenSumV 라는 변수에 담고 출력
		int evenSumV = 0;
		for(int d : nums) 
			if (d % 2 == 0)
				evenSumV += d;
		System.out.println(evenSumV);
		
	}
}
