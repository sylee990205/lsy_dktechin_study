package day5;
public class MethodTest4_1 {
	public static void main(String[] args) {
		System.out.println("main() 수행시작");
		printMyName(3, '*');
		printMyName("듀크", '$');
		printMyName("듀크", '$');
		printMyName("듀크", '$');
		printMyName("턱시", '!');
		printMyName(3,'$',"듀크");
		System.out.println("main() 수행종료");
	}	
	static void printMyName(int num, char deco) { 	// 동일한 이름의 메서드
		for(int i=1; i <= num; i++)					// 매개변수의 사양이 다름 (int, char) (String, char) -> 오버로딩했다.
			System.out.println(deco+"소영"+deco);
	}
	static void printMyName(String name, char deco) {
		System.out.println(deco+name+deco);
	}
	
	static void printMyName(int num, char deco, String name) { 	
		for(int i=1; i <= num; i++)					
			System.out.println(deco+name+deco);
	}
}
