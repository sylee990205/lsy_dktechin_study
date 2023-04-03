package day15.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectBookLab {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "jdbctest";
		String passwd = "jdbctest";
		
		try(Connection conn = DriverManager.getConnection(url,user,passwd);
				Statement stmt = conn.createStatement();
				Scanner sc = new Scanner(System.in);){
			int id, price;
			String title, kind;
			String keep = "Y";
			int menu;
			ResultSet rs = null;
			
			while(keep.equalsIgnoreCase("Y")) {
				System.out.println("1. 모두 출력하기");
				System.out.println("2. 가격이 높은 순으로 출력하기");
				System.out.println("3. 20000원 이상의 도서들만 출력하기 ");
				System.out.println("4. 웹 프로그래밍 도서들만 출력하기");
				System.out.println("5. 데이터베이스와 인프라 도서들만 출력하기");
				System.out.println("6. 도서명에 '자바'를 포함하는 도서들만 출력하기");
				System.out.println("7. 분류별 도서 가격의 평균을 출력하기\n\n");
				
				System.out.print("원하는 메뉴의 번호를 선택 : ");
				menu = Integer.parseInt(sc.nextLine());
				
				switch(menu) {
				case 1:
					rs = stmt.executeQuery("SELECT id, title, price, kind FROM book");
					break;
				case 2:
					rs = stmt.executeQuery("SELECT id, title, price, kind FROM book ORDER BY price DESC");
					break;
				case 3:
					rs = stmt.executeQuery("SELECT title, price FROM book WHERE price >= 20000");
					break;
				case 4:
					rs = stmt.executeQuery("SELECT title, price FROM book WHERE kind LIKE '%2'");
					break;
				case 5:
					rs = stmt.executeQuery("SELECT title, price FROM book WHERE kind LIKE '%4' || kind LIKE '%5'");
					break;
				case 6:
					rs = stmt.executeQuery("SELECT title, price FROM book WHERE title LIKE '%자바%'");
					break;
				case 7:
					rs = stmt.executeQuery("SELECT RIGHT(kind, 1) kind, AVG(price) avg FROM book GROUP BY kind");
					break;
				default:
					System.out.println("잘못된 번호를 입력했습니다. 1~7 중 입력해주세요.");
					continue;
				}
				
				if(menu == 1 && menu == 2) {
					if(rs.next()) {
						do {
							id = rs.getInt("id");
							title = rs.getString("title");
							price = rs.getInt("price");
							kind = rs.getString("kind");
							
							System.out.printf("id : %d 제목: %s 가격: %,d원 분류번호: %s\n", id, title, price, kind);
						}while(rs.next());
					} else {
						System.out.println("데이터가 없습니다!");
					}
					
					
				} else if(menu == 7) {
					if(rs.next()) {
						do {
							String[] bookKind = new String[6];
							bookKind[1] = "프로그래밍 언어";
							bookKind[2] = "웹 프로그래밍";
							bookKind[3] = "빅데이터";
							bookKind[4] = "데이터베이스";
							bookKind[5] = "인프라";
							kind = rs.getString("kind");
							price = rs.getInt("avg");
				
							System.out.printf("%s 도서들의 가격 평균은 %,d원입니다.\n", bookKind[Integer.parseInt(kind)], price);
						} while(rs.next());
					} else {
						System.out.println("데이터가 없습니다!");
					}
				} else {
					if(rs.next()) {
						do {
							title = rs.getString("title");
							price = rs.getInt("price");
							
							System.out.printf("제목: %s 가격: %,10d원\n", title, price);
						}while(rs.next());
					} else {
						System.out.println("데이터가 없습니다!");
					}
				}
				
				System.out.print("\n\n다시 메뉴로 돌아가시겠습니까?(Y/N)");
				keep = sc.nextLine();
					
			}
			System.out.println("프로그램을 종료합니다!");
			rs.close();
			
		}catch(SQLException se) {
			System.out.println("오류 발생!");
			se.printStackTrace();
		}catch (NumberFormatException e) {
			System.out.println("숫자 외 다른 데이터가 입력되었습니다. 프로그램을 다시 실행해주세요.");
		}

	}

}
