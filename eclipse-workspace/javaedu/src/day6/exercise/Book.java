package day6.exercise;

public class Book{
	
	String title;
	String author;
	int price;
	
	public Book(){
		this("이것이 자바다","신용권,임경균",36000); //this 메서드를 사용해 한줄로 정리 가능		
//		title = "이것이 자바다";
//		author = "신용권, 임경균";
//		price = 35000;
	}
	
	public Book(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public String getBookInfo() {
		String info = "책 제목: " + title + "/ 저자: " + author + "/ 가격: " + price;
		
		return info;
	}

	public int getPrice() {
		return price;
	}
	
	
	
}