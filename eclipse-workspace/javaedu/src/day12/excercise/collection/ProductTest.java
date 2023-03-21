package day12.excercise.collection;

import java.util.HashSet;
import java.util.Iterator;

public class ProductTest {

	public static void main(String[] args) {
		Product[] product = new Product[4];
		product[0] = new Product("p100", "TV", "20000");
		product[1] = new Product("p200", "Computer", "10000");
		product[2] = new Product("p100", "MP3", "700");
		product[3] = new Product("p300", "Audio", "1000");
		
		HashSet<Product> set = new HashSet<>();
		
		for (int i = 0; i < product.length; i++) {
			if(set.add(product[i])) {
				System.out.println("성공적으로 저장되었습니다.");
			}
			else {
				System.out.println("동일한 ID의 제품이 이미 저장되어 있습니다.");
			}
		}
		
		System.out.println();
		
		System.out.printf("%-8s%-9s%-10s\n------------------------------------------------\n","제품 ID", "제품명", "가격");
		
		Iterator<Product> iterator = set.iterator();

	    while(iterator.hasNext()) {
	        Product str = iterator.next();
	        System.out.println(str);
	    }
	}

}
