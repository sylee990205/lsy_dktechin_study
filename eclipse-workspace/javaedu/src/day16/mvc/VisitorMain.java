package day16.mvc;

import java.util.List;
import java.util.Scanner;

public class VisitorMain {
	public static void main(String[] args) {
		VisitorDAO crud = new VisitorDAO();
		Scanner scan = new Scanner(System.in);
		loop: while (true) {
			System.out.println("[ DB 연동 메뉴 선택 ]");
			System.out.println("1. 방명록 작성"); //C
			System.out.println("2. 방명록 읽기"); //R
			System.out.println("3. 방명록 수정"); //U
			System.out.println("4. 방명록 삭제"); //D
			System.out.println("5. 방명록 종료");
			System.out.print("입력 : ");
			String aws = "";
			aws = scan.nextLine();
			List<VisitorDTO> vlist = null;
			int id = 0;
			switch (aws) {
			case "1":
				if (crud.c(scan))
					System.out.println("visitor 테이블에 데이터 삽입 작업 완료");
				break;
			case "2":
				vlist = crud.r();
				for (VisitorDTO dto : vlist)
					System.out.println(dto);
				break;
			case "3":
				vlist = crud.r();
				for (VisitorDTO dto : vlist)
					System.out.println(dto);
				System.out.print("수정하려는 글의 번호를 입력하세요 : ");
				id = Integer.parseInt(scan.nextLine());
				if (crud.u(scan, id))
					System.out.println("visitor 테이블의 데이터 수정 작업 완료");
				break;
			case "4":
				vlist = crud.r();
				for (VisitorDTO dto : vlist)
					System.out.println(dto);
				System.out.print("삭제하려는 글의 번호를 입력하세요 : ");
				id = Integer.parseInt(scan.nextLine());
				if(crud.d(id))
					System.out.println("visitor 테이블의 데이터 삭제 작업 완료");
				break;
			case "5":
				break loop;
			}
		}
		System.out.println("방명록 애플리케이션을 종료합니다.");
	}
}
