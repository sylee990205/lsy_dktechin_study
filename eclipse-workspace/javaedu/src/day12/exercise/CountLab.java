package day12.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountLab {

	public static void main(String[] args) {
		File yesterday = new File("C:/iotest/yesterday.txt");
		try(Scanner scan = new Scanner(yesterday);){
			int count = 0;
			while(scan.hasNext()) {
				
				if(scan.next().contains("yesterday")) {
					count++;
				}
				
			}
			
			System.out.printf("yesterday 라는 단어는 %d개 있습니다.\n", count);
			
		}catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		}					
	}

}
