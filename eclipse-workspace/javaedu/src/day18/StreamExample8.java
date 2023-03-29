package day18;

import java.util.ArrayList;
import java.util.List;

public class StreamExample8 {
	public static void main(String[] args) {
		// List 컬렉션 생성
		List<String> list = new ArrayList<>();
		list.add("둘리");
		list.add("또치");
		list.add("도우너");
		list.add("희동이");
		list.add("고길동");
		list.add("또치");
		list.add("도우너");

		// 중복 요소 제거
		list.stream().distinct().forEach(System.out::println);
		System.out.println();

		// 고으로 시작하는 요소만 필터링
		list.stream().filter(n -> n.startsWith("고")).forEach(n -> System.out.println(n));
		System.out.println();

		// 중복 요소를 먼저 제거하고, 신으로 시작하는 요소만 필터링
		list.stream().distinct().filter(n -> n.startsWith("도")).forEach(n -> System.out.println(n));
	}
}