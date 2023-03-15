package day8;

public class Member {
	private String name;
	private int age;
	
	// getter setter는 직접 구현하지않고 보통 IDE에서 제공하는 자동완성기능을 사용함
	// 이클립스에서는 Source -> Generate Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
