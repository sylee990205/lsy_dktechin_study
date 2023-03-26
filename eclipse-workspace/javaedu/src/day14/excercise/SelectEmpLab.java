package day14.excercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Statement stmt = conn.createStatement();){
				boolean random = new Random().nextBoolean();
				String sql;
				ResultSet rs = null;
				if (random) {
					sql = "SELECT ename, sal FROM emp";
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						System.out.printf("%s 직원의 월급은 %,d달러입니다.\n", rs.getString("ename"), rs.getInt("sal"));
					}
				} else {
					sql = "SELECT ename, DATE_FORMAT(hiredate, '%Y년 %m월 %d일') hiredate FROM emp ORDER BY hiredate";
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						System.out.printf("%s 직원은 %s에 입사하였습니다.\n", rs.getString("ename"), rs.getString("hiredate"));
					}
				}
				rs.close();
			
		}catch (SQLException se) {
			se.printStackTrace();
		}

	}

}
