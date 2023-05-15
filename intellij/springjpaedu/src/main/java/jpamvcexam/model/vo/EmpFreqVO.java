package jpamvcexam.model.vo;

public class EmpFreqVO {
	private int empno;
	private String ename;
	private java.util.Date  hiredate;
	private int sal;
	private Integer deptno;

	public EmpFreqVO() {}
	
	public EmpFreqVO(int empno, String ename, java.util.Date hiredate, int sal, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
		this.deptno = deptno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public java.util.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "EmpFreqVO [empno=" + empno + ", ename=" + ename + ", "
				+ "hiredate=" + String.format("%tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분",hiredate) 
				+ ", sal=" + sal + ", deptno=" + deptno + "]";
	}
	
}
