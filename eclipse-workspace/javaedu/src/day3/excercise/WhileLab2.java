package day3.excercise;

public class WhileLab2 {

	public static void main(String[] args) {
		
		int pairNum1, pairNum2;
		
		while(true) {
			pairNum1 = (int)(Math.random()*6) + 1;
			pairNum2 = (int)(Math.random()*6) + 1;
			
			if(pairNum1 > pairNum2) {
				System.out.printf("%d이(가) %d보다 크다\n",pairNum1,pairNum2);
			}
			else if(pairNum1 < pairNum2){
				System.out.printf("%d이(가) %d보다 작다\n",pairNum1,pairNum2);
			}
			else {
				System.out.println("게임 끝");
				break;
			}		
		}
		
	}

}
