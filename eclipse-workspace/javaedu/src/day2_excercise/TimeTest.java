package day2_excercise;

public class TimeTest {

	public static void main(String[] args) {
		int time = 32150;
		int hour = time / 60 / 60;
		int min = time / 60 % 60;
		int sec = time % 60;
		
		System.out.println(hour + "시간 " + min +"분 " + sec + "초");
		

	}

}
