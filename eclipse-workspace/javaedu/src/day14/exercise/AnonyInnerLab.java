package day14.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import day6.exercise.Book;

public class AnonyInnerLab {
	
	public static void main(String[] args) {
		Book[] books = new Book[5];
		books[0] = new Book();
		books[1] = new Book("세이노의 가르침","세이노",6480);
		books[2] = new Book("어른이 되기 전에 꼭 한 번은 논어를 읽어라2","판덩",15120);
		books[3] = new Book("세상 끝의 카페","존 스트레레키",14850);
		books[4] = new Book("당신은 결국 무엇이든 해내는 사람","김상현",13500);
		
		List<Book> bookList = new ArrayList<>();
		Collections.addAll(bookList, books);
		
		
		Iterator<Book> iterator = bookList.iterator();
		
		while(iterator.hasNext()) {
			Book book = (Book) iterator.next();
			System.out.println(book.getBookInfo());
			
		}
		
		System.out.println("[소팅 후 ]");
		
	
		// 객체 리스트를 sort 하려면 컴파일러는 무엇을 기준으로 정렬해야하는지 알 수 없음
		// 1. 객체에 Comparator를 추가 상속하여 compare 메소드를 오버라이딩하여 정렬 기준을 정의 하는 방법
		// 2. Anonymous Inner class를 사용
		// sort의 매개변수 타입 (리스트, Comparator 인터페이스) 매개변수 리스트 자리에 리스트를 넣고 Comparator 인터페이스 자리에 익명 내부 클래스를 사용하여 가벼운 구현 클래스를 생성
		// 구현 클래스 내에서 compare 메소드를 오버라이딩하여 정렬 기준 정의
		Collections.sort(bookList, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getPrice() - b2.getPrice(); //sort 기준은 음의값인지 0인지 양의값인지이기때문에 한줄로 가능
				
//				if (b1.getPrice() < b2.getPrice())
//					return -1;
//				else if (b1.getPrice() == b2.getPrice())
//					return 0;
//				else
//					return 1;
			}
		});
		
		iterator = bookList.iterator();
		
		while(iterator.hasNext()) {
			Book book = (Book) iterator.next();
			System.out.println(book.getBookInfo());
			
		}
	
	}

}
