package day12;

public class StandardInput {

	public static void main(String[] args) throws Exception{
		System.out.print("입력 : ");
		char munja = (char)System.in.read(); // 1문자 1byte만 읽어옴
		System.out.println("입력된 문자 : " + munja);
	}

}
