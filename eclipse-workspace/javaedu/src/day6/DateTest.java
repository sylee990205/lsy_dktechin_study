package day6; //기본적인 순서는 반드시 지켜야함 패키지 - import - 클래스
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		java.util.Date today = new java.util.Date(); // 자바에 내장된 클래스를 사용
		//클래스 이름 앞에 패키지 명을 쓰는게 번거롭다면 import를 사용
		Date today2 = new Date();
		System.out.println(today.toString());
		System.out.println(today.toLocaleString()); // --- 그어진건 더이상 가급적 쓰지 말아라 라는 의미
		
		
	}

}
