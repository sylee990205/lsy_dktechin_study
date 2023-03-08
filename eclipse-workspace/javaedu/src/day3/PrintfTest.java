package day3;
public class PrintfTest {
	public static void main(String[] args) {
		System.out.printf("테스트입니당%n");	// 메서드 호출 시 전달하는 데이터를 argument(아규먼트)라고 함. argument 1
		System.out.printf("테스트%d입니당\n",10);		// argument 2
		System.out.printf("테스트입니당%n"); // argument 1
		System.out.printf("%d %x %o %c\n", 100, 100, 100, 100); // 10진수, 16진수, 8진수, 문자 . argument 5
		System.out.printf("%d %1$x %1$o %1$c\n", 100); // 1$ == 첫번째 argument 값을 적용해라.
		System.out.printf("0x%X 0x%x\n", (int)'가',(int)'각');
		System.out.printf("%c %c %c %c\n", '가', 'A', '!', '3');
		System.out.printf("%b\n", true);
		System.out.printf("%f %e\n", 100.0, 100.0);
		System.out.printf("%.2f\n", 123.5678); // .2f 소수점 두번째 자리까지 출력 3번째 자리에서 반올림
		System.out.printf("|%s|\n", "자바");
		System.out.printf("|%10s|\n", "자바");
		System.out.printf("|%-10s|\n", "자바");
		System.out.printf("%,d원\n", 1000000);	// , 찍으면 1,000,000으로 출력
	}
}








