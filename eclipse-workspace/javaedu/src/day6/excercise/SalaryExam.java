package day6.excercise;
import day5.excercise.*;

class SalaryExpr {
	int bonus;
	
	SalaryExpr(){
		//bonus = 0; 생략가능, 객체 생성시 자동으로 0으로 초기화 되기때문
	}
	
	SalaryExpr(int bonus){
		this.bonus = bonus;
	}
	
	int getSalary(int grade) {
		int sal = 0;
		switch(grade){
			case 1:
				sal = bonus + 100;
				break;
			case 2:
				sal = bonus + 90;
				break;
			case 3:
				sal = bonus + 80;
				break;
			case 4:
				sal = bonus + 70;
				break;
		}
		
		return sal;
	}
}

public class SalaryExam {

	public static void main(String[] args) {
		int month = MethodLab5.getRandom(12);
		int grade = MethodLab5.getRandom(4);
		//int sal;
		SalaryExpr salary;
		
		if (month % 2 == 0) {
			salary = new SalaryExpr(100);
			//sal = salary.getSalary(grade);
		}
		else {
			salary = new SalaryExpr();
			//sal = salary.getSalary(grade);
		}
		
		System.out.printf("%d월 %d등급의 월급은 %d 입니다.", month,grade, salary.getSalary(grade));
		
	}

}
