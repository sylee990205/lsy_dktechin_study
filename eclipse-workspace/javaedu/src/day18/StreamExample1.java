package day18;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamExample1 {
	public static void main(String[] args) {
		// Set 컬렉션 생성
		Set<String> set = new HashSet<>();
		set.add("둘리");
		set.add("또치");
		set.add("도우너");
		set.add("또치");

		// Stream을 이용한 요소 반복 처리
		Stream<String> stream = set.stream();
		stream.forEach(name -> System.out.println(name));
		System.out.println("---------------------------");
		stream = set.stream();
		stream.forEach(System.out :: println);
	}
}