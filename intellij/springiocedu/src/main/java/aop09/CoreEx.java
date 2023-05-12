package aop09;

import org.springframework.stereotype.Component;

@Component("core")
public class CoreEx {
	public void zeroMethod(int a, int b) throws Exception {
		try {
			System.out.println(a + "/" + b + "=" + (a/b));
		}catch(Exception e) {
			throw new RuntimeException("0으로 나눌수 없습니다.");
		}
	}
}
