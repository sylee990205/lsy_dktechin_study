package day3;

public class WhileTest1 {

	public static void main(String[] args) {
		int sumV=0;
		int num;
		
		while(sumV < 100) {
			num = (int)(Math.random()*50)+1;
			sumV += num; // sumV = sumV + num
			System.out.println("num : "+num+", sumV : "+sumV);			
		}
	}
}
