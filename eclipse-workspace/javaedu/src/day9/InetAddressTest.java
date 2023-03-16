package day9;
import java.net.*;
public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet);
		inet = InetAddress.getByName("www.naver.com");
		System.out.println(inet);
	}
}
