package day7;
public class BlockTest {
	static { //클래스 초기화 블럭, main보다 먼저 수행
		System.out.println("static 블럭 수행");
	}
	{ //인스턴스 초기화 블럭, 객체 생성될 때 생성자보다 먼저 수행
		System.out.println("instance 블럭 수행");
	}
	public BlockTest() {     
		System.out.println("생성자 수행");
	}
	public static void main(String args[]) {
		System.out.println("BlockTest bt = new BlockTest(); ");
		BlockTest bt = new BlockTest();
		System.out.println(bt);
		System.out.println("BlockTest bt2 = new BlockTest(); ");
		BlockTest bt2 = new BlockTest();
		System.out.println(bt2);
	}
}
