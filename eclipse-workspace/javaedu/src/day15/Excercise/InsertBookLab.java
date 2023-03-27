package day15.Excercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBookLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		int count = 0;
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO book (title, price, kind) VALUES (?, ?, ?)");
				Scanner sc = new Scanner(System.in);){
			String title;
			int price, kind;
			String keep = "Y";
			while(keep.equalsIgnoreCase("Y")) {
				System.out.print("도서명을 입력하세요 : ");
				title = sc.nextLine();
				System.out.print("가격을 입력하세요 : ");
				price = Integer.parseInt(sc.nextLine());
				System.out.println("도서 분류에 대한 넘버를 입력하세요.");
				System.out.println("\t 1. 프로그래밍 언어");
				System.out.println("\t 2. 웹 프로그래밍");
				System.out.println("\t 3. 빅데이터");
				System.out.println("\t 4. 데이터베이스");
				System.out.println("\t 5. 인프라");
				while(true) {
					System.out.print("선택(1~5) : ");
					kind = Integer.parseInt(sc.nextLine());
					if(kind < 1 || kind > 5 ) {
						System.out.println("잘못된 번호를 입력했습니다. 1~5 중 입력해주세요.");
					}
					else {
						break;
					}
				}
				
				pstmt.setString(1, title);
				pstmt.setInt(2, price);
				pstmt.setString(3, "b0" + kind);
				pstmt.executeUpdate();
				
				System.out.println("정보가 입력되었습니다.");
				
				System.out.println("계속 입력하겠습니까?(y/n)");
				keep = sc.nextLine();
				count++;
			}
		}catch(SQLException se) {
			System.out.println("오류 발생!");
			se.printStackTrace();
		}catch (NumberFormatException e) {
			System.out.println("숫자 외 다른 데이터가 입력되었습니다. 프로그램을 다시 실행해주세요.");
		}
		
		System.out.println(count + "개의 데이터 입력 완료!");
		
	}

}
