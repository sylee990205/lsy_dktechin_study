package jpamvcexam.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AAA {
	@Id
	int id;
	private String username;
	// 연관관계 매핑
	@ManyToOne
	private Team a;
	
	public AAA() {
	}

	public AAA(String username, Team team) {
		super();
		this.username = username;
		a = team;
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

	public Team getA() {
		return a;
	}

	public void setA(Team team) {
		a = team;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", a=" + a + "]";
	}
}
