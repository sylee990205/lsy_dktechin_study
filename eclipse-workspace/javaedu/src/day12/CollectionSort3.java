package day12;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class Person2 {
	public String name;
	public int age;

	public Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {		
		return name+"("+age+")";
	}	
}

class PersonComparator implements Comparator<Person2> {
	@Override
	public int compare(Person2 o1, Person2 o2) {
		if (o1.age < o2.age)
			return -1;
		else if (o1.age > o2.age)
			return 1;
		else 
			return 0;
	}	
}

public class CollectionSort3 {
	public static void main(String[] args) {
		List<Person2> list = new LinkedList<>();
		
		for(int i=1; i <= 10; i++) {
			list.add(new Person2("duke"+i, new Random().nextInt(30)));
		}

		System.out.println(list);
				
		list.sort(new PersonComparator());
		System.out.println("\nlist의 데이터들을 오름차순으로 소팅한 결과 : " + list);		
	}
}
