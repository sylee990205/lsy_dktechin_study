package day18;

@FunctionalInterface
interface MyFunctionalInterface5 {
	public int[] method5(int size); // 배열도 가능!
}

public class LambdaTest9 {
	public static void main(String[] args) {
		MyFunctionalInterface5 fi = (int size) -> {
			return new int[size];
		};
		System.out.println(fi.method5(10).length);

		fi = size -> {
			return new int[size];
		};
		System.out.println(fi.method5(5).length);

		fi = size -> new int[size];
		System.out.println(fi.method5(8).length);

		fi =  int[]::new; //배열을 생성하는 식으로도 람다를 사용할 수 있다.
		System.out.println(fi.method5(20).length);		
	}
}
