package day4;

public class ArrayTest2 {

	public static void main(String[] args) {
		int score[] = new int[5];		
		System.out.println(score);
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
	
		int[] score1 = new int[]{100, 200, 300, 400};		
		System.out.println(score1);
		
		for (int i=0; i < score1.length; i++)
			System.out.println(score1[i]);
		
		int[] score2 = {1000, 2000};	// 배열변수 선언을 함께 하는 경우에만 가능	
										// 24행에서 score2에 새로운 배열을 생성하면 기존의 배열({1000,2000})이 쓰레기값이 된다. 이 값은 JVM이 알아서 처리함.
		System.out.println(score2);    // [I@73a28541, score2의 참조값
		for (int i=0; i < score2.length; i++)
			System.out.println(score2[i]);
		
		score2 = new int[]{11, 22, 33, 44, 55};
		System.out.println(score2);		// [I@6f75e721, score2의 참조값 - 같은 score2여도 참조하는 배열이 달라지기때문에 참조값이 달라진다.
		for (int i=0; i < score2.length; i++)
			System.out.println(score2[i]);		
	}
}
