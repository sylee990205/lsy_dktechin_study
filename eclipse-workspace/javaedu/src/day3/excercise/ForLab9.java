package day3.excercise;

public class ForLab9 {

	public static void main(String[] args) {
		int ran_num = (int)(Math.random()*2)+1;
		
//		if(ran_num == 1) {
//			for(int i = 1; i<=9; i++) {
//				if(i % 2 == 1)
//					for(int j = 1; j <= 9 ; j++)
//						System.out.print(i + "x" + j + "=" + i*j + "\t");	
//				else
//					continue; // 공백 제거
//			System.out.println();
//			}
//		}
//		else
//			for(int i = 1; i<=9; i++) {
//				if(i % 2 == 0)
//					for(int j = 1; j <= 9 ; j++)
//						System.out.print(i + "x" + j + "=" + i*j + "\t");
//				else
//					continue;
//			System.out.println();
//			}
		
		for(int i = ran_num; i <= 9; i+=2) { // ran_num이 1이면 2씩 증가할시 1,3,5 이렇게 증가하기때문에 간단하지만 정확한 코드가 나온다.
			for(int j = 1; j <= 9; j++) {
				System.out.print(i + "x" + j + "=" + i*j + "\t");
			}
			System.out.println();
		}
		
	}

}
