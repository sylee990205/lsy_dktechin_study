package day17;

@FunctionalInterface // 함수형 인터페이스 체크 어노테이션
interface MyNumber {
	int getMax(int num1, int num2);
}

public class LambdaTest3 {
	public static void main(String[] args) {
		// 람다는 어차피 객체가 생성되는것이기 때문에 interface를 상속하는 클래스를 생성할 필요 없음
		// 객체형 변수를 생성해서 해당 변수로 활용할 수 있음.
		MyNumber max1 = new MyNumber() {
			public int getMax(int x, int y) {
				return (x >= y) ? x : y;
			}
		};
		System.out.println(max1.getMax(100, 300));

		MyNumber max2 = (int x, int y) -> {
			return (x >= y) ? x : y;
		};

		System.out.println(max2.getMax(100, 300));

		MyNumber max3 = (x, y) -> (x >= y) ? x : y;

		System.out.println(max3.getMax(100, 300));		
	}
}
