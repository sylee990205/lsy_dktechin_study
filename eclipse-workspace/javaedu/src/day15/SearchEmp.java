package day15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchEmp {
	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		Connection conn = DriverManager.getConnection(url, user, passwd);
		Statement stmt = conn.createStatement();
		// like 'A%' A로 시작하는 문자열
		// like 'A_' A 뒤에 문자 1개가 있는 문자열
		// like '%A%' A가 포함된 문자열
		
		ResultSet rs = stmt.executeQuery("select ename, job, sal, deptno  from emp where ename like '%T%'");
		System.out.printf("%8s%8s%8s%4s\n", "성명", "직무", "급여", "부서");
		System.out.println("  -----------------------------------");
		while (rs.next()) {
				System.out.printf("%10s%12s%8d%4d\n", 
						rs.getString("ename"), rs.getString("job"), 
						rs.getInt("sal"), rs.getInt("deptno"));
		}
		rs.close();
		stmt.close();
		conn.close();
	}
}
