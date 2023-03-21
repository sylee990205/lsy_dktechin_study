package day12.excercise.collection;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class ProductTest2 {

	public static void main(String[] args) {
		Product2[] product = new Product2[4];
		product[0] = new Product2("p100", "TV", 20000);
		product[1] = new Product2("p200", "Computer", 10000);
		product[2] = new Product2("p100", "MP3", 700);
		product[3] = new Product2("p300", "Audio", 1000);
		
		LinkedList<Product2> list = new LinkedList<Product2>();
		
		Collections.addAll(list, product);
		Collections.sort(list);
		
		System.out.printf("%-8s%-9s%s\n------------------------------------------------\n","제품 ID", "제품명", "가격");
		
		Iterator<Product2> iterator = list.iterator();

	    while(iterator.hasNext()) {
	        Product2 str = iterator.next();
	        System.out.println(str);
	    }
	}

}
