package day13;

enum Season { //enum type
	SPRING, SUMMER, FALL, WINTER //,로 구분해서 정의
}

public class EnumTest1 {
	public static void main(String args[]) {
		System.out.println(Season.SPRING);
		System.out.println(Season.SUMMER);
		System.out.println(Season.FALL);
		System.out.println(Season.WINTER);
		Season data1 = Season.FALL;
		if (data1 == Season.FALL)
			System.out.println("당신이 좋아하는 계절은 가을!!");

		switch (data1) { // Enum은 switch가 가능
		case SPRING:
			System.out.println("대저토마토");
			break;
		case SUMMER:
			System.out.println("복숭아");
			break;
		case FALL:
			System.out.println("홍로");
			break;
		case WINTER:
			System.out.println("레드향");
			break;
		}

		for (Season v : Season.values()) // values() 메소드가 자동으로 만들어짐, Enum 안에 정의되어있는 리스트들을 배열로 보여주는 메소드
			System.out.print(v + " "); // 컴파일시 클래스로 취급됨. Enum 을 상속받는 클래스로, toString
		System.out.println();
		
		Season data2 = Season.valueOf("SUMMER"); // valueOf()도 자동으로 만들어짐. SUMMER 라는 값을 줘서 만족하는 Enum 객체를 return
		System.out.println(data2);
	}
}
