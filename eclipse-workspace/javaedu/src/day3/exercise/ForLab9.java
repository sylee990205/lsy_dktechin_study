package day3.exercise;

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

//[ 실습5 ] 모양 출력(중첩 for)
//1. ForLab9 라는 클래스를 생성한다.
//2. 1 ~ 2 사이의 난수를 추출한다.
//3. 추출한 난수가 1이면 홀수단의 구구단을 다음과 같이 출력한다.
//
//    1x1=1	1x2=2	1x3=3	1x4=4	1x5=5	1x6=6	1x7=7	1x8=8	1x9=9	
//    3x1=3	3x2=6	3x3=9	3x4=12	3x5=15	3x6=18	3x7=21	3x8=24	3x9=27	
//    5x1=5	5x2=10	5x3=15	5x4=20	5x5=25	5x6=30	5x7=35	5x8=40	5x9=45	
//    7x1=7	7x2=14	7x3=21	7x4=28	7x5=35	7x6=42	7x7=49	7x8=56	7x9=63	
//    9x1=9	9x2=18	9x3=27	9x4=36	9x5=45	9x6=54	9x7=63	9x8=72	9x9=81	
//
//    추출한 난수가 2이면 짝수단의 구구단을 출력한다.
//
//    2x1=2	2x2=4	2x3=6	2x4=8	2x5=10	2x6=12	2x7=14	2x8=16	2x9=18	
//    4x1=4	4x2=8	4x3=12	4x4=16	4x5=20	4x6=24	4x7=28	4x8=32	4x9=36	
//    6x1=6	6x2=12	6x3=18	6x4=24	6x5=30	6x6=36	6x7=42	6x8=48	6x9=54	
//    8x1=8	8x2=16	8x3=24	8x4=32	8x5=40	8x6=48	8x7=56	8x8=64	8x9=72	