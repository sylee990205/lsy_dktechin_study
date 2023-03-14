package day7.excercise;
import day5.excercise.*;

class GuGuDanExpr extends Multiplication{
	GuGuDanExpr(){
		
	}
	GuGuDanExpr(int dan){
		super(dan);
	}
	GuGuDanExpr(int dan, int number){
		super(dan, number);
	}
	
	public static void printAll() { // 다른 멤버들과 상호작용이 없으니 static 형으로 만들어도 되는 것
		
		for(int i = 1 ; i <= 9 ; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d\t",i,j,i*j);
			}
			System.out.println();
		}
		
	}
}

public class GuGuDanApp {

	public static void main(String[] args) {
		
		int dan = MethodLab5.getRandom(20); //히히 박수받았다
		int number = MethodLab5.getRandom(20);
		
		System.out.printf("dan : %d, number: %d\n",dan,number);
		
		if(dan < 10) {
			if(number < 10) {
				GuGuDanExpr gugudan = new GuGuDanExpr(dan,number);
				System.out.printf("%d * %d = ", dan, number);
				gugudan.printPart();
			}
			else {
				GuGuDanExpr gugudan = new GuGuDanExpr(dan);
				System.out.print(dan + "단 : ");
				gugudan.printPart();
			}
		}
		else {
			GuGuDanExpr.printAll(); //static 멤버임을 알 수 있다..
		}
		
		
	}

}
