package day7.exercise;

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

public class FriendTest {

	public static void main(String[] args) {
		
		Friend[] friend = new Friend[5];
		
		friend[0] = new Friend("소영","01022420182","sy990205@gmail.com");
		friend[1] = new Friend("둘리","01052522222","yoribogo@gmail.com");
		friend[2] = new Friend("또치","01011112222","duckduck@gmail.com");
		friend[3] = new Friend("도우너","01055552145","violin@gmail.com");
		friend[4] = new Friend("올라프","01012341234","snowman@gmail.com");
		
		System.out.println("이름\t전화번호\t\t메일주소");
		System.out.println("------------------------------------------");
		
		for(Friend e: friend) {
			System.out.println(e.getInfo());
		}
		
	}

}
