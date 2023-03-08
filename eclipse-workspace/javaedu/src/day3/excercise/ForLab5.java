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

//[ 실습 1 ]
//1. ForLab5 이라는 클래스를 만든다.
//2. 3부터 10사이의 난수를 추출한다.(첫 번째 난수)
//3. 1부터 3사이의 난수를 추출한다.(두 번째 난수)
//4. 두 번째 난수값이 1이면 "*"을 첫 번째 난수값의 갯수로 하나의 행에 출력한다.
//    두 번째 난수값이 2이면 "$"을 첫 번째 난수값의 갯수로 하나의 행에 출력한다.
//    두 번째 난수값이 3이면 "#"을 첫 번째 난수값의 갯수로 하나의 행에 출력한다.