package day2;

public class SwitchLab2 {

	public static void main(String[] args) {
		int num = (int)(Math.random()*5) + 1;
		int result;
		
		switch (num) {
			case 1:
				result = 300 + 50;
				break;
			case 2:
				result = 300 - 50;
				break;
			case 3:
				result = 300 * 50;
				break;
			case 4:
				result = 300 / 50;
				break;
			case 5:
				result = 300 % 50;
				break;
			default:
				result = 0;
		}
		
		System.out.println("결과값 : " + result);
	}

}
