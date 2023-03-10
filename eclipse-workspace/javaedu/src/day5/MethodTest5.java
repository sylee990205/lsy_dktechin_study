package day5;
public class MethodTest5 {
	public static void main(String[] args) {
		System.out.println("main() 수행시작");
		int result = operate(10,20);
		System.out.println("호출 결과1 : "+result);
		System.out.println("호출 결과2 : "+operate(100,200));
		int result2 = operate(11,22) % 2;
		if(result2 == 0)
			System.out.println("호출 결과3 짝수");
		else
			System.out.println("호출 결과3 홀수");
		System.out.println("호출 결과4 : "+operate(100,200,300));
		System.out.println(getName());
		System.out.println("*" + getName() + "*");
		System.out.println("main() 수행종료");
	}	
	static int operate(int num1, int num2) { // 메서드 오버로딩
		return num1+num2;					 // return 값을 만약 여러개 전달하고 싶으면 배열을 사용해야함. int[] 를 리턴값타입으로
	}
	static int[] operate(int num) { // 메서드 오버로딩
		int[] array = new int[num]; // return 값을 만약 여러개 전달하고 싶으면 배열을 사용해야함. int[] 를 리턴값타입으로
		for(int i = 0; i < num ; i++) {
			array[i] = num++;
		}
		return array;					 
	}
	
	static int operate(int num1, int num2, int num3, int num4) {
		if (num1 > 0)
			return num1+num2+num3+num4;
		else
			return 0;
	}
	
	static int operate(int num1, int num2, int num3) {
		return num1+num2+num3;
	}
	static String getName() {
		return "이소영";
	}
}







