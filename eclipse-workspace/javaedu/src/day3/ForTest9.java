package day3;

public class ForTest9 {      

	public static void main(String[] args) {		
		for(int dan = 1; dan <= 9; dan++) { //for문 중첩 구현
			for(int num=1; num <= 9; num++)
				System.out.print(dan + "x" + num + "=" + dan*num + "\t");		
			System.out.println();
		}
		
		/* 직접 작성해보기
		 * for(int dan = 1; dan <= 9; dan++) { for (int num = 1; num <= 9; num++) {
		 * System.out.print(dan + "x" + num + "=" + dan*num + "\t"); }
		 * System.out.println(); }
		 */
	}
}
