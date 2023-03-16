package day9;
import java.util.Random;
interface Drawable {
	// 인터페이스
	// 객체 생성 불가, 상속으로만 사용 가능
	 void draw();
}
class Rect implements Drawable {
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}
}
class Circle implements Drawable {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}
class Diamond implements Drawable  {
	public void draw() {
		System.out.println("마름모를 그립니다.");
	}
}
public class DrawableTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int num = rand.nextInt(3);
		Drawable d = null; // 객체를 참조하는 변수는 초기화 시 null - 참조할 객체가 아직 존재하지않는다는 의미, 0으로 초기화할 수 없다
		if(num == 0)
			d = new Rect();
		else if(num == 1)
			d = new Circle();		
		else if(num == 2)
			d = new Diamond();		
		output(d);
	}
	public static void output(Drawable d){
		System.out.println("전달된 객체의 클래스명 : "+
	                        d.getClass().getName());
		d.draw();
	}
}



