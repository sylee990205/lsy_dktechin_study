package day2;

public class SwitchTest3 {
	public static void main(String[] args) {
		int score = (int)(Math.random()*101); //0~100
		char credit;
		switch(score/10) {
		case 10 :
		case 9 :
			credit = 'A';
			break;
		case 8 :
			credit = 'B';
			break;	
		case 7 :
			credit = 'C';
			break;
		case 6 :
			credit = 'D';
			break;
		default :
			credit = 'F';		
		}	
		System.out.println(score + " : " + credit);
	}
}
