package day18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample14 {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("3", "1", "4", "2", "5", "5");

		System.out.println(strList.stream().map(x -> Integer.parseInt(x)).sorted().distinct().limit(3)
				.collect(Collectors.toList()));

		System.out.println("-------------");

		Stream.of("3", "1", "4", "2", "5", "5").map(x -> Integer.parseInt(x)).sorted().distinct().limit(3)
				.collect(Collectors.toList()).stream() // 다시 정수형 값을 갖는 스트림으로 변환
				.filter(x -> x > 1) // 1보다 큰 값만 갖도록 필터링함 {2, 3}
				.forEach(x -> System.out.println(x));
	}
}
