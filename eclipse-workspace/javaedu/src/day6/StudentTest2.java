package day6;

//class Student2{ // 다른 실습을 위해 public class로 지정하고자 분리
//	String name;
//	int age;
//	String subject;
//	
//	Student2(String name, int age, String subject){
//		//name = name; // 똑같은 이름의 변수가 매개변수, 멤버변수에 있음
//					 // 가까운게 우선됨, 이 경우 name은 모두 매개변수
//		
//		this.name = name; // this는 자기 자신을 참조하도록 클래스 생성 시 자동으로 만들어짐
//		this.age = age;
//		this.subject = subject;
//	}
//	
//	void printStudentInfo() {
//		System.out.printf("%s학생의 나이는 %d입니다.\n",name,age);
//	}
//	void study() {
//		System.out.printf("%s학생은 %s과목을 학습합니다.\n",name,subject);
//	}
//	
//	
//	
//}


public class StudentTest2 { 
	public static void main(String[] args) {
		Student2 st1 = new Student2("둘리",10,"HTML5");
		Student2 st2 = new Student2("또치",10,"CSS3");
		// Student2 st3 = new Student2(); 매개변수 없이 객체를 호출할 수 없음.
		
		System.out.println("st1이 참조하는 객체 정보 : " + st1);
		System.out.println("st2가 참조하는 객체 정보 : " + st2);
		
		st1.printStudentInfo();
		st1.study();
		
		st2.printStudentInfo();
		st2.study();
		
		st2 = st1;
		System.out.println("st1이 참조하는 객체 정보 : " + st1);
		System.out.println("st2가 참조하는 객체 정보 : " + st2);
		st2.printStudentInfo();
		st2.study();
		
	}

}
