package day17;

interface Sample {
	int calc(int n);
}

class MyTest {
	static void pr(Sample p) {
		System.out.println(p.calc(10));
	}
}

public class LambdaTest1 {
	public static void main(String[] args) {
		class SampleImpl implements Sample {
			// Sample을 추가 상속하는 SampleImpl 클래스를 만들어 calc를 오버라이딩함
			public int calc(int n) {
				return n + 1;
			}
		}
		Sample obj = new SampleImpl(); // SampleImpl() 객체를 생성
		MyTest.pr(obj); // 11

		MyTest.pr(new Sample() { // anonymous Inner class를 사용하여 calc를 바로 오버라이딩 -> 20
			public int calc(int n) { 
				return n + 10;
			}
		});

		MyTest.pr((int n) -> { //람다 110
			return n + 100;
		});
		MyTest.pr((n) -> { //매개변수 타입을 생략한 람다 110
			return n + 100;
		});
		MyTest.pr(n -> { //매개변수 타입 및 괄호를 생략한 람다 110
			return n + 100;
		});
		MyTest.pr(n -> n + 100); //매개변수 타입, 괄호, return을 생략한 람다
	}
}
