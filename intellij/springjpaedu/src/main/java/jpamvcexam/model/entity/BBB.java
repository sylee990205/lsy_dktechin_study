package jpamvcexam.model.entity;

import jpamvcexam.model.vo.EmpVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BBB {
	@Id
	int id;
	private String username;
	// 연관관계 매핑
	@ManyToOne
	private EmpVO a;
	
	public BBB() {
		
	}

	public BBB(String username, EmpVO EmpVO) {
		super();
		this.username = username;
		a = EmpVO;
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

	public EmpVO getA() {
		return a;
	}

	public void setA(EmpVO EmpVO) {
		a = EmpVO;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", username=" + username + ", a=" + a + "]";
	}
}
