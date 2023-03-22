package day6;

import java.io.Serializable;

public class Student2 implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	String subject;
	
	public Student2(String name, int age, String subject){
		//name = name; // 똑같은 이름의 변수가 매개변수, 멤버변수에 있음
					 // 가까운게 우선됨, 이 경우 name은 모두 매개변수
		
		this.name = name; // this는 자기 자신을 참조하도록 클래스 생성 시 자동으로 만들어짐
		this.age = age;
		this.subject = subject;
	}
	
	public void printStudentInfo() {
		System.out.printf("%s학생의 나이는 %d입니다.\n",name,age);
	}
	public void study() {
		System.out.printf("%s학생은 %s과목을 학습합니다.\n",name,subject);
	}
	
	
	
}