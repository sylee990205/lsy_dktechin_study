package day3.excercise;

public class ForLab6 {

	public static void main(String[] args) {
		final char DECO = '&';
		int ran_num = (int)(Math.random()*6) + 5;
		
		// if(ran_num == 5 || ran_num == 7) 
		for(int i = 1; i <= ran_num; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(DECO);
			}
			System.out.println();
		}
		

	}

}
