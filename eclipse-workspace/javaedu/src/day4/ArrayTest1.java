package day4;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		System.out.println(score); // [I@7d6f77cc , score 배열의 참조값 @ 뒤가 참조값임 @앞은
		System.out.println(score.length);
		
		for (int i=0; i < score.length; i++) // for문 지정시 <로 해야함을 기억하자, length와 길이가 같거나 작으면 index 범위를 벗어나기에 오류가 발생 ArrayIndexOutOfBoundsException)
			System.out.println(score[i]);
		
		for(int i=0; i < score.length; i++)
            score[i] = (i+1)*100;
		
		for (int i=0; i < score.length; i++)
			System.out.println(score[i]);
	}
}
