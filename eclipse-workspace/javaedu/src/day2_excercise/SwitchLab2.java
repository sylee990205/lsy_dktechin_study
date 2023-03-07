package day2_excercise;

public class SwitchLab2 {

	public static void main(String[] args) {
		int num = (int)(Math.random()*5) + 1;
		int result = 0; //실질적으로 default로 빠질일은 없으니 선언 시 초기화
		
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
//			default:
//				result = 0;
		}
		
		System.out.println("결과값 : " + result);
	}

}
