package day9;

class MySingleton2 {
	// 클래스 로딩시 객체 생성을 하지 않고
	private static MySingleton2 obj = null;
	private MySingleton2() {		
	}
	static MySingleton2 getMy() {
		// getMy 호출 시 객체 생성하여 return
		if (obj == null)
			obj = new MySingleton2();
		
		// 생성한 객체를 return
		return obj;
	}
	void printMyName() {
		System.out.println("듀크");	
	}
	void printFavoriteFood() {
		System.out.println("갈비");	
	}
}
public class MySingletonTest2 {
	public static void main(String[] args) {
		//MySingleton2 my = new MySingleton2(); //error 생성자가 private 하기 때문
		MySingleton2 my = MySingleton2.getMy(); //객체 생성을 하려면 팩토리메서드 getMy()를 호출해야함
		my.printMyName();
		my.printFavoriteFood();
		System.out.println(my);
		System.out.println(MySingleton2.getMy());
		System.out.println(MySingleton2.getMy());
	}
}
