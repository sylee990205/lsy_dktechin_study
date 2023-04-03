package day11.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashMapLab1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String country;
		int population;
		
		for(int i = 0; i < 5; i++) {
			System.out.print("나라 이름을 입력하세요: ");
			country = scan.next();
			System.out.print("인구 수를 입력하세요: ");
			population = scan.nextInt();
			
			if(map.containsKey(country)) {
				System.out.printf("*나라명 %s는 이미 저장되었습니다.*\n",country);
				i--;
			}
			else {
				map.put(country, population);
				System.out.println("*저장되었습니다.*");
			}
		}
		
		System.out.println("5개가 모두 입력되었습니다.");
		System.out.print("입력된 데이터 : ");
		
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
//		String k; // 굳이 쓸 필요 없을듯?
//		int v;
		while(keyIterator.hasNext()) {
			country = keyIterator.next();
			population = map.get(country);
			
			if(keyIterator.hasNext()) {
				System.out.printf("%s(%d), ", country, population);
			}
			else {
				System.out.printf("%s(%d)", country, population);
			}
		}
		
		scan.close();
	}

}
