package day12;


import java.io.InputStreamReader;

public class StandardInput2 {

	public static void main(String[] args) throws Exception{
		System.out.print("입력 : ");
		InputStreamReader isr = new InputStreamReader(System.in);
		
		char munja = (char)isr.read(); // 1문자 1byte만 읽어옴
		System.out.println("입력된 문자 : " + munja);
	}

}
