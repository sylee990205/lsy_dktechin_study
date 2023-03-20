package day11;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateTimeTest {

	public static void main(String[] args) throws Exception {
		Date d = new Date(); //현재 시스템 시간을 argument로 하여 객체가 생성됨
		System.out.println(d.toString());
		System.out.println(d.getTime()); //1970년 1월 1일 0시부터 몇초가 지났는지, 70년도 이전은 -로 표기, time stamp 시간
		

		GregorianCalendar gc = new GregorianCalendar(); 
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK)); //요일 (일요일 시작)
		gc = new GregorianCalendar(2023, 2, 31);// 설정시 월은 0이 1월 11은 12월 
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK));

		System.out.println(timeToStrDate(new Date().getTime()));
		System.out.println(parseStrDate("2019년 01월 01일"));

		LocalDate currentDate = LocalDate.now();
		LocalDate targetDate = LocalDate.of(2023, 7, 26);
		System.out.println(currentDate.getDayOfWeek());
		System.out.println(currentDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		System.out.println(currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));		
		System.out.println(targetDate.getDayOfWeek());
		System.out.println(targetDate.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		System.out.println(targetDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
		
		LocalTime currentTime = LocalTime.now(); //시간
		LocalTime targetTime = LocalTime.of(9, 10, 20);
		System.out.println(currentTime);
		System.out.println(targetTime);

		LocalDateTime currentDateTime = LocalDateTime.now(); //날짜, 시간
		LocalDateTime targetDateTime = LocalDateTime.of(2023, 12, 25, 12, 30);
		System.out.println(currentDateTime);
		System.out.println(targetDateTime);
	}

	public static String timeToStrDate(long time) {
		DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy"); //내가 원하는 날짜 형식 지정
																	// 분도 m을 사용하기에 날짜는 MM, 분은 mm
		return formatter.format(time);
	}

	public static Date parseStrDate(String strDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");
		return formatter.parse(strDate);
	}

}
