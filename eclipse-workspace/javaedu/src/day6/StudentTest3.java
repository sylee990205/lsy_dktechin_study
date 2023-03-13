package day6;

class Student3{
	String name;
	int age;
	String subject;
	
	Student3(){
		name = "듀크"; //this를 안써도 될때는 생략하는게 좋음 -> 생략이 가능할때는 왠만하면 생략
		age = 28;
		subject = "스프링";
	}
	
	Student3(String name, int age, String subject){ //이때는 this를 무조건 써야함.
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
	
}


public class StudentTest3 { 
	public static void main(String[] args) {
		Student3 st1 = new Student3("둘리",10,"HTML5");
		Student3 st2 = new Student3("또치",10,"CSS3");
		Student3 st3 = new Student3();
		
		System.out.println("st1이 참조하는 객체 정보 : " + st1);
		System.out.println("st2가 참조하는 객체 정보 : " + st2);
		System.out.println("st3가 참조하는 객체 정보 : " + st3);
		
		st1.printStudentInfo();
		st1.study();
		
		st2.printStudentInfo();
		st2.study();

		st3.printStudentInfo();
		st3.study();
		
	}

}
