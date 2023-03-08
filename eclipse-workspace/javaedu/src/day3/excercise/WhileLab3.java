package day3.excercise;

public class WhileLab3 {

	public static void main(String[] args) {
		int ran_num;
		int repeat_time = 0;
		char alpha;
		
		while(true) {
			ran_num = (int)(Math.random()*31);
			alpha = 'A';
			if (ran_num >= 27 || ran_num == 0) {
				System.out.printf("출력횟수는 %d번 입니다.\n",repeat_time);
				break;
			}
			else {
				alpha += ran_num - 1;
				System.out.printf("%d-%c, %d, 0x%X\n",ran_num,alpha,(int)alpha, (int)alpha);
				repeat_time++;
			}
				
		}
		
	}

}
