package aop07;

import org.springframework.stereotype.Component;

@Component(value = "emp")
public class EmpService implements Person{
	@Override
	public void work() {
		System.out.println("직원 서비스 진행");
	}
}
