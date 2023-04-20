package day2.sample1;

public interface MessageBean {
	// 반드시 interface로 생성하여 오버라이딩을 해야하는것은 아니지만 확장성 방면에서 보다 좋음
	public void sayHello();
	public void sayHello(String a, int b);
}
