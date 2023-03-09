package day4;

public class TwoArrayTest1 {
	public static void main(String[] args) {
		int[][] two = new int[2][10];
		System.out.println(two); // 행의 배열의 참조값 , [[I@7d6f77cc (대괄호 2개 == 2차원 배열)
		System.out.println(two[0]); //첫번째 행에 의한 열의 배열의 참조값
		System.out.println(two[0][0]);	//첫번째 행의 첫번째 열의 요소
		System.out.println(two.length); // 행의 갯수
		System.out.println(two[0].length); //첫번째 행이 참조하는 열의 갯수
		
		for(int row=0;row < two.length;row++) { //2번 반복
			for(int col=0; col < two[row].length; col++) //10번 반복
				System.out.print(two[row][col]+" ");
			System.out.println();
		}
	}
}



