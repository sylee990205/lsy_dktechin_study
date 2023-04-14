package model.domain;

public class TimeVO {
	private int hour, minute;
	
	public TimeVO(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}
	
	
}
