package day2;

public class ForLab3 {

	public static void main(String[] args) {
		int num1 = (int)(Math.random()*10)+1;
		int num2 = (int)(Math.random()*10) + 30;
		int result = 0;
		
		for(int i = num1;i <= num2;i++) {
			if(i % 2 == 0)
				result += i;
			else
				continue;
		}
		
		System.out.println(num1 + " 부터 " + num2 + " 까지의 짝수의 합 : " + result);
				
	}

}
