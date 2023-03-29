package day18;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest11 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		System.out.println("오리지널 리스트 : " + list);
		Collections.sort(list);
		System.out.println("기본은 오름차순 : " + list);

		Collections.sort(list, new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 내림차순을 하는방법, 2번째 argument를 기준으로 compareTo를 사용하면 됨 
				return s2.compareTo(s1);
			}
		});
		System.out.println("내림차순 : 두 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, (String s1, String s2) -> {
			return s2.compareTo(s1);
		});
		System.out.println("내림차순 : 두 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		Collections.sort(list, (String s1, String s2) -> {
			return s1.compareTo(s2);
		});
		System.out.println("오름차순 : 첫 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);

		list = Arrays.asList("abc", "aaa", "bbb", "ccc");
		// 아래 방법은 내림차순으로 바꿀 수 없음. 처음 보내는게 첫번째 아규먼트 두번째로 보내는게 두번째 아규먼트로 고정
		Collections.sort(list, String::compareTo);
		System.out.println("오름차순 : 첫 번째 아규먼트를 기준으로 비교하는 Comparator 객체 전달 : " + list);
	}
}
