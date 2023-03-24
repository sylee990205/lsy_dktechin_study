package day14.excercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CheckEmpLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		
		try(Connection conn = DriverManager.getConnection(url,user,passwd);
				Statement stmt = conn.createStatement();){
			Scanner sc = new Scanner(System.in);
			String keep = "Y";
			String inputName;
			String sql;
			ResultSet rs = null;
			while(keep.equalsIgnoreCase("Y")) {
				System.out.print("검색하려는 직원의 이름을 입력해주세요: ");
				inputName = sc.next();
				// 만약 쿼리에서 문자열 출력 시 "를 사용하려면 \" 의 형식으로 사용해야함
				sql = "SELECT ename, DATE_FORMAT(hiredate, '%Y년 %m월') hiredate, deptno FROM emp WHERE ename LIKE '" + inputName + "'";
				
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					do {
						System.out.println(inputName + "직원은 근무중입니다.");
						System.out.printf("%s에 입사했고 현재 %d번 부서에서 근무하고 있습니다.\n", rs.getString("hiredate"), rs.getInt("deptno"));
					} while (rs.next());
				}else {
					System.out.println(inputName + "직원은 근무하지 않습니다.");
				}
				
				
//				while(rs.next()) {
//					name = rs.getString("ename");
//					if(inputName.equalsIgnoreCase(name)) {
//						break;
//					}else {
//						name = null;
//					}
//				}
//				
//				if(name != null) {
//					System.out.println(name + "직원은 근무중입니다.");
//					System.out.printf("%s에 입사했고 현재 %d번 부서에서 근무하고 있습니다.", rs.getString("hiredate"), rs.getInt("deptno"));
//				} else {
//					System.out.println(inputName + "직원은 근무하지 않습니다.");
//				}
				
				System.out.println("계속 검색하시겠습니까? (Y/N)");
				keep = sc.next();
			}
			
			
			rs.close();
			sc.close();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}

	}

}
