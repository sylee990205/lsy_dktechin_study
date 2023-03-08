package day3;

public class BreakTest2 {      

	public static void main(String[] args) {
		int result;
		unico: for(int dan = 1; dan <= 9; dan++) { // 라벨, for문에 이름을 지정한다.
			for(int num=1; num <= 9; num++) {
				result = dan*num;
				if (result >= 30)
					break unico;
				System.out.print(dan + "x" + num + "=" + result + "\t");
			}
			System.out.println();
		}		
	}
}
