package day14;

class Outer {
	void pr() {
		System.out.println("Outer's pr() Method !!");
	}

	class Inner {
		void pr() {
			System.out.println("Inner's pr() Method !!");
		}
	}

	static class Static_Inner {
		static void pr() {
			System.out.println("Static_Inner's pr() Method !!");
		}
		
		void prNstatic() {
			System.out.println("Static_Inner's pr() Method !!");
		}
	}
}

public class InnerTest1 {
	public static void main(String args[]) {
		// 내부 멤버를 static으로 설정한 경우
		Outer.Static_Inner.pr();
		// static으로 설정하지 않은 경우
		new Outer.Static_Inner().prNstatic();
		
		Outer o = new Outer();
		o.pr();
		Outer.Inner i = o.new Inner();
		i.pr();
		
	}
	
}
