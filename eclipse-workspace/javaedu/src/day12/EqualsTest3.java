package day12;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o != null && o instanceof Value) {
			Value v = (Value) o;
			if (value == v.value)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Value [value=" + value + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value); //hash 값을 만들어내는데 있어 사용하고자 하는 변수 값이 여러개면 여러개를 넣고, 한개면 한개를 넣을 수 있음
	}
	
	
}

public class EqualsTest3 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		Value v3 = new Value(20);
		System.out.println(v1.equals(null));	// false
		System.out.println(v1.equals(v3)); 		// false
		System.out.println(v1.equals(v2)); 		// false --> 값이 비교되는 것이 아니고 객체의 참조값이 비교됨, 다른 객체기에 다름
												// equals() Overriding 한다는 것은 값을 비교하겠다, 안했다면 참조값비교 == 랑 동일함
		System.out.println(v1.equals(new Date())); // false
		
		System.out.println(v1.hashCode());
		System.out.println(v2.hashCode());
		System.out.println(v3.hashCode());
		
		// HashSet 객체에 v1, v2, v3 를 저장
		// 저장된 객체들을 출력
		HashSet<Value> set = new HashSet<>();
		set.add(v1);
		set.add(v2);
		set.add(v3);
		System.out.println(set);
		
		// 3개가 모두 들어감, hashSet은 equals만 호출하지 않음, hashcode도 호출함, hashcode를 먼저 비교함, hashcode가 같고 equals도 같아야 hashset이 중복으로 인식하지않음
		
//		HashSet<Integer> intSet = new HashSet<>();
//		intSet.add(v1.value);
//		intSet.add(v2.value);
//		intSet.add(v3.value);
//		System.out.println(intSet);
		
		
//		if (v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다.");
//		else
//			System.out.println("v1과 v2는 다릅니다.");
//		v2 = v1;
//		if (v1.equals(v2))
//			System.out.println("v1과 v2는 같습니다.");
//		else
//			System.out.println("v1과 v2는 다릅니다.");
	}
}
