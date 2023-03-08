package day3.book;

public class IfExample {
	public static void main(String[] args) {
		int score = 93;
		
		if(score >= 90) {
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		
		if(score < 90)
			System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다."); // if문에 해당하는 수행문장이 2개 이상인 경우 {}를 적용해야 블럭 지정이 된다.
	}
}