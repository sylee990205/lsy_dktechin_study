package day18;

@FunctionalInterface
interface MyFunctionalInterface3 {
	public int method3(int x, int y);
}

public class LambdaTest7 {
	public static void main(String[] args) {
		MyFunctionalInterface3 fi = (x, y) -> { // 1
			int result = x + y;
			return result;
		};
		System.out.println(fi.method3(1, 1));

		fi = (x, y) -> { // 2
			return x + y;
		};
		System.out.println(fi.method3(2, 1));

		fi = (x, y) -> x + y; // 3
		System.out.println(fi.method3(3, 1));

		fi = (x, y) -> Math.addExact(x, y); // 4
		System.out.println(fi.method3(4, 1));

		fi = Math::addExact; // 5
		System.out.println(fi.method3(5, 1));

		fi = (x, y) -> sum(x, y); // 6
		System.out.println(fi.method3(6, 1));

		fi = LambdaTest7::sum; // 7
		System.out.println(fi.method3(7, 1));
	}

	public static int sum(int x, int y) {
		return (x + y);
	}
}
