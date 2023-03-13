package day6;
import java.util.Scanner;
public class ScannerTest1 {
	public static void main(String[] args) {
		System.out.print("입력 : ");
		Scanner sc = new Scanner(System.in); //버퍼링 입력, 입력 중 enter를 눌러야 응용프로그램에게 전달
		String a,b,c,d;
		a = sc.next();
		b = sc.next();
		c = sc.next();
		d = sc.next();
		System.out.println("a = [" + a + "]");
		System.out.println("b = [" + b+ "]");
		System.out.println("c = [" + c+ "]");
		System.out.println("d = [" + d+ "]");	
		sc.close();
	}
}
