package day2.exercise;

public class ForLab3 {

	public static void main(String[] args) {
		int num1 = (int)(Math.random()*10) + 1;
		int num2 = (int)(Math.random()*11) + 30; // 11을 곱하면 0~10까지가 나옴. 어떤 숫자~어떤 숫자일땐 최소값을 더하면 됨. 1~10 이면 1, 30~40이면 30 / 곱하는 값은 최대-최소+1, 1~10은 10-1+1 = 9
		int result = 0;
		
		for(int i = num1;i <= num2;i++) {
			if(i % 2 == 0)
				result += i;
//			else
//				continue; 있으나 없으나 결과 똑같은 dead code, 구현 안하는게 좋음
		}
		
		System.out.println(num1 + " 부터 " + num2 + " 까지의 짝수의 합 : " + result);
				
	}

}

//[ 실습 5 ]
//1. ForLab3 이라는 클래스를 만든다.
//2. 1부터 10사이의 난수를 하나 추출한다.
//3. 30부터 40사이의 난수를 하나 추출한다.
//4. 첫번째 난수부터 두번째 난수 까지의 숫자들 중에서 짝수의 합을 구해
//    다음 형식으로 출력한다.
//
//    X 부터 Y 까지의 짝수의 합 : XX