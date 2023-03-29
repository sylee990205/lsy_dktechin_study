package day18;

interface ActionExpression {
	void exec(Object... param);
}

interface FuncExpression<T> {
	T exec(Object... param);
}

public class LambdaTest12 {
	public static void test1(ActionExpression action) {
		action.exec("hello world");
	}

	public static void test2(FuncExpression<String> func) {
		String ret = func.exec("hello world", "aa", "11", "가나다");
		System.out.println(ret);
	}

	public static void main(String[] args) throws Exception {
		test1(new ActionExpression() {
			public void exec(Object... data) {
				System.out.println("Test1 - " + data[0]);
			}
		});
		// 변수 선언 시 new 뒤에 타입 파라미터를 생략할 수 있었지만 이렇게 사용하면 생략할 수 없음
		test2(new FuncExpression<String>() {
			public String exec(Object... data) {
				System.out.println(data[0]);
				return "OK1";
			}
		});

		test1((Object... data) -> System.out.println("Test2 - " + data[0]));
		
		
		test2((Object... data) -> {
			System.out.println(data[0]);
			return "OK2";
		});
		
		test1(data -> System.out.println("Test2 - " + data[0]));
		
		// 가변형 또한 타입이기에 생략 가능 - 단, 람다에서 가변형 인자를 사용한다면 배열이라고 생각하고 쓰는게 좋음
		test2(data -> {
			System.out.println(data[0]);
			return "OK2";
		});
	}
}
