package day3.excercise;

public class ForLab5 {

	public static void main(String[] args) {
		int ran_num1 = (int)(Math.random()*8) + 3;
		int ran_num2 = (int)(Math.random()*3) + 1;
		
		// 최적 코드
		char c;
		if (ran_num2 == 1)
			c = '*';
		else if (ran_num2 == 2)
			c = '$';
		else
			c = '#';
		
		for (int i = 1 ; i <= ran_num1; i++)
			System.out.print(c);

// 내 코드, 같은 for 문이 계속 반복됨.
//		switch (ran_num2) {
//			case(1):
//				for(int i = 1; i <= ran_num1; i++)
//					System.out.print("*");
//				break;
//			case(2):
//				for(int i = 1; i <= ran_num1; i++)
//					System.out.print("$");
//				break;
//			case(3):
//				for(int i = 1; i <= ran_num1; i++)
//					System.out.print("#");
//				break;
//		}
		
	}

}
