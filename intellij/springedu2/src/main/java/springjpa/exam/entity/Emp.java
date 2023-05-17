package springjpa.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Emp {
	@Id
	private int empno;
	private String ename;
	private String job;
	private String mgr;
	private java.sql.Date  hiredate;
	private int sal;
	private Integer comm;
	private Integer deptno;
}
