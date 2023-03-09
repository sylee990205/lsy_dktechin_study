package day4.excercise;

public class TwoArrayLab3 {

	public static void main(String[] args) {
		int[][] time = {
				{5,2,1,0,2,3,6},
				{4,3,2,1,1,0,5},
				{3,1,2,1,3,1,3},
				{4,3,1,0,4,2,7}
				};
		char[] day = new char[] {'일','월','화','수','목','금','토'};
		int[] month = new int[7]; 
		
		
		//월별 7번 반복 4번 더하기
		for(int i = 0; i < time[0].length ; i++) {
			for(int j = 0; j < time.length; j++) {
				month[i] += time[j][i];
			}
			System.out.println(day[i]+"요일 : " + month[i] + "시간");
		}
		System.out.println();
		
		//주별 4번 반복 7번 더하기
		int[] week = new int[4]; 
		for(int i = 0; i < time.length; i++) {
			for(int j = 0; j<time[i].length; j++) {
				week[i] += time[i][j];
			}
			System.out.println((i+1) + "주차 : " + week[i] + "시간");
			
		}

	}

}
