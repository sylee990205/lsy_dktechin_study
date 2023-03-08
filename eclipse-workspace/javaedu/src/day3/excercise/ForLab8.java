package day3.excercise;

public class ForLab8 {

	public static void main(String[] args) {
		
//		for(int i = 1 ; i <= 5 ; i++) {
//			for(int j = 1; j <= i ; j++) {
//				System.out.print(' ');
//			}
//			System.out.println("**********");
//		}

		// 이렇게 구현하라고 낸 문제
		final char STAR = '*';
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 0; j < i-1 ; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j<=10; j++) {
				System.out.print(STAR);
			}
			System.out.println();
		}
		
	}

}
