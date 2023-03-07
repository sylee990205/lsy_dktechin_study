package day2_excercise;

public class AlphaTest {

	public static void main(String[] args) {
		int num = (int)(Math.random()*26) + 1;
		char alpha = 'A';
		
		System.out.println("추출된 숫자 : " + num);
		System.out.println((char)(alpha + num - 1));
			
	}

}
