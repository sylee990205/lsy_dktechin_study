package day16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class DeleteData1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		} 
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("delete from student where name = ?");
				Scanner scan = new Scanner(System.in);){
			System.out.print("학생 이름을 입력하세요 : ");
		    String name = scan.nextLine();
			pstmt.setString(1, name);
			int delNum = pstmt.executeUpdate();
			System.out.println("student 테이블에서 " + delNum + "행 삭제 완료");						
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} 
	}
}
