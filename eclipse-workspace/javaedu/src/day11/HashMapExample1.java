package day11;

import java.util.HashMap;

public class HashMapExample1 {
	public static void main(String args[]) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("해리", Integer.valueOf(95));
		map.put("헤르미온느", 100);
		map.put("론", 85);
		map.put("드레이코", 93);
		map.put("네빌", 70);
		// 같은 key 값인 헤르미온느에 put을 했기에 기존의 값 100이 55로 바뀜. put은 6번 데이터는 5개
		map.put("헤르미온느", 55); // JDK 1.5 Auto Boxing 구문
		System.out.println(map); // Key = Value 형태의 값들이 출력됨
		Integer num = map.get("헤르미온느");
		System.out.println("헤르미온느의 성적은? " + num);
		System.out.println(map);
	}
}
