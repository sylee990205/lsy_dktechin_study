package springjpa.exam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {
	@Id
	@Column(name = "MEMBER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	// 연관관계 매핑
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
	
	public Member() {
		
	}
	public Member(String username, Team team) {
		super();
		this.username = username;
		this.team = team;
	}	
}
