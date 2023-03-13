package day6.excercise;

class Book {
	
	String title;
	String author;
	int price;
	
	Book(){
		this("이것이 자바다","신용권,임경균",36000); //this 메서드를 사용해 한줄로 정리 가능		
//		title = "이것이 자바다";
//		author = "신용권, 임경균";
//		price = 35000;
	}
	
	Book(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	String getBookInfo() {
		String info = "책 제목: " + title + "/ 저자: " + author + "/ 가격: " + price;
		
		return info;
	}
	
}

public class BookTest {

	public static void main(String[] args) { //배열로 풀어도 됐다고함...
		Book[] books = new Book[5];
		books[0] = new Book();
		books[1] = new Book("세이노의 가르침","세이노",6480);
		books[2] = new Book("어른이 되기 전에 꼭 한 번은 논어를 읽어라2","판덩",15120);
		books[3] = new Book("세상 끝의 카페","존 스트레레키",14850);
		books[4] = new Book("당신은 결국 무엇이든 해내는 사람","김상현",13500);
		
		for(Book e: books) {
			System.out.println(e.getBookInfo());
		}
		
//		Book book1 = new Book();
//		Book book2 = new Book("세이노의 가르침","세이노",6480);
//		Book book3 = new Book("어른이 되기 전에 꼭 한 번은 논어를 읽어라2","판덩",15120);
//		Book book4 = new Book("세상 끝의 카페","존 스트레레키",14850);
//		Book book5 = new Book("당신은 결국 무엇이든 해내는 사람","김상현",13500);
		
//		String[] info = new String[5];
//		info[0] = book1.getBookInfo();
//		info[1] = book2.getBookInfo();
//		info[2] = book3.getBookInfo();
//		info[3] = book4.getBookInfo();
//		info[4] = book5.getBookInfo();
//		
//		for(String e: info) {
//			System.out.println(e);
//		}
//		

	}

}
