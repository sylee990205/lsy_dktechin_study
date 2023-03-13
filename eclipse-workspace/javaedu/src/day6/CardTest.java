package day6;

class Card{	
	String kind ;		// 카드의 무늬 - 인스턴스 변수
	int number;		// 카드의 숫자 - 인스턴스 변수
	static int width = 100;	// 카드의 폭   - 클래스 변수
	static int height = 250;	// 카드의 높이 - 클래스 변수
}

public class CardTest{
	public static void main(String args[]){	
		Card c1 = new Card();		
		c1.kind = "Heart";
		c1.number = 7;	
		Card c2 = new Card();		
		c2.kind = "Spade";
		c2.number = 4;		
		System.out.println("c1은 " + c1.kind + ", " + c1.number 
				+ "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2는 " + c2.kind + ", " + c2.number
				+ "이며, 크기는 (" + c2.width + ", " + c2.height + ")");	
		Card.width = 50;
		Card.height = 80;
		System.out.println("c1은 " + c1.kind + ", " + c1.number 
				+ "이며, 크기는 (" + c1.width + ", " + c1.height + ")" );
		System.out.println("c2는 " + c2.kind + ", " + c2.number 
				+ "이며, 크기는 (" + c2.width + ", " + c2.height + ")" );
	}
}




