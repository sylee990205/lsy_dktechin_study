package day12.exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CopyLab {

	public static void main(String[] args) {
		LocalDate currentTime = LocalDate.now();
		int year = currentTime.getYear();
		int month = currentTime.getMonthValue();
		int day = currentTime.getDayOfMonth();
		
		
		try(FileReader reader = new FileReader("C:/iotest/sample.txt");
				FileWriter writer = 
						new FileWriter(String.format("C:/iotest/sample_%d_%d_%d.txt", year, month, day), true);){
			
			
			while (true) {
				int data = reader.read();
				if(data == -1)
					break;
				char ch = (char) data;
				writer.append(ch);
			}
			
			writer.append("\n\n");
			
			
			
			
			
		} catch(FileNotFoundException fnfe) {
			System.out.println("sample.txt 파일을 찾을 수 없습니다.");
		} catch(IOException ioe) {
			System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
		}
		System.out.println("저장이 완료되었습니다.");
	}

}
