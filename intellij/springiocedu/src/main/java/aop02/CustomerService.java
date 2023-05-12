package aop02;

public class CustomerService implements Person{
	@Override
	public void work() {
		System.out.println("고객 서비스 진행");
	}
}
