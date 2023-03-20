package day11;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample2 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("포도");
		list.add("딸기");
		list.add("복숭아");
		System.out.println(list);
		list.add(2, "키위"); //index 2번의 복숭아가 사라지는 것이 아님. index 2번에 키위를 추가하는 것 복숭아는 뒤로 밀림
		System.out.println(list);
		list.set(0, "오렌지");
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.remove("키위");
		System.out.println(list);
		int num = list.size();
		for (int cnt = 0; cnt < num; cnt++) {
			String str = list.get(cnt);
			System.out.println(str);
		}
		for (String fruit : list)
			System.out.println(fruit);
		Iterator<String> iter = list.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());

	}
}
