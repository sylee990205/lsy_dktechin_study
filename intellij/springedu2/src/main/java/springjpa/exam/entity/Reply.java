package springjpa.exam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String content;
	@ManyToOne( optional = false ) 
	@JoinColumn(name="refid")
	private Meeting refid;

	@Override
	public String toString() {
		return "MeetingReplyVO [id=" + id + ", name=" + name + ", content=" +content + ", refid=" + refid + "]";
	}
	
}
