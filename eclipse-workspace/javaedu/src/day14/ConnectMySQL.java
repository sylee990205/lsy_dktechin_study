package day14;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
	public static void main(String[] args) {
		// 기존의 JDBC는 드라이버를 로딩하지 않으면 아예 실행할 수 없었으나 
		// JDK6부터 드라이버를 자동으로 찾기때문에 해당 구간 구현을 하지 않아도 괜찮음
		// 그러나 거의 대부분 드라이버를 로딩하고 시작
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException cnfe) {
//			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
//			return;
//		} 
		
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);){
			DatabaseMetaData md = conn.getMetaData();
			System.out.println("DBMS 서버 명 : "+md.getDatabaseProductName());
			System.out.println("DBMS 서버 버전 : "+md.getDatabaseProductVersion());
			System.out.println("사용자명 : "+md.getUserName()); 						
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
