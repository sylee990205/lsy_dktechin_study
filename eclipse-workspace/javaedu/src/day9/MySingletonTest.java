package day9;

class MySingleton {
	// 메모리상에 로딩될때 MySingleton 객체를 미리 생성 --> 구현하기 나름	
	private static MySingleton obj = new MySingleton();
	private MySingleton() {		
	}
	
	
	
	static MySingleton getMy() {
		// 미리 생성한 객체를 return
		return obj;
	}
	void printMyName() {
		System.out.println("유니코");	
	}
	void printFavoriteFood() {
		System.out.println("떡볶이");	
	}
}
public class MySingletonTest {
	public static void main(String[] args) {
		//MySingleton my = new MySingleton(); //error 생성자가 private 하기 때문
		MySingleton my = MySingleton.getMy(); //객체 생성을 하려면 팩토리메서드 getMy()를 호출해야함
		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);
		System.out.println(MySingleton.getMy());
		System.out.println(MySingleton.getMy());
	}
}
