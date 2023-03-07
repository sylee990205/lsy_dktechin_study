package day2;

public class ForTest1 {
	public static void main(String[] args) {
		 for(int num=1; num <= 10; num++) // 초기식에 사용한 num은 for 문 안에서만 사용 가능 --> block scope
		        System.out.println(num); // for 문 block 안에서만 사용 가능한 변수를 block scope
		 System.out.println();
		 for(int num=1; num <= 10; num+=2)
		        System.out.println(num);
		 //System.out.println(num);
	}
}
