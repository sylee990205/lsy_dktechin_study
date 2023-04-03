package day11.exercise;

import java.util.LinkedList;

class Person {
	private String name;
	
	Person(String name) {
			this.name = name;
	}
	
	public String getInfo() {
		return name;
	}
}

class Friend extends Person{
	private String phoneNum;
	private String email;
	
	Friend(String name, String phoneNum, String email){
		super(name);
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public String getInfo() {
		return super.getInfo() + "\t" + phoneNum + "\t" + email;
	}
}

public class LinkedListLab1 {

	public static void main(String[] args) {
		
		LinkedList<Friend> list = new LinkedList<Friend>();
		
		list.add(new Friend("소영","01022420182","sy990205@gmail.com"));
		list.add(new Friend("둘리","01052522222","yoribogo@gmail.com"));
		list.add(new Friend("또치","01011112222","duckduck@gmail.com"));
		list.add(new Friend("도우너","01055552145","violin@gmail.com"));
		list.add(new Friend("올라프","01012341234","snowman@gmail.com"));
		
		System.out.println("이름\t전화번호\t\t메일주소");
		System.out.println("------------------------------------------");
		
		for(Friend e: list) {
			System.out.println(e.getInfo());
		}
		
	}

}
