package day2;

public class IfTest3 {

	public static void main(String[] args) {
		int num = (int)(Math.random()*10)+1;
		System.out.println("추출된 num 값 : "+num);
		System.out.println(1);
		if (num % 2 == 1)
			System.out.println(2);
		System.out.println(3);
		if (num % 2 == 0) {
			System.out.println(4);
			System.out.println(5);
		} // 수행 문장을 담고 있는 코드 블럭, 어떤 조건식이 수행할 수행문장이 2개 이상이면 반드시 블럭으로 묶어야함 
		System.out.println(6);
		System.out.println(7);
	}

}
