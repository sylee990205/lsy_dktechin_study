package day5;
public class MethodTest7 {
	public static void main(String[] args) {
		//main 메소드는 왜 String[] args를 매개변수로 받는가
		System.out.println("main() 수행시작");
		System.out.println(args.length);
		System.out.println(args[0]+args[1]+args[2]);
		System.out.println("main() 수행종료");
	}	
}
