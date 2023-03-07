package day2;

public class ForTest3 {

	public static void main(String[] args) {
		for(int n=1; n < 20; n++) // 19번 반복되고 1부터 19까지 출력된다.
			System.out.print(n+ " ");
		System.out.println();
		
		for(int n=10; n > 0; n--) // 10번 반복되고 10부터 1까지 출력된다.
			System.out.print(n+ " ");
		System.out.println();
		
		for(int n=1; n < 20; n += 3) //7번 반복하고 1, 4, 7, 10, 13, 16, 19가 출력된다.
			System.out.print(n+ " ");
		System.out.println();
		
		// 1월~12월 까지 하나의 행에 출력해 보자. 
		int month=1;
		for(; month <= 12; month++)
			System.out.print(month+ "월 ");
		System.out.println();
		System.out.println(month);
	}

}
