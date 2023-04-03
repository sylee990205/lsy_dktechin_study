package day3.exercise;

public class WhileLab2 {

	public static void main(String[] args) {
		
		int pairNum1, pairNum2;
		
		while(true) {
			pairNum1 = (int)(Math.random()*6) + 1;
			pairNum2 = (int)(Math.random()*6) + 1;
			
			if(pairNum1 > pairNum2) {
				System.out.printf("pairNum1이 pairNum2보다 크다.");
			}
			else if(pairNum1 < pairNum2){
				System.out.printf("pairNum1이 pairNum2보다 작다.");
			}
			else {
				System.out.println("게임 끝");
				break;
			}		
		}
		
	}

}

//[ 실습2 ] - while 문은 무한루프 처리하고 루프를 끝낼 때는 break 문 사용
//
//1. WhileLab2 이라는 클래스를 생성한다.
//2. 다음 기능을 반복해서 수행하는 프로그램을 구현하며
//    반복문으로 while 문을 사용한다.
//
//    - 반복처리 해야하는 기능
//       1부터 6사이의 두개 난수를 추출하여 각각 pairNum1, pairNum2 에 저장한다.
//
//       추출된 두 개의 숫자가 서로 다르면 값의 크기를 비교하여 
//       "pairNum1이 pairNum2 보다 크다." 또는 "pairNum1이 pairNum2 보다 작다." 
//       출력한다.
//    
//       추출된 두 개의 숫자가 동일하면 "게임 끝"이라는 메시지를 출력하고 종료한다.