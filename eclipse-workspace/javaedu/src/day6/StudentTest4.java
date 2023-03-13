package day6;

class Student4{
	String name;
	int age;
	String subject;
	
	Student4(){
		this("듀크",28, "스프링"); // this는 변수로 사용할 때와 메서드로 사용할 때 두가지가 있음. 소괄호O - 메서드, X - 변수
		System.out.println("호출");	
								// this 메서드는 생성자 메서드 안에서만 사용 가능, 반드시 첫 행이어야 함.
	}
	
	Student4(String name, int age, String subject){ 
		this.name = name; 
		this.age = age;
		this.subject = subject;
	}
	
	void printStudentInfo() {
		System.out.printf("%s학생의 나이는 %d입니다.\n",name,age);
	}
	void study() {
		System.out.printf("%s학생은 %s 과목을 학습합니다.\n",name,subject);
	}
	void setSubject(String subject) {
		this.subject = subject; //this 변수는 생성자와 일반 메서드 내에서 모두 사용 가능.
								//특히 지역변수와 멤버변수의 이름을 구분하고자하면 꼭 사용
	}
	
}


public class StudentTest4 { 
	public static void main(String[] args) {
		
		Student4[] st = new Student4[4];
		st[0] = new Student4("둘리",10,"HTML5");
		st[1] = new Student4("또치",10,"CSS3");
		st[2] = new Student4("도우너",10,"JavaScipt");
		st[3] = new Student4();
		
		for(Student4 obj : st) {
			System.out.println(obj);
			obj.printStudentInfo();
			obj.study();
		}
		
		st[3].setSubject("JPA");
		st[3].study();
//		
//		System.out.println("st1이 참조하는 객체 정보 : " + st1);
//		System.out.println("st2가 참조하는 객체 정보 : " + st2);
//		System.out.println("st3가 참조하는 객체 정보 : " + st3);
//		
//		st1.printStudentInfo();
//		st1.study();
//		
//		st2.printStudentInfo();
//		st2.study();
//
//		st3.printStudentInfo();
//		st3.study();
		
	}

}
