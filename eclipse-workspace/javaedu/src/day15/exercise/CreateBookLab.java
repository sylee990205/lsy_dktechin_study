package day15.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateBookLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		
		try(Connection conn = DriverManager.getConnection(url,user,passwd);
				Statement stmt = conn.createStatement();){
				stmt.executeUpdate("CREATE TABLE book "
						+ "(id int primary key auto_increment, "
						+ "title varchar(90), "
						+ "price int, "
						+ "kind char(3))");
				
				System.out.println("book 테이블 생성 완료!");
			
		}catch (SQLException se) {
			System.out.println("오류 발생!");
			se.printStackTrace();
		}

	}

}
