package day16.exercise.mvclab.controller;

import java.util.List;

import day16.exercise.mvclab.model.StudentDAO;
import day16.exercise.mvclab.model.StudentDTO;

public class StudentController {
	public void printAll() {
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> slist = dao.getAllStudent();
		for (StudentDTO sdto : slist) {
			System.out.println("이름: " + sdto.getName() + ", 점수: " + sdto.getScore());
		}
	}
	
	public void printScore(String name) {
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		int score = dao.getScore(dto);
		if (score == -1) {
			System.out.println(name + " 학생은 존재하지 않습니다.");
		}else {
			System.out.println(name + " 학생의 점수는 " + score +" 입니다.");
		}
	}
	
	public void insert(String name, int score) {
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		dto.setScore(score);
		if (dao.insertStudent(dto))
			System.out.println("입력 성공");
		else
			System.out.println("입력 실패");
	}
	
	public void update(String name, int score) {
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		dto.setScore(score);
		
		if(dao.updateStudent(dto))
			System.out.println(name + " 학생의 점수를 변경했습니다.");
		else
			System.out.println(name + " 학생은 존재하지 않습니다.");
	}
	
	public void delete(String name) {
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = new StudentDTO();
		dto.setName(name);
		
		if(dao.deleteStudent(dto))
			System.out.println(name + " 학생의 데이터를 삭제했습니다.");
		else
			System.out.println(name + " 학생은 존재하지 않습니다.");
		
	}
	
	
}
