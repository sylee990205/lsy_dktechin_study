package day3.excercise;

public class ControlLab1 {

	public static void main(String[] args) {
		int ran_num, sum;
		int repeat_time = 0;
		
		while(true) {
			ran_num = (int)(Math.random()*11)+10;
			sum = 0;
			if(ran_num % 3 == 0 || ran_num % 5 == 0) {
				for(int i = 1; i <= ran_num ; i++) {
					sum += i;
				}
				System.out.printf("1부터 %d까지 합 : %d\n",ran_num,sum);
				repeat_time++;
			}
			else if (ran_num == 11 || ran_num == 17 || ran_num == 19) {
				break;
			}
			else {
				System.out.println("재수행");
			}
		}
		System.out.printf("%d회 반복함",repeat_time);
		
	}

}
