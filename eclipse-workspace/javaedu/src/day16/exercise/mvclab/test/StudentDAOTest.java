package day16.exercise.mvclab.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import day16.exercise.mvclab.model.StudentDAO;
import day16.exercise.mvclab.model.StudentDTO;
import day16.mvc.MySQLConnect;

@DisplayName("두 번째 JUnit 테스트 클래스")
class StudentDAOTest {
	
	StudentDAO dao = new StudentDAO();
	@DisplayName("SELECT 기능 체크")
	@Test
	void test_getAllStudent() {
		assertTrue(dao.getAllStudent().size() > 0);
	}
	
	@DisplayName("INSERT 기능 체크")
	@Test
	void test_insertStudent() {
		System.out.print("입력할 이름과 점수를 '이름:점수' 형식으로 입력하세요 : ");
		String inputStr = new Scanner(System.in).nextLine();
		String[] param = inputStr.split(":");
		StudentDTO dto = new StudentDTO();
		dto.setName(param[0]);
		dto.setScore(Integer.parseInt(param[1]));
		assertEquals(dao.insertStudent(dto), true);
	}

}
