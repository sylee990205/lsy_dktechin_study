package day14;

abstract class Test {
	Test() {
		System.out.println("No Argument sample");
	}

	abstract void output(String s);
}

public class InnerTest3 {
	void pr(Test o) {
		o.output("Test");
	}

	public static void main(String args[]) {
		System.out.println("Main start !!");
		InnerTest3 n = new InnerTest3();
		n.pr(new Test() { // Test()의 자식이 되는 클래스를 생성함과 동시에 객체 생성
			int su = 100;

			public void output(String s) {
				System.out.println("Anonymous Class : " + s);
				System.out.println("Anonymous Class : " + su);
			}
		});
	}
}
