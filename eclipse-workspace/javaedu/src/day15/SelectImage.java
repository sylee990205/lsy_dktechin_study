package day15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectImage {
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
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn.prepareStatement("SELECT filename, imgcontent FROM imgtest WHERE filename = ?");) {
			System.out.print("읽으려는 이미지의 파일명을 입력하세요 : ");
			String name = scan.nextLine();
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String imgName[] = rs.getString("filename").split("\\."); 
				// 파일 경로 split 시 왜 .만 작성하지않고 \\.이라고 작성했을까?
				// split 메소드는 정규표현식을 우선으로 인식하기때문에 .을 우리가 아는 .으로 인식하지 못함
				// 정규표현식이 아닌 문자의 고유내용을 인식하고자하면 \\를 붙여야함
				
				File imgFile = new File("c:/Temp/"+imgName[0]+new Date().getTime()+"."+imgName[1]);
				InputStream is = rs.getBinaryStream("imgcontent");
				FileOutputStream fos = new FileOutputStream(imgFile);
				byte[] b = new byte[2048];
				int n;
				while ((n = is.read(b)) > 0) {
					fos.write(b, 0, n);
				}
				fos.close();
			} else {
				System.out.print(name + "이라는 파일명으로 저장된 이미지가 존재하지 않습니다. ");
			}
			System.out.println("이미지 읽기 성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
