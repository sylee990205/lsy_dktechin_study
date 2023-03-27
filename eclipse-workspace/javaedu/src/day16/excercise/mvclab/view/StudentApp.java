package day16.excercise.mvclab.view;

import java.util.Scanner;

import day16.excercise.mvclab.controller.StudentController;

public class StudentApp {

	public static void main(String[] args) {
		StudentController ctr = new StudentController();
		int score, menu = 1;
		String name;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("\n처리하려는 기능을 선택하세요.");
			System.out.println("1. 학생 정보 출력");
			System.out.println("2. 학생 정보 입력");
			System.out.println("3. 학생 정보 삭제");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 점수 확인");
			System.out.println("6. 종료");
			
			System.out.print("입력 : ");
			menu = Integer.parseInt(sc.nextLine());
			
			if(menu == 1) {
				ctr.printAll();
			} else if(menu == 2 || menu == 4) {
				System.out.print("이름을 입력해주세요: ");
				name = sc.nextLine();
				while(true) {
					System.out.print("점수를 입력해주세요: ");
					score = Integer.parseInt(sc.nextLine());
					if (score < 0 || score > 100) {
						System.out.println("0 ~ 100 사이의 점수를 입력해주세요");
					}else
						break;
				}
				if(menu == 2) 
					ctr.insert(name, score);
				else
					ctr.update(name, score);
			} else if(menu == 3 || menu == 5) {
				System.out.print("이름을 입력해주세요: ");
				name = sc.nextLine();
				if(menu == 3)
					ctr.delete(name);
				else
					ctr.printScore(name);
			} else if(menu == 6) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("1 ~ 6 사이의 번호를 입력해주세요.");
			}
			
		}
		
		sc.close();

	}
	

}
