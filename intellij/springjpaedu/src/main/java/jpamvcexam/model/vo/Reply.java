package jpamvcexam.model.vo;

import javax.persistence.*;

@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String content;
	@ManyToOne(optional = false) // optional false -> 반드시 필수적으로 지정해야한다는 의미
	@JoinColumn(name = "refid")
	private Meeting refid;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	public Meeting getRefid() {
		return refid;
	}
	public void setRefid(Meeting refid) {
		this.refid = refid;
	}
	@Override
	public String toString() {
		return "MeetingReplyVO [id=" + id + ", name=" + name + ", content=" +content + ", refid=" + refid + "]";
	}
	
}
