package day9;

interface Printable {
	//명시적 초기화가 default
	public static final int PRINT_TYPE1 = 1;
	static final int PRINT_TYPE2 = 2;
	final int PRINT_TYPE3 = 3;
	int PRINT_TYPE4 = 4;

	public abstract void print(int type);
	abstract void setPage(int su);
	boolean isAvailable();
}

abstract class Shape3 {
	String color;

	abstract void draw();

	void setColor(String color) {
		this.color = color;
	}
}

class Circle3 extends Shape3 implements Printable {
	int page;

	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}

	public void print(int type) {
		System.out.println(type + "번 방식으로 " + page + "페이지를 프린팅한다.");
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isAvailable() {
		if (color.equals("흰색"))
			return false;
		else
			return true;
	}
}

class Rectangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 사각형을 그리는 기능");
	}
}

class Triangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 삼각형을 그리는 기능");
	}
}

public class InterfaceTest1 {
	public static void main(String args[]) {
		printOut(new Circle3());
		//printOut(new Rectangle3()); // 컴파일 오류가 발생하는 행
		// rectangle은 printable 객체를 가질 수 없다
	}

	static void printOut(Printable prt) {
		prt.setPage(100);
		// 접근 시마다 형변환해서 사용
		((Circle3)prt).draw();
		((Circle3) prt).setColor("파란색");
		
		// 객체에 담아 사용
		Circle3 cobj = (Circle3)prt;
		cobj.draw();
		cobj.setColor("노란색");
		
		if (prt.isAvailable())
			prt.print(Printable.PRINT_TYPE2);
	}
}
