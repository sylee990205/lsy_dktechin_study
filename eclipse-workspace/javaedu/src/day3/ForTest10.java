package day3;

public class ForTest10 {
	public static void main(String[] args) {
		final char DECO = '*';
		for (int row = 1; row <= 10; row++) { // 10번 반복 
			for (int count = 1; count <= row; count++) // 밖에 for문이 한번 반복될 때마다 달라짐.
				System.out.print(DECO);
			System.out.println();
		}

		System.out.println();
		for (int count = 1; count <= 1; count++)
			System.out.print('@');
		System.out.println();
		for (int count = 1; count <= 2; count++)
			System.out.print('@');
		System.out.println();
		for (int count = 1; count <= 3; count++)
			System.out.print('@');
		System.out.println();
		for (int count = 1; count <= 4; count++)
			System.out.print('@');
		System.out.println();
		for (int count = 1; count <= 5; count++)
			System.out.print('@');
	}
}
