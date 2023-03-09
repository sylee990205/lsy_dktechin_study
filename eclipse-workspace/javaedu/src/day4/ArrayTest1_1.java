package day4;

public class ArrayTest1_1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		System.out.println(score);
		System.out.println(score.length);
		
		for (int e : score) // score 배열이 int형 배열이기에 for문 사용시 int를 사용해야함
			System.out.println(e);		
		
		for(int i=0; i < score.length; i++) // for문의 제어변수로 i를 사용하는건 인덱스의 의미가 큼
            score[i] = (i+1)*100;
		
		for (int e : score) // 배열에서는 e라고 명명하는게 좋음, foreach문은 앞에서부터 하나하나 읽어서 처리할 때만 사용, 변경해야하는 경우 사용할 수 없음
			System.out.println(e);
	}
}
