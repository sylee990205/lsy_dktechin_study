package jpamvcexam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Team {
	@Id
	@Column(name = "TEAM_ID")	
	private String id;
	private String teamName;	
	
	public Team() {
		
	}

	public Team(String id, String teamName) {
		super();
		this.id = id;
		this.teamName = teamName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + "]";
	}
}
