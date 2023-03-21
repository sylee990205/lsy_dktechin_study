package day12.excercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class FileOutLab {

	public static void main(String[] args) {
		String path = "C:/Temp";
		File isDir = new File(path);
		if(!isDir.exists())
			isDir.mkdirs();
		
		try(FileWriter writer = new FileWriter("C:/Temp/event.txt");){
			LocalDate day = LocalDate.of(2023, 5, 5);
			DayOfWeek eventDay = day.getDayOfWeek();
			String korEventDay = eventDay.getDisplayName(TextStyle.FULL, Locale.KOREAN);
			
			writer.write("2023년 5월 5일은 ");
			writer.write(korEventDay);
			writer.write("입니다.\n");
			
			day = LocalDate.of(2023, 6, 6);
			eventDay = day.getDayOfWeek();
			korEventDay = eventDay.getDisplayName(TextStyle.FULL, Locale.KOREAN);
			
			writer.write("2023년 6월 6일은 ");
			writer.write(korEventDay);
			writer.write("입니다.");
			
		}catch(IOException ioe) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
		
		System.out.println("저장이 완료되었습니다.");

	}

}
