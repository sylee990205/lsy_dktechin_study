package day9;
import java.net.*;
public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet);
		inet = InetAddress.getByName("www.naver.com"); // 도메인명으로 ip주소
		System.out.println(inet);
		
		// 생성자 감추고 객체 사용 시 용도에 맞춰 팩토리 메서드를 사용하게 한 패키지
	}
}
