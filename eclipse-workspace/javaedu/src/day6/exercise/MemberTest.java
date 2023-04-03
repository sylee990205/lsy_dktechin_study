package day6.exercise;

class Member {
	
	String name;
	String account;
	String passwd;
	int birthyear;
	
}

public class MemberTest {

	public static void main(String[] args) {
		Member mem1 = new Member();
		Member mem2 = new Member();
		Member mem3 = new Member();
		
		mem1.name = "이소영";
		mem1.account = "soyoung";
		mem1.passwd = "so0205";
		mem1.birthyear = 1999;
		
		System.out.printf("회원1 : %s(%s, %s, %d)\n",mem1.name,mem1.account,mem1.passwd,mem1.birthyear);
		
		mem2.name = "홍길동";
		mem2.account = "hong";
		mem2.passwd = "hgd1234";
		mem2.birthyear = 1960;
		
		System.out.printf("회원2 : %s(%s, %s, %d)\n",mem2.name,mem2.account,mem2.passwd,mem2.birthyear);
		
		mem3.name = "둘리";
		mem3.account = "dool";
		mem3.passwd = "hoit";
		mem3.birthyear = 2000;
		
		System.out.printf("회원3 : %s(%s, %s, %d)",mem3.name,mem3.account,mem3.passwd,mem3.birthyear);

	}

}
