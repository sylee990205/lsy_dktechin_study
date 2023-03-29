package day18;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample3 {
	public static void main(String[] args) {
		String[] strArray = { "둘리", "또치", "도우너" };
		// 배열을 활용하여 스트림 생성
		Stream<String> strStream = Arrays.stream(strArray);
		strStream.forEach(item -> System.out.println(item  + " 회원님~~ "));
		System.out.println();

		int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(item -> System.out.println(item*item));
		System.out.println();
	}
}