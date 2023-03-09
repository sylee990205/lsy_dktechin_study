package day4.excercise;

public class LottoMachine1 {

	public static void main(String[] args) {
		// 내가 푼 방법 : 값 비교 - for문을 너무 많이 돌려서 과부하가 올 수도 있는 위험성이 있음
		int[] lotto = new int[6];
	
		for(int i = 0; i < lotto.length ; i++) {
			lotto[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i ; j++) {
				if(lotto[i] == lotto[j])
					i--;
				}
			}
		System.out.printf("오늘의 로또 번호 - ");
		for(int i = 0; i < lotto.length; i++) {
			if(i == lotto.length - 1)
				System.out.print(lotto[i]);
			else
				System.out.print(lotto[i] + ",");
		}
		
		//값 비교가 아닌 인덱스를 비교하는 방법
		int[] lotto_2 = new int[45]; // 크기가 45인 정수형 배열
		
		for(int i = 0; i < lotto_2.length ; i++) { //배열에 1~45까지 저장
			lotto_2[i] = (i+1);
		}
		
		int temp, j;
		
		System.out.printf("\n오늘의 로또 번호2 - ");
		
		for(int i = 0; i < 6; i++) {
			j = (int)(Math.random() * 45); // 랜덤으로 인덱스를 선택한다.
			temp = lotto_2[i]; // 인덱스가 i인 배열의 값을 temp로 이동
			lotto_2[i] = lotto_2[j]; // 랜덤으로 선택된 인덱스 j의 배열의 값을 인덱스가 i인 배열의 값으로 저장
			lotto_2[j] = temp; // temp에 저장된 값을 인덱스 j의 배열의 값으로 
			
			// 위 세 과정을 통해 값을 선택해서 교환한다. 중복이 일어날 수 없고 반복도 많이하지않아서 좋음.
			
			if(i == 5)
				System.out.print(lotto_2[i]);
			else
				System.out.print(lotto_2[i] + ",");
		}
		
	}

}

//[ 실습 5 ] 
//1. LottoMachine1 이라는 클래스를  생성한다.
//2. 1부터 45 사이의 난수 6개를 추출하여 다음 형식으로 출력한다.
//    단, 6개 숫자는 중복을 허용하지 않는다.
//
//    [ 출력형식 ]
//
//    오늘의 로또 번호 - x, x, x, x, x, x
