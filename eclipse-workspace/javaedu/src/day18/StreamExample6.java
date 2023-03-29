package day18;

import java.util.stream.Stream;

public class StreamExample6 {

	public static void main(String[] args) {
		Stream.of("3", "1", "4", "2", "5", "5") //stream 객체 생성
        .map(x -> { // x라는 매개변수는 stream 객체가 가지고 있는 element를 받는 매개변수
            System.out.println("map : " + x);
            return Integer.parseInt(x); // map return 값의 유형 다양하게
        })
        .filter(x -> {
            System.out.println("filter : " + x);
            return x > 1; // return 값 boolean
        })
        .forEach(x -> {
            System.out.println("forEach : " + x);
        });
	}
}
