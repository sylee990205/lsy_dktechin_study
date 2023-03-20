package day11.excercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class HashSetLab1 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		Random random = new Random();
		
		for(int i = 0; i < 10; i++) {
			if(set.add(random.nextInt(21)+10)) {
				
			}else {
				i--;
			}
		}
		
		System.out.print("오늘의 로또 번호 : ");
		
		Iterator<Integer> iterator = set.iterator();
		int e;
	
		while(iterator.hasNext()) {
			e = iterator.next(); 	//iterator.next()는 먼저 해줘야함, 출력문에서 사용하면 조건문 인식 불가
			
			if(iterator.hasNext()) {
				System.out.printf("%d, ", e);
			} else {
				System.out.printf("%d", e);
			}
		}
		
	}

}
