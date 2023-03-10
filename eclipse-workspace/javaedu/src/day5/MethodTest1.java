package day5;
public class MethodTest1 {
	public static void main(String[] args) { //main 메서드는 JVM이 호출
		System.out.println("main() 수행시작"); 
		printMyName(); //메서드 호출 식으로 구성된 수행명령
		System.out.println(1); //System.out.println()도 메서드를 호출하는 것임
		printMyName();
		System.out.println(2);
		printMyName();
		System.out.println(3);
		System.out.println("main() 수행종료");
	}
	static void printMyName() {
		System.out.println("이소영");
		return; //return 값이 없다면 return 뒤에 매개변수가 없어야함, 메서드를 호출한 곳으로 다시 되돌아가라
				//return 문을 안줘도 다시 돌아감. 생략 가능
	}
}
