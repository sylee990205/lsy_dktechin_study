package jpamvcexam.model.vo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String title;
	private LocalDateTime  meetingDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(LocalDateTime meetingDate) {
		this.meetingDate = meetingDate;
	}
	@Override
	public String toString() {
		return "MeetingVO [id=" + id + ", name=" + name + ", title=" + title + ", meetingDate=" + meetingDate + "]";
	}	
}
