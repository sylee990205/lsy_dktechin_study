package day3.excercise;

public class ControlLab3 {

	public static void main(String[] args) {
		
		int ran_num;
		String string = "";
		
		while(true) {
			ran_num = (int)(Math.random()*120)+1;
			
			if(ran_num < 50) {
				if(ran_num % 10 == 3) 
					string = ran_num + " : *듀크팀*";
				else
					string = ran_num + " : 50 미만";
			}
			else if(ran_num >= 50 && ran_num <= 80) {
				if(ran_num >= 70 && ran_num <= 79)
					string = ran_num + " : *턱시팀*";
				else
					string = ran_num + " : 50 이상 80 이하";
			}
			else if(ran_num >= 81 && ran_num <= 100)
				continue;
			else
				break;
			
			System.out.printf("%s\n",string);
		}
		

	}

}
