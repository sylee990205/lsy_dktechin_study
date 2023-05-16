package jpamvcexam.mainview;

import jpamvcexam.controller.StudentController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentApp {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StudentController studentController = new StudentController();
        int menu;
        String name;
        int score;

        while (true) {
            System.out.println("처리하려는 기능을 선택하세요.");
            System.out.println("1. 학생 정보 출력");
            System.out.println("2. 학생 정보 입력");
            System.out.println("3. 학생 정보 삭제");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학생 점수 확인");
            System.out.println("6. 종료");
            System.out.print("입력 : ");
            menu = Integer.parseInt(bufferedReader.readLine());

            if(menu == 1) {
                studentController.printAll();
            } else if (menu == 2 || menu == 4) {
                System.out.print("학생 이름 : ");
                name = bufferedReader.readLine();
                System.out.print("학생 점수 : ");
                score = Integer.parseInt(bufferedReader.readLine());
                if (menu == 2){
                    studentController.insert(name, score);
                } else {
                    studentController.update(name, score);
                }
            } else if (menu == 3) {
                System.out.print("삭제할 학생 이름 : ");
                name = bufferedReader.readLine();
                studentController.delete(name);
            } else if (menu == 5) {
                System.out.print("점수를 확인하고 싶은 학생 이름 : ");
                name = bufferedReader.readLine();
                studentController.printScore(name);
            } else if (menu == 6) {
                System.out.println("프로그램을 종료합니다.");
                studentController.end();
                break;
            } else {
                System.out.println("잘못된 번호를 입력했습니다. 1 ~ 6 중에 입력해주세요.");
            }
        }

    }
}
