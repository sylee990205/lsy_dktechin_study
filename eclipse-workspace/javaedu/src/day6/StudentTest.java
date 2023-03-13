package day6;

class Student{ //public 클래스가 될 수 없음 -> 소스 이름과 클래스 이름이 똑같아야함
	// 어떤 객체의 속성을 다 명시하지않음, 속성 중 필요한 것만 뽑아내야함 --> 추상화
	
	String name; //클래스에 정의되는 변수 --> 멤버 변수 --> 객체의 속성
	int age;
	String subject; // 초기화하지 않을 경우 int - 0, String은 Null
					// 타입별 기본 값으로 자동 초기화
	
	void printStudentInfo() {
		System.out.printf("%s학생의 나이는 %d입니다.\n",name,age);
	}
	void study() {
		System.out.printf("%s학생은 %s과목을 학습합니다.\n",name,subject);
	}
	
}


public class StudentTest { 
	public static void main(String[] args) {
		Student st1 = new Student();
		Student st2 = new Student();
		
		System.out.println("st1이 참조하는 객체 정보 : " + st1);
		System.out.println("st2가 참조하는 객체 정보 : " + st2);
		
		st1.printStudentInfo();
		st1.study();
		
		st1.name = "둘리"	;
		st1.age = 10;
		st1.subject = "HTML5";
		
		st1.printStudentInfo();
		st1.study();
		
		st2.name = "또치"	;
		st2.age = 10;
		st2.subject = "CSS3";
		
		st2.printStudentInfo();
		st2.study();
		
		st2 = st1;
		System.out.println("st1이 참조하는 객체 정보 : " + st1);
		System.out.println("st2가 참조하는 객체 정보 : " + st2);
		st2.printStudentInfo();
		st2.study();
		
	}

}
