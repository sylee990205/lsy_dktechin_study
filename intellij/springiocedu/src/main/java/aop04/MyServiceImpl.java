package aop04;

import java.util.Random;

public class MyServiceImpl implements MyService {
	@Override
	public int work1() {
		System.out.println("핵심 로직1");
		int result = 0;
		//try {
			if (new Random().nextBoolean())
				result =  10 / 2;
			else
				result =  10 / 0;
		//} catch(Exception e) {
		//	System.out.println("예외 : "+e.getMessage());
		//}
		return result;
	}

	@Override
	public void work2() {
		System.out.println("핵심 로직2");
	}

	@Override
	public char work3() {
		System.out.println("핵심 로직3");
		return 'A';
	}
}
