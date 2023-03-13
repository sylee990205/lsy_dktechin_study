package day6;
import java.util.Scanner; 
public class ScannerTest4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("데이터를 입력하세요 : ");
		String str1 = sc.next(); // 한 단어만 읽음, 공백 무시
		String str2 = sc.next(); 
		//next 라인을 사용하다가 nextLine을 사용하려면 엔터를 쳤을 때 엔터조차 문자로 인식해서 nextLine이 Null 문자열을 반환받음
		//이 때 한번 nextLine을 사용해주자.
		sc.nextLine();  // 입력버퍼에 남아있는 개행문자를 청소하는 기능
		String line1 = sc.nextLine(); //공백까지 다 읽음
		String line2 = sc.nextLine();
		System.out.printf("[%s] [%s] [%s] [%s]", str1, str2, line1, line2);
		sc.close();
	}
}









