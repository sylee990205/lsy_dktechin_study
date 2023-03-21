package day12;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// 크기 비교, 정렬 등을 사용하려면 Comparable을 추가 상속 해야하며, Comparable은 Generics 구문을 적용하고 있어 Type Parameter를 적용해야함
class Person implements Comparable<Person> {
	public String name;
	public int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) { //반드시 Override 해야하는 메소드, Person 객체끼리 누가 더 크고 작은지 구별하기 위해 정의하는것 == 매개변수로 자신의 객체를 호출해야함
		if(age<o.age) return -1; // 기준 객체 < 매개변수 객체 
		else if(age == o.age) return 0;
		else return 1;
	}

	@Override
	public String toString() {		
		return name+"("+age+")";
	}	
}

public class CollectionSort2 {
	public static void main(String[] args) {
		List<Person> list = new LinkedList<>();
		
		for(int i=1; i <= 10; i++) {
			list.add(new Person("duke"+i, new Random().nextInt(30)));
		}

		System.out.println(list);
		
		Collections.sort(list); // collection 개체 안에 적용할 객체는 반드시 Comparable을 추가 상속 받아야함, 그렇지 않으면 sort 사용 시 error
		// sort 메서드는 기본적으로 오름차순만 지원 => CompareTo를 어떻게 구현햇는가에 따라 다르긴함.
		System.out.println("\nlist의 데이터들을 오름차순으로 소팅한 결과 : " + list);	
		Collections.reverse(list);
		// reverse 내림차순
		System.out.println("\nlist의 데이터들을 내림차순으로 소팅한 결과 : " + list);		
	}
}
