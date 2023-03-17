package day10.case1;
public class TVUser {
	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		
		// LgTV tv = new LgTV();
		// LgTV로 정의하면 error, 같은 기능 다른 메서드 이름
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}
}
