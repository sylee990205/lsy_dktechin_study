package day6.excercise;
import java.util.Scanner;


class CalculatorExpr {
	private int num1;
	private int num2;
	
	CalculatorExpr(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	
	int getAddition() {
		return num1 + num2;
	}
	
	int getSubtraction() {
		return num1 - num2;
	}
	
	int getMultiplication() {
		return num1 * num2;
	}
	
	double getDivision() {
		return num1 / num2;
	}
	
//	void setNum1(int num1) {
//		this.num1 = num1;
//	}
//	
//	void setNum2(int num2) {
//		this.num2 = num2;
//	}
}

public class CalculatorTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int keepGoing = 1; 
		int num1, num2;
		CalculatorExpr cal;
		while(keepGoing == 1) {
			System.out.print("연산할 숫자 두 개를 입력해주세요: ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			cal = new CalculatorExpr(num1, num2);
			System.out.printf("\n입력된 숫자: %d, %d\n", num1, num2);
			System.out.printf("덧셈 : %d\n", cal.getAddition());
			System.out.printf("뺄셈 : %d\n", cal.getSubtraction());
			System.out.printf("곱셈 : %d\n", cal.getMultiplication());
			System.out.printf("나눗셈 : %.2f\n", cal.getDivision());
			
			System.out.print("\n계속 진행하시겠습니까?\n계속하려면 1, 아니면 0을 입력해주세요.");
			keepGoing = sc.nextInt();
			System.out.println();
		}
		
		sc.close();
	}
	
}
