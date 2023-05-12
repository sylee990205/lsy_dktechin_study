package aop14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;
@Component("ds14")
public class DayServiceImpl implements DayService {
	GregorianCalendar cal;
	@Autowired
	public DayServiceImpl(GregorianCalendar cal) {
		this.cal = cal;
	}
	public int getYear() {
		return cal.get(Calendar.YEAR);
	}
	public String getDay() {
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int month = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("오늘은 " + month + "월 " + 
		                                   date + "일 입니다!!");
		switch (day) {
		case 1:
			return "일요일";
		case 2:
			return "월요일";
		case 3:
			return "화요일";
		case 4:
			return "수요일";
		case 5:
			return "목요일";
		case 6:
			return "금요일";
		default:
			return "토요일";
		}
	}
	public void errorTest() {
		int result = 100/0;
		System.out.println(result);
	}
}





