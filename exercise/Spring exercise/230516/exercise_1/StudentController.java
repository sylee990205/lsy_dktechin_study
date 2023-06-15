package jpamvcexam.controller;

import jpamvcexam.model.dao.StudentDAO;
import jpamvcexam.model.vo.Student;

import java.util.List;

public class StudentController {
    private StudentDAO dao = new StudentDAO();

    public void printAll() {
        List<Student> studentList = dao.getAllStudent();
        if(studentList.isEmpty()){
            System.out.println("학생 리스트가 존재하지 않습니다.");
        }
        studentList.stream().forEach(System.out::println);
    }

    public void printScore(String name) {
        Student student = dao.getScore(name);
        if (student != null) {
            System.out.printf("%s 학생의 점수는 %d 입니다.\n", name, student.getScore());
        } else {
            System.out.println(name + " 학생은 존재하지 않습니다.");
        }
    }

    public void insert(String name, int score) {
        Student student = new Student();
        student.setName(name);
        student.setScore(score);
        if (dao.insertStudent(student)) {
            System.out.println("입력 성공");
        } else {
            System.out.println("입력 실패");
        }
    }

    public void update(String name, int score) {
        Student student = new Student();
        student.setName(name);
        student.setScore(score);
        if (dao.updateStudent(student)) {
            System.out.println(name + "학생의 점수를 변경했습니다.");
        } else {
            System.out.println(name + "학생은 존재하지 않습니다.");
        }
    }

    public void delete(String name) {
        if (dao.deleteStudent(name)) {
            System.out.println(name + "학생의 데이터를 삭제했습니다");
        } else {
            System.out.println(name + "학생은 존재하지 않습니다.");
        }
    }

    public void end(){
        dao.close();
    }
}
