package jpamvcexam.model.entity;

import javax.persistence.*;

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
	private Team team; // 이 필드가 참조하게 되는 또 다른 entity 객체의 타입
	
	public Member() {
		
	}

	public Member(String username, Team team) {
		super();
		this.username = username;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", team=" + team + "]";
	}
}
