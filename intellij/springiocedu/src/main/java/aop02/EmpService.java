package aop02;

public class EmpService implements Person{
	@Override
	public void work() {
		System.out.println("직원 서비스 진행");
	}
}
