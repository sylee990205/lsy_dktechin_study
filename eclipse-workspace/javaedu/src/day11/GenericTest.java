package day11;

import java.util.Iterator;
import java.util.LinkedList;

public class GenericTest {
	public static void main(String[] args) {
		//Type parameter에 관한 정보를 지정하지않으면 자동으로 Object이 들어감.
		LinkedList list = new LinkedList();
		list.add("java");
		list.add(100); // String으로 지정했으면 여기서 컴파일 에러가 남
		list.add("servlet");
		list.add("jdbc");

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		System.out.println();

		for (Object value : list) {
			String s = (String) value; // Object 타입으로 지정하면 100을 출력하려할때 오류 발생
			System.out.println(s);
		}
		System.out.println();

		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Object value = iter.next();
			String s = (String) value;
			System.out.println(s);
		}
	}
}
