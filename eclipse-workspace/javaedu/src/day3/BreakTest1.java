package day3;

public class BreakTest1 {      
// 중첩된 반복문 내에서 break
	public static void main(String[] args) {
		int result;
		for(int dan = 1; dan <= 9; dan++) {
			for(int num=1; num <= 9; num++) {
				result = dan*num;
				if (result >= 30) // 구구단의 결과값이 30보다 작은 것만 출력된다.
					break; // 중첩된 반복문에서는 가장 가까운 반복문만 빠져나감.
				System.out.print(dan + "x" + num + "=" + result + "\t");
			}
			System.out.println();
		}		
	}
}
